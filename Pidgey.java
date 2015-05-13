
/**
 * Write a description of class Pikachu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
public class Pidgey implements Pokemon
{
    private int level, EXP;
    private int HPFull, HPBattle, attack, defense;
    private List<Move> attacks = new ArrayList<Move>();
    public Pidgey (int lev){
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
