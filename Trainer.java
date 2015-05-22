
/**
 * Write a description of class Trainer here.
 * trainer in battle that contains a list of pokemon
 * @author (your name) Teresa Mao, Amber Hu
 * @version (a version number or a date) 5/18/2015
 */
import java.util.*;
public class Trainer
{
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
