
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
        
        setType("Normal");
        setHP(40);
        setAttack(45);
        setDefense(45);
        setSpeed(56);
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
    public String movesToString() {
        String m = "";
        int ctr = 1;
        for (Move mov : attacks) {
            m += ctr + " " + mov.getName() + "\n";
            ctr++;
        }
        return m;
    }
    public int giveEXP() {
        return (int) (Math.pow(level, 1.7)*5);
    }
    public String getName() {
        return ("PIDGEY" + " (Lv " + getLevel() + ")");
    }
}
