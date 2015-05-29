
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
        super(lev, 45, 49, 49, 45);
        attacks.add(new Move("Tackle", "Normal", 35));
        attacks.add(new Move("Growl", "Normal", 0));
        if (level>=9)
            attacks.add(new Move ("Vine Whip", "Grass", 35));

        setType("Grass");
    }

    public void gainLevel() {
        super.gainLevel();
        if (getLevel()==9)
            attacks.add(new Move ("Vine Whip", "Grass", 35));
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
        return ("BULBASAUR" + " (Lv " + getLevel() + ")");
    }
}
