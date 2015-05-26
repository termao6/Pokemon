
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

        // **************Choose Starter*****************************
        int starting = 0;
        boolean valid = false;
        while (!valid){
            System.out.println("Choose your starter Pokemon: ");
            System.out.println("1 Bulbasaur");
            System.out.println("2 Charmander");
            System.out.println("3 Squirtle");
            System.out.println("4 Pidgey");
            System.out.println("5 Pikachu");
            starting = sc.nextInt();

            if (starting == 1) {
                starter = new Bulbasaur(5);
                valid = true;
            }
            else if (starting == 2) {
                starter = new Charmander(5);
                valid = true;
            }
            else if (starting == 3) {
                starter = new Squirtle(5);
                valid = true;
            }
            else if (starting == 4) {
                starter = new Pidgey(5);
                valid = true;
            }
            else if (starting == 5) {
                starter = new Pikachu(5);
                valid = true;
            }
            else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Congratulation! Your first Pokemon is a " + starter.getName() + "!");
        player = new Trainer(starter);
        
        Pokemon current = starter; // current = player's pokemon 
                                    // that is currently in battle

        // ******************Commence battles*********************
        boolean quit = false;
        int battleCtr = 1;
        int adder = 0;
        while (!quit) {

            // Generate random opponent
            Pokemon opponent;
            double rand = Math.random()*5.5;
            int lev = (int) (Math.random()*3) - 1 + starter.getLevel() + adder;
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
            System.out.println("A wild " + opponent.getName() + " appeared!");

            // for one battle (until battleEnd)
            
            boolean continueBat = true;
            while (continueBat) {

                // Choices - what player can do
                int opt = 0;
                System.out.println("What will " + current.getName() + " do?");
                System.out.println("1 Attack");
                System.out.println("2 Switch Pokemon");
                System.out.println("3 Catch");
                System.out.println("4 Run");
                opt = sc.nextInt();
                if (opt == 4) {
                    bat.run();
                    adder-=2;
                }
                else if (opt == 3)
                    bat.catchPokemon();
                else if (opt == 2) {
                    System.out.println("Choose a Pokemon");
                    System.out.println(player.getPokeList());
                    System.out.println("To choose the first pokemon, press 1; ");
                    System.out.println("To choose the second pokemon, press 2; ");
                    System.out.println("and etc.");
                    int pok = sc.nextInt();

                    while (pok > player.getList().size() || pok < 1) {
                        System.out.println("Invalid choice. Choose again: ");
                        pok = sc.nextInt();
                    }
                    bat.switchPokemon(pok-1);
                }
                else if (opt == 1) {
                    System.out.println(current.getListOfAttacks());
                }
                else {
                    while (opt != 1 && opt != 2 && opt != 3 && opt != 4) {
                        System.out.println("Invalid choice. Choose again: ");
                        opt = sc.nextInt();
                    }
                }
                continueBat = bat.continueBattle();
            }
            adder++;
            battleCtr++;
        }

    }
}
