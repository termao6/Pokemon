
/**
 * Write a description of class Battle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Battle
{
    Trainer t;
    Pokemon opponent;
    Pokemon current;
    
    public Battle(Trainer t2, Pokemon cur, Pokemon opp)
    {
        t = t2;
        current = cur;
        opponent = opp;
    }

    public void attack(Pokemon attacker, Pokemon attacked)
    {
        
    }
    
    public void catchPokemon() 
    {
        
    }
    
    public void switchPokemon(int ind)
    {
        current = t.getList().get(ind);
    }
}
