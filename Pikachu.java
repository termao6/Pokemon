
/**
 * Write a description of class Pikachu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
public class Pikachu
{
    private int level, EXP;
    private int HPFull, HPBattle, attack, defense;
    private List<Move> attacks = new ArrayList<Move>();
    public Pikachu (int lev){
        attacks.add(new Move("Thunder Shock", "Electric", 40));
        attacks.add(new Move("Growl", "Normal", 0));
        level = lev;
        attack = (int) (Math.random()*(level/4)) + 15;
        defense = (int) (Math.random()*(level/5)) + 12;
        HPFull = (int) (Math.random()*(level/3)) + 16;
        HPBattle = HPFull;
    }
    public void gainEXP (int points){
        EXP += points;
        if (EXP/3 > level) {
            level++;
            attack += (int) (Math.random()*(level/4));
            defense = (int) (Math.random()*(level/5));
            HPFull = (int) (Math.random()*(level/3));
            HPBattle = HPFull;
        }
    }
}
