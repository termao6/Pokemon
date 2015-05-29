
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
    
    // ******************** Set up/calculate stats/HP/Level/type *************************
    public Pokemon (int lev) {
        level = lev;
    }
    
    /***
     * set HPFull and HPBattle
     */
    public void setHP(int HPBase){
        HPFull = (int) (((Math.random()*31+(2*HPBase)+100)*level)/100 + 10);
        HPBattle = HPFull;
    }
    
    /***
     * set attack stat
     */
    public void setAttack(int base){
        attack = (int) (((Math.random()*31+(2*base))*level)/100 + 5);
    }
    
    /***
     * set defense stat
     */
    public void setDefense(int base){
        defense = (int) (((Math.random()*31+(2*base))*level)/100 + 5);
    }
    
    /***
     * set speed stat
     */
    public void setSpeed(int base){
        speed = (int) (((Math.random()*31+(2*base))*level)/100 + 5);;
    }
    
    public void setType(String ty){
        type = ty;
    }
    // ************************************* End of Set up ***********************************
    
    
    // ********************************* Return various stats & HP & level & type ******************
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
     * returns speed to determine who flee factor
     */
    public int getSpeed(){
        return speed;
    }
    
    public String getType(){
        return type;
    }
    // ******************************** End of return section *******************************
    
    /**
     * To calculate damage
     */
    public void setHPBattle(int HPB){
        if (HPB < 0)
            HPBattle = 0;
        else
            HPBattle = HPB;
        }
    
    /**
     * resets HPBattle to Full
     */
    public void heal() {
        HPBattle = HPFull;
    }
    
    /**
     * statement of Pokemon's HP
     */
    public String HPtoString() {
        return "HP: " + HPBattle + "/" + HPFull;
    }
    
    /**
     * when opponent loses, it doles out EXP to the winner to gain levels
     */
    public int giveEXP() {
        return (int) (Math.pow(level, 1.7)*7);
    }
    
    
    // ***************************** control fainted status *******************************
    public void faint() {
        fainted = true;
    }
    
    public void revive(){
        fainted = false;
    }
    
    public boolean getFaintStatus() {
        return fainted;
    }
    
    // ************************** to be finished in child classes *********************
    public abstract void gainEXP(int points);                       // gain EXP and gain level if enough EXP
    public abstract List<Move> getListOfAttacks();                  
    public abstract String movesToString();                         // returns menu of move choices
    public abstract String getName();                               // returns name & level of pokemon
}
