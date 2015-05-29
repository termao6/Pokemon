
/**
 * Write a description of abstract class Pokemon here.
 * contains parent method and constructor for the individual Pokemon (child classes)
 * @author (your name) Teresa Mao, Amber Hu
 * @version (a version number or a date) 5/18/2015
 */
import java.util.*;
public abstract class Pokemon
{
    private int level, EXP;
    private int HPFull, HPBattle; //HPFull = total HP, HPBattle = HP remaining in battle
    private int attack, defense, speed; //Pokemon stats
    private int AIV = (int)Math.random()*31, DIV = (int)Math.random()*31, SIV = (int)Math.random()*31, HPIV = (int)Math.random()*31; // Pokemon IVS (for game mechanics)
    private int attB, defB, spdB, HPB;
    private String type; // Type of the Pokemon
    private boolean fainted = false; // can the Pokemon still be in play? (false = yes)
    
    // ******************** Set up/calculate stats/HP/Level/type *************************
    public Pokemon (int lev, int aB, int dB, int sB, int hpB) {
        level = lev;
        EXP = 0;
        
        // Set up stats
        attB=aB;
        defB=dB;
        spdB=sB;
        HPB=hpB;
        attack = (int) (((AIV*31+(2*attB))*level)/100 + 5);
        defense = (int) (((DIV+(2*defB))*level)/100 + 5);
        speed = (int) (((SIV+(2*spdB))*level)/100 + 5);
        HPFull = (int) (((HPIV+(2*HPB)+100)*level)/100 + 10);
        HPBattle = HPFull;
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
        revive();
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
        return (int) (Math.pow(level, .9)*5);
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
    public void gainEXP(int points) {                       // gain EXP and gain level if enough EXP
        EXP += points;
        if ((EXP-level)/3 > level)
            gainLevel();
    }
    
    public void gainLevel() {                               // update stats when level up
        level++;
        attack = (int) (((AIV*31+(2*attB))*level)/100 + 5);
        defense = (int) (((DIV+(2*defB))*level)/100 + 5);
        speed = (int) (((SIV+(2*spdB))*level)/100 + 5);
        HPFull = (int) (((HPIV+(2*HPB)+100)*level)/100 + 10);
        System.out.println(getName() + " grew to lv " + level);
    }
    
    public abstract List<Move> getListOfAttacks();                  
    public abstract String movesToString();                         // returns menu of move choices
    public abstract String getName();                               // returns name & level of pokemon
}
