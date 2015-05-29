
/**
 * Write a description of class Trainer here.
 * trainer in battle that contains a list of pokemon
 * @author (your name) Teresa Mao, Amber Hu
 * @version (a version number or a date) 5/18/2015
 */
import java.util.*;
public class Trainer
{
    private List<Pokemon> list = new ArrayList<Pokemon>();
    public Trainer(Pokemon starter) //constructor for Trainer class
    {
        list.add(starter);
    }
    
    public void caughtPokemon(Pokemon poke) { //adds caught pokemon to Trainer's list
        list.add(poke);
    }
    
    public void healAll() {
        for (Pokemon pok : list) {
            pok.heal();
        }
    }
    
    public boolean allFaint() {
        for (Pokemon pok : list) {
            if (!pok.getFaintStatus())
                return false;
        }
        return true;
    }
    
    public List<Pokemon> getList() //returns list of pokemon that Trainer has
    {
        return list;
    }
    
    /**
     * returns name and level of all of Trainer's pokemon
     */
    public String getPokeList() { 
        int ind = 1;
        String poke = "";
        for(Pokemon pok : list) {
            poke += ind + " " + pok.getName();
            if (pok.getFaintStatus())
                poke += "/t - fainted";
            poke += "\n";
            ind++;
        }
        return poke;
    }
}
