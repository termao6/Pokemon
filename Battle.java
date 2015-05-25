
/**
 * Write a description of class Battle here.
 * allows Pokemon to battle and interact with each other
 * @author (your name) Teresa Mao, Amber Hu
 * @version (a version number or a date) 5/20/15
 */
public class Battle
{
    Trainer t;
    Pokemon opponent;
    Pokemon current;
    boolean battleEnd = false;
    boolean win = false;
    
    public Battle(Trainer t2, Pokemon cur, Pokemon opp)
    {
        t = t2;
        current = cur;
        opponent = opp;
    }

    public void attack(Pokemon attacker, Pokemon attacked, Move move)
    {
        int baseDamage = move.getBaseAttack();
        double attDef = (double) attacker.getBaseAttack()/attacked.getBaseDefense();
        int effect = move.levelOfEffectiveness(attacked);
        int damageDone = (int) (baseDamage * attDef* (attacker.getLevel()/25.));
        if (effect == 1) {
            damageDone = (int) (damageDone * (2/3.));
        }
        if (effect == 3) {
            damageDone = (int) (damageDone * (4/3.));
        }
        attacked.setHPBattle(attacked.getHPBattle()-damageDone);
        
        if (attacked.getHPBattle() <= 0){
            attacked.setHPBattle(0);
            if (attacked == opponent)
                win = true;
            battleEnd = true;
        }
    }
    
    public void catchPokemon() 
    {
        int catchRate = opponent.getHPFull()/opponent.getHPBattle();
        if (catchRate * Math.random() > 1){
            t.caughtPokemon(opponent);
            battleEnd = true;
        }
    }
    
    public void switchPokemon(int ind)
    {
        current = t.getList().get(ind);
    }
    
    public void setOpponent(Pokemon p){
        opponent = p;
    }
    
    public Pokemon getCurrent() {
        return current;
    }
    
    public Pokemon getOpponent() {
        return opponent;
    }
}
