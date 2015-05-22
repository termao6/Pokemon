
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
    private String type; //normal, water, fire, electric, grass
    private int baseAttack;
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
    public int levelOfEffectiveness(Pokemon p) { // 1 = not effective, 2 = medium, 3 = very effective
        String type2 = p.getType();
        if (type.equals(type2)) {
            return 2;
        }
        else if (type.equals("Normal") || type2.equals("Normal")) {
            return 2;
        }
        else if (type.equals("Water") && type2.equals("Fire")) {
            return 3;
        }
        else if (type.equals("Electric") && type2.equals("Water")) {
            return 3;
        }
        else if (type.equals("Fire") && type2.equals("Grass")) {
            return 3;
        }
        else if (type.equals("Grass") && type2.equals("Water")) {
            return 3;
        }
        else {
            return 1;
        }
    }
}
