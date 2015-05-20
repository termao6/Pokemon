
/**
 * Write a description of abstract class Pokemon here.
 * contains parent method and constructor for the individual Pokemon (child classes)
 * @author (your name) Teresa Mao, Amber Hu
 * @version (a version number or a date) 5/18/2015
 */
import java.util.*;
public abstract class Pokemon
{
    int level;
    public Pokemon (int lev) {
        level = lev;
    }
    public abstract void gainEXP(int points);
    public abstract int getHPBattle();
    public abstract int getHPFull();
    public int getLevel() {
        return level;
    }
    public abstract List<Move> getListOfAttacks();
}
