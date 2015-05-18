
/**
 * Write a description of class Pikachu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
public class Squirtle implements Pokemon
{
    private int level, EXP;
    private int HPFull, HPBattle, attack, defense;
    private List<Move> attacks = new ArrayList<Move>();
    public Squirtle (int lev){
        attacks.add(new Move("Tackle", "Normal", 35));
        attacks.add(new Move("Tail Whip", "Normal", 0));
        level = lev;
    }
    public void gainEXP() {
        
    }
    public List<Move> getListOfAttacks() {
        return attacks;
    }
    
}
