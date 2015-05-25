
/**
 * Write a description of abstract class Pokemon here.
 * contains parent method and constructor for the individual Pokemon (child classes)
 * @author (your name) Teresa Mao, Amber Hu
 * @version (a version number or a date) 5/18/2015
 */
import java.util.*;
public abstract class Pokemon
{
    private int level;
    private int HPFull, HPBattle; //HPFull = total HP, HPBattle = HP remaining in battle
    private int attack, defense, speed; //Pokemon stats
    private String type; // Type of the Pokemon
    private boolean fainted = false; // can the Pokemon still be in play? (false = yes)
    public Pokemon (int lev) {
        level = lev;
    }
    
    
    /***
     * set HPFull and HPBattle
     */
    public void setHP(int HPF){
        HPFull = HPF;
        HPBattle = HPFull;
    }
    
    /***
     * set attack stat
     */
    public void setAttack(int att){
        attack = att;
    }
    
    /***
     * set defense stat
     */
    public void setDefense(int def){
        defense = def;
    }
    
    /***
     * set speed stat
     */
    public void setSpeed(int spd){
        speed = spd;
    }
    
    public void setType(String ty){
        type = ty;
    }
    
    
    /***
     * returns level
     */
    public int getLevel(){
        return level;
    }
    
    /***
     * returns total HP
     */
    public int getHPFull(){
        return HPFull;
    }
    
    /***
     * returns how much HP is left for that Pokemon
     */
    public int getHPBattle(){
        return HPBattle;
    }
    
    /***
     * returns attack stat to calculate damage
     */
    public int getBaseAttack(){
        return attack;
    }
    
    /***
     * returns defense stat to calculate damage
     */
    public int getBaseDefense(){
        return defense;
    }
    
    /***
     * returns speed to determine who goes first
     */
    public int getspeed(){
        return speed;
    }
    
    public String getType(){
        return type;
    }
    
    
    public void setHPBattle(int HPB){
        if (HPB < 0)
            HPBattle = 0;
        else
            HPBattle = HPB;
    }
    
    // control fainted status
    public void faint() {
        fainted = true;
    }
    
    public void reviv(){
        fainted = false;
    }
    
    
    public abstract void gainEXP(int points);
    public abstract List<Move> getListOfAttacks();
}
