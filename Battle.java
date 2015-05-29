
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
        double levDam = (2*attacker.getLevel()/5+2);
        int effect = move.levelOfEffectiveness(attacked);
        int damageDone = (int) ((baseDamage * attDef* (levDam))/50)+2;
        if (effect == 1) {
            damageDone = (int) (damageDone * (1/2.));
            System.out.println("It wasn't very effective...");
        }
        if (effect == 3) {
            damageDone = (int) (damageDone * (2.));
            System.out.println("Super effective!");
        }
        if (move.getType().equals(attacker.getType()))
            damageDone = (int) (damageDone*1.5);
        damageDone = (int) (damageDone * (Math.random()/2+.5));
        if (baseDamage==0)
            damageDone=0;
        attacked.setHPBattle(attacked.getHPBattle()-damageDone);

        if (attacked.getHPBattle() <= 0){
            attacked.faint();
            if (attacked == opponent)
                win = true;
            battleEnd = true;
        }
    }

    public boolean catchPokemon() 
    {
        int catchRate = opponent.getHPFull()/opponent.getHPBattle();
        if (catchRate * Math.random() > 1){
            t.caughtPokemon(opponent);
            battleEnd = true;
            return true;
        }
        return false;
    }

    public void switchPokemon(int ind)
    {
        current = t.getList().get(ind);
    }

    public boolean run(int attemptNum) {
        double prob = (((current.getSpeed()*32)/(opponent.getSpeed()/4))+30*attemptNum)/156;
        battleEnd = Math.random() < prob;
        return battleEnd;
    }

    /**
     * true = battle continuing
     * false = battle is finished; time to start a new battle
     */
    public boolean continueBattle() {
        return !battleEnd;
    }

    public boolean win() {
        return win;
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
