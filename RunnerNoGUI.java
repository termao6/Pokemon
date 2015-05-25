
/**
 * Write a description of class RunnerNoGUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
public class RunnerNoGUI
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Trainer player;  // person playing
        Pokemon starter = new Pidgey(1); // trainer's first pokemon (to be overridden)
        
        String st = "";
        boolean valid = false;
        while (!valid){
            System.out.println("Choose your starter Pokemon: ");
            System.out.print("Bulbasaur, Charmander, Squirtle, Pidgey, or Pikachu");
            st = sc.next();

            if (st.toLowerCase().equals("bulbasaur")) {
                starter = new Bulbasaur(5);
                valid = true;
            }
            else if (st.toLowerCase().equals("charmander")) {
                starter = new Charmander(5);
                valid = true;
            }
            else if (st.toLowerCase().equals("squirtle")) {
                starter = new Squirtle(5);
                valid = true;
            }
            else if (st.toLowerCase().equals("pidgey")) {
                starter = new Pidgey(5);
                valid = true;
            }
            else if (st.toLowerCase().equals("pikachu")) {
                starter = new Pikachu(5);
                valid = true;
            }
            else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        
        System.out.println("Congratulation! Your first Pokemon is a " + st + "!");
        player = new Trainer(starter);
        
        
        // Commence battles
        boolean quit = false;
        int battleCtr = 1;
        while (!quit) {
            
            // Generate random opponent
            Pokemon opponent;
            double rand = Math.random()*5.5;
            int lev = (int) (Math.random()*3) - 1 + starter.getLevel();
            if (rand<1) {
                opponent = new Bulbasaur(lev);
            }
            else if (rand<2) {
                opponent = new Charmander(lev);
            }
            else if (rand<3) {
                opponent = new Squirtle(lev);
            }
            else if (rand<3.5) {
                opponent = new Pikachu(lev);
            }
            else {
                opponent = new Pidgey(lev);
            }
            
            // Start Battle
            System.out.println("********");
            System.out.println("Battle #" + battleCtr);
            System.out.println("********");
            System.out.println();
            
            Battle bat = new Battle(player, starter, opponent);
            
            // Choices - what player can do
            String opt = "";
            System.out.print("Attack, Switch (Pokemon), Catch, or Run: ");
            if (opt.toLowerCase().equals("run"))
                bat.run();
            else if (opt.toLowerCase().equals("catch"))
                bat.catchPokemon();
            else if (opt.toLowerCase().equals("switch")) {
                System.out.println(player.getList());
                System.out.println("To choose the first pokemon, press 1; ");
                System.out.println("To choose the second pokemon, press 2; ");
                System.out.println("and etc.");
            }
            
            battleCtr++;
        }
        
    }
}
