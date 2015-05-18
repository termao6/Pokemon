
/**
 * Write a description of class Pikachu here.
 * 
 * @author (your name) Teresa Mao, Amber Hu
 * @version (a version number or a date) 5/18/2015
 */

import java.util.*;
public class Charmander implements Pokemon
{
    private int level, EXP;
    private int HPFull, HPBattle, attack, defense;
    private List<Move> attacks = new ArrayList<Move>();
    public Charmander (int lev){
        attacks.add(new Move("Thunder Shock", "Electric", 40));
        attacks.add(new Move("Growl", "Normal", 0));
        level = lev;
    }
    public void gainEXP() {
        
    }
    public List<Move> getListOfAttacks() {
        return attacks;
    }
    
}
