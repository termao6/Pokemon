
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
        super(lev, 48, 65, 43, 44);
        attacks.add(new Move("Tackle", "Normal", 35));
        attacks.add(new Move("Tail Whip", "Normal", 0));
        if (level>=9)
            attacks.add(new Move("Bubble", "Water", 20));

        setType("Water");
    }

    public void gainLevel() {
        super.gainLevel();
        if (level==9)
            attacks.add(new Move("Bubble", "Water", 20));

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
