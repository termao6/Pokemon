
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
            System.out.print(">> ");
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

        System.out.println("Congratulations! Your first Pokemon is a " + starter.getName() + "!");
        System.out.println(starter.HPtoString());
        System.out.println();
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
            System.out.println("*********");
            System.out.println("Battle #" + battleCtr);
            System.out.println("*********");
            System.out.println();

            Battle bat = new Battle(player, starter, opponent);
            System.out.println("A wild " + opponent.getName() + " appeared!");
            System.out.println();

            // for one battle (until battleEnd)

            boolean continueBat = true;
            while (continueBat) {
                System.out.println("Your Pokemon's " + current.HPtoString());
                System.out.println("Opponent's " + opponent.HPtoString());
                
                
                // Choices - what player can do
                int opt = 0;
                System.out.println("What will " + current.getName() + " do?");
                System.out.println("1 Attack");
                System.out.println("2 Switch Pokemon");
                System.out.println("3 Catch");
                System.out.println("4 Run");
                System.out.print(">> ");
                opt = sc.nextInt();
                System.out.println();
                if (opt == 4) { // Run
                    boolean r = bat.run();
                    if (r) {
                        System.out.println("Got away safely");
                    }
                    else {
                        System.out.println("Couldn't escape!");
                    }
                    adder-=2;
                }
                else if (opt == 3) { // Catch
                    boolean c = bat.catchPokemon();
                    if (c) {
                        System.out.println("Congratulations! You have caught a " + opponent.getName() + "!");
                    }
                    else {
                        System.out.println("Catch unsuccessful! :(");
                    }
                }
                else if (opt == 2) { // Switch
                    System.out.println("Choose a Pokemon");
                    System.out.print(player.getPokeList());
                    System.out.println("To choose the first pokemon, press 1; ");
                    System.out.println("To choose the second pokemon, press 2; ");
                    System.out.println("and etc.");
                    System.out.print(">> ");
                    int pok = sc.nextInt();

                    while (pok > player.getList().size() || pok < 1) {
                        System.out.println("Invalid choice. Choose again: ");
                        pok = sc.nextInt();
                    }
                    bat.switchPokemon(pok-1);
                }
                else if (opt == 1) { // Attack
                    System.out.println("Choose an attack: ");
                    System.out.println(current.movesToString());
                    System.out.print(">> ");
                    int moveInd = sc.nextInt()-1;
                    System.out.println();
                    if (moveInd > current.getListOfAttacks().size() || moveInd < 0) {
                        while (moveInd > current.getListOfAttacks().size() || moveInd <= 0) {
                            System.out.println("Invalid choice. Choose again: ");
                            moveInd = sc.nextInt()-1;
                        }
                    }
                    Move selected = current.getListOfAttacks().get(moveInd);
                    bat.attack(current, opponent, selected);
                    System.out.println(current.getName() + " (you) used " + selected.getName());
                }
                else { // Not an option
                    while (opt != 1 && opt != 2 && opt != 3 && opt != 4) {
                        System.out.println("Invalid choice. Choose again: ");
                        opt = sc.nextInt();
                    }
                }
                continueBat = bat.continueBattle();

                // Opponent Attacks if battle continues
                if (continueBat) {
                    int oppMoveInd = (int) (Math.random()*opponent.getListOfAttacks().size());
                    bat.attack(opponent, current, opponent.getListOfAttacks().get(oppMoveInd));
                    System.out.println(opponent.getName() + " used " + opponent.getListOfAttacks().get(oppMoveInd).getName());
                    System.out.println();
                }
            }

            // Quit option
            System.out.println();
            System.out.println("QUIT? (y/n)");
            System.out.print(">> ");
            String q = sc.next().toLowerCase();
            if (q.equals("y")) {
                quit = true;
            }
            else if (q.equals("n")) {
                quit = false;
            }
            else {
                while (!q.equals("y") && !q.equals("n")) {
                    System.out.println("Invalid choice. Choose again: ");
                    q = sc.next().toLowerCase();
                }
            }
            
            
            adder++;
            battleCtr++;
        }

    }
}
