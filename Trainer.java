
/**
 * Write a description of class Trainer here.
 * 
 * @author (your name) Teresa Mao, Amber Hu
 * @version (a version number or a date) 5/18/2015
 */
import java.util.*;
public class Trainer
{
    // instance variables - replace the example below with your own
    private List<Pokemon> list;
    public Trainer(List<Pokemon> l)
    {
        list = l;
    }
    
    public void caughtPokemon(Pokemon poke) {
        list.add(poke);
    }
    
    public List<Pokemon> getList()
    {
        return list;
    }
}
