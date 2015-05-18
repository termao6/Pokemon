
/**
 * Write a description of class Pikachu here.
 * 
 * @author (your name) Teresa Mao, Amber Hu
 * @version (a version number or a date)
 */

import java.util.*;
public class Bulbasaur implements Pokemon
{
    private int level, EXP;
    private int HPFull, HPBattle, attack, defense;
    private List<Move> attacks = new ArrayList<Move>();
    public Bulbasaur (int lev){
        attacks.add(new Move("Tackle", "Normal", 35));
        attacks.add(new Move("Growl", "Normal", 0));
        level = lev;
        attack = (int) (Math.random()*(level/4)) + 15;
        defense = (int) (Math.random()*(level/5)) + 12;
        HPFull = (int) (Math.random()*(level/3)) + 16;
        HPBattle = HPFull;
    }
    public void gainEXP() {
        
    }
    public List<Move> getListOfAttacks() {
        return attacks;
    }
    
}
