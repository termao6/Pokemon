
/**
 * Write a description of class Pikachu here.
 * class to create a Pikachu object
 * @author (your name) Teresa Mao, Amber Hu
 * @version (a version number or a date) 5/18/2015
 */

import java.util.*;
public class Pikachu extends Pokemon
{
    private int level, EXP;
    private int HPFull, HPBattle, attack, defense, speed;
    private String type;
    private List<Move> attacks = new ArrayList<Move>();
    public Pikachu (int lev){
        super(lev);
       
        attacks.add(new Move("Thunder Shock", "Electric", 40));
        attacks.add(new Move("Growl", "Normal", 0));
        HPFull = (int) (Math.random()*(level/4)) + (int) ((35.0/9) * (double) lev);
        attack = (int) (Math.random()*(level/4)) + (int) ((55.0/17) * (double) lev);
        defense = (int) (Math.random()*(level/6)) + (int) ((30.0/17) * (double) lev);
        speed = (int) (Math.random()*(level/2.5)) + (int) ((90.0/17) * (double) lev);
        
        setType("Electric");
        setHP(HPFull);
        setAttack(attack);
        setDefense(defense);
        setSpeed(speed);
    }
    public void gainEXP (int points){
        EXP += points;
        if ((EXP-level)/3 > level) {
            level++;
            HPFull += (int) (Math.random()*(level/3));
            attack += (int) (Math.random()*(level/4));
            defense += (int) (Math.random()*(level/5));
            speed += (int) (Math.random()*(level/3));
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
        return ("PIKACHU" + " (Lv " + getLevel() + ")");
    }
}
