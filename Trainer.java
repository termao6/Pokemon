
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
    public Trainer(Pokemon starter)
    {
        list.add(starter);
    }
    
    public void caughtPokemon(Pokemon poke) {
        list.add(poke);
    }
    
    public List<Pokemon> getList()
    {
        return list;
    }
    
    /**
     * returns name and level of all of Trainer's pokemon
     */
    public String getPokeList() {
        String poke = "";
        for(Pokemon pok : list) {
            poke += pok.getName() + " " + pok.getLevel() + "\n";
        }
        return poke;
    }
}
