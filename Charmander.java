
/**
 * Write a description of class Pikachu here.
 * 
 * @author (your name) Teresa Mao, Amber Hu
 * @version (a version number or a date) 5/18/2015
 */

import java.util.*;
public class Charmander extends Pokemon
{
    private int level, EXP;
    private int HPFull, HPBattle, attack, defense, speed;
    private List<Move> attacks = new ArrayList<Move>();
    public Charmander (int lev){
        super(lev);
        attacks.add(new Move("Scratch", "Normal", 40));
        attacks.add(new Move("Growl", "Normal", 0));
        HPFull = (int) (Math.random()*(level/3.5)) + (int) ((39.0/9) * (double) lev);
        attack = (int) (Math.random()*(level/4)) + (int) ((52.0/17) * (double) lev);
        defense = (int) (Math.random()*(level/4.5)) + (int) ((48.0/17) * (double) lev);
        speed = (int) (Math.random()*(level/3.5)) + (int) ((65.0/17) * (double) lev);
        
        setType("Grass");
        setHP(HPFull);
        setAttack(attack);
        setDefense(defense);
        setSpeed(speed);
    }
    public void gainEXP(int points) {
        EXP += points;
        if (EXP/3 > level) {
            level++;
            attack += (int) (Math.random()*(level/3.5));
            defense += (int) (Math.random()*(level/4));
            HPFull += (int) (Math.random()*(level/4.5));
            speed += (int) (Math.random()*(level/3.5));
            HPBattle = HPFull;
        }
    }
    public List<Move> getListOfAttacks() {
        return attacks;
    }
    
}
