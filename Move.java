
/**
 * Write a description of class Move here.
 * 
 * @author (your name) Teresa Mao, Amber Hu
 * @version (a version number or a date) 5/18/2015
 */
public class Move
{
    // instance variables - replace the example below with your own
    private String name;
    private String type;
    private int baseAttack;
    
    /**
     * Constructor for objects of class Move
     */
    public Move(String n, String t, int ba) 
    {
        name = n;
        type = t;
        baseAttack = ba;
    }
    
    public String getName() {
        return name;
    }
    
    public String getType() {
        return type;
    }
    
    public int getBaseAttack() {
        return baseAttack;
    }
}
