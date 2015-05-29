
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
        super(lev, 45, 45, 56, 40);
        attacks.add(new Move("Tackle", "Normal", 35));
        attacks.add(new Move("Sand Attack", "Normal", 0));
        if (level>=9)
            attacks.add(new Move("Gust", "Normal", 40));
        setType("Normal");
    }

    public void gainLevel() {
        super.gainLevel();
        if (level==9)
            attacks.add(new Move("Gust", "Normal", 40));

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
        return (int) (Math.pow(getLevel(), .9)*3);
    }

    public String getName() {
        return ("PIDGEY" + " (Lv " + getLevel() + ")");
    }
}
