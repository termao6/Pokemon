
/**
 * Write a description of class Pikachu here.
 * 
 * @author (your name) Teresa Mao, Amber Hu
 * @version (a version number or a date) 5/18/2015
 */

import java.util.*;
public class Pidgey extends Pokemon
{
    private int level, EXP;
    private int HPFull, HPBattle, attack, defense, speed;
    private List<Move> attacks = new ArrayList<Move>();
    public Pidgey (int lev){
        super(lev);
        attacks.add(new Move("Gust", "Normal", 40));
        attacks.add(new Move("Sand Attack", "Normal", 0));
        HPFull = (int) (Math.random()*(level/3.5)) + (int) ((40.0/9) * (double) lev);
        attack = (int) (Math.random()*(level/4.5)) + (int) ((45.0/17) * (double) lev);
        defense = (int) (Math.random()*(level/5)) + (int) ((45.0/17) * (double) lev);
        speed = (int) (Math.random()*(level/4)) + (int) ((56.0/17) * (double) lev);
        
        setType("Normal");
        setHP(HPFull);
        setAttack(attack);
        setDefense(defense);
        setSpeed(speed);
    }
    public void gainEXP(int points) {
        EXP += points;
        if ((EXP-level)/2.5 > level) {
            level++;
            HPFull += (int) (Math.random()*(level/3.5));
            attack += (int) (Math.random()*(level/4.5));
            defense += (int) (Math.random()*(level/5));
            speed += (int) (Math.random()*(level/4));
            HPBattle = HPFull;
        }
    }
    public List<Move> getListOfAttacks() {
        return attacks;
    }
    public int giveEXP() {
        return (int) (Math.pow(level, 1.7)*5);
    }
    public String getName() {
        return "PIDGEY";
    }
}
