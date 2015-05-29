
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
        super(lev, 55, 30, 90, 35);

        attacks.add(new Move("Thunder Shock", "Electric", 40));
        attacks.add(new Move("Growl", "Normal", 0));
        if (level>=9)
            attacks.add(new Move("Quick Attack", "Normal", 45));

        setType("Electric");
    }

    public void gainLevel (){
        gainLevel();
        if (getLevel()>=9)
            attacks.add(new Move("Quick Attack", "Normal", 45));

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
        return ("PIKACHU" + " (Lv " + getLevel() + ")");
    }
}
