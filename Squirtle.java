
/**
 * Write a description of class Pikachu here.
 * 
 * @author (your name) Teresa Mao, Amber Hu
 * @version (a version number or a date) 5/18/2015
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
