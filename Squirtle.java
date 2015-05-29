
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
        
        setType("Water");
        setHP(44);
        setAttack(48);
        setDefense(65);
        setSpeed(43);
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
        int ctr = 1;
        for (Move mov : attacks) {
            m += ctr + " " + mov.getName() + "\n";
            ctr++;
        }
        return m;
    }
    public String getName() {
        return ("SQUIRTLE" + " (Lv " + getLevel() + ")");
    }
}
