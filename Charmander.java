
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
        
        setType("Fire");
        setHP(39);
        setAttack(52);
        setDefense(48);
        setSpeed(65);
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
    public String movesToString() {
        String m = "";
        int ctr = 1;
        for (Move mov : attacks) {
            m += ctr + " " + mov.getName() + "\n";
            ctr++;
        }
        return m;
    }
    public String getName() {
        return ("CHARMANDER" + " (Lv " + getLevel() + ")");
    }
}
