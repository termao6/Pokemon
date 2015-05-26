
/**
 * Write a description of class Pikachu here.
 * 
 * @author (your name) Teresa Mao, Amber Hu
 * @version (a version number or a date)
 */

import java.util.*;
public class Bulbasaur extends Pokemon
{
    private int level, EXP;
    private int HPFull, HPBattle, attack, defense, speed;
    private List<Move> attacks = new ArrayList<Move>();
    public Bulbasaur (int lev){
        super(lev);
        attacks.add(new Move("Tackle", "Normal", 35));
        attacks.add(new Move("Growl", "Normal", 0));
        HPFull = (int) (Math.random()*(level/3)) + (int) ((45.0/9) * (double) lev);
        attack = (int) (Math.random()*(level/4)) + (int) ((49.0/17) * (double) lev);
        defense = (int) (Math.random()*(level/4)) + (int) ((49.0/17) * (double) lev);
        speed = (int) (Math.random()*(level/4.5)) + (int) ((45.0/17) * (double) lev);
        
        setType("Grass");
        setHP(HPFull);
        setAttack(attack);
        setDefense(defense);
        setSpeed(speed);
    }
    public void gainEXP(int points) {
        EXP += points;
        if ((EXP-level)/3 > level) {
            level++;
            HPFull += (int) (Math.random()*(level/3));
            attack += (int) (Math.random()*(level/4));
            defense += (int) (Math.random()*(level/4));
            speed += (int) (Math.random()*(level/4.5));
            HPBattle = HPFull;
        }
    }
    public List<Move> getListOfAttacks() {
        return attacks;
    }
    public String getName() {
        return ("BULBASAUR" + " (Lv " + getLevel() + ")");
    }
}
