
/**
 * Write a description of class Pikachu here.
 * 
 * @author (your name) Teresa Mao, Amber Hu
 * @version (a version number or a date) 5/18/2015
 */

import java.util.*;
public class Squirtle extends Pokemon
{
    private int level, EXP;
    private int HPFull, HPBattle, attack, defense, speed;
    private List<Move> attacks = new ArrayList<Move>();
    public Squirtle (int lev){
        super(lev);
        attacks.add(new Move("Tackle", "Normal", 35));
        attacks.add(new Move("Tail Whip", "Normal", 0));
        HPFull = (int) (Math.random()*(level/3)) + (int) ((44.0/9) * (double) lev);
        attack = (int) (Math.random()*(level/4)) + (int) ((48.0/17) * (double) lev);
        defense = (int) (Math.random()*(level/3.5)) + (int) ((65.0/17) * (double) lev);
        speed = (int) (Math.random()*(level/4.5)) + (int) ((43.0/17) * (double) lev);
        
        setType("Water");
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
            defense += (int) (Math.random()*(level/3.5));
            speed += (int) (Math.random()*(level/4.5));
            HPBattle = HPFull;
        }
    }
    public List<Move> getListOfAttacks() {
        return attacks;
    }
    public String movesToString() {
        String m = "";
        for (Move mov : attacks) {
            m += mov.getName() + "\n";
        }
        return m;
    }
    public String getName() {
        return ("SQUIRTLE" + " (Lv " + getLevel() + ")");
    }
}
