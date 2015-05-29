
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
        super(lev, 52, 48, 65, 39);
        attacks.add(new Move("Scratch", "Normal", 40));
        attacks.add(new Move("Growl", "Normal", 0));
        if (level>=9)
            attacks.add(new Move("Ember", "Fire", 40));
        setType("Fire");
    }

    public void gainEXP(int points) {
        super.gainLevel();
        if (level==9)
            attacks.add(new Move("Ember", "Fire", 40));

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
