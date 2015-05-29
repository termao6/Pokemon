
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
        boolean won = true;
        int battleCtr = 1;
        int adder = 0;
        while (!quit) {    // until player quits                  
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

            // for one opponent (until battleEnd)
            int runAttempts = 0;
            boolean continueBat = true;
            while (continueBat) {
                System.out.println("Your Pokemon's " + current.HPtoString());
                System.out.println("Opponent's " + opponent.HPtoString());
                System.out.println();

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
                if (opt == 4) {                                              // Run
                    boolean r = bat.run(runAttempts);
                    if (r) {
                        System.out.println("Got away safely");
                        adder-=2;
                        continueBat = false;
                    }
                    else {
                        System.out.println("Couldn't escape!");
                        continueBat = true;
                    }
                    runAttempts++;
                }

                else if (opt == 3) {                                         // Catch
                    boolean c = bat.catchPokemon();
                    if (c) {
                        System.out.println("Congratulations! You have caught a " + opponent.getName() + "!");
                        continueBat = false;
                    }
                    else {
                        System.out.println("Catch unsuccessful! :(");
                        continueBat = true;
                    }
                }

                else if (opt == 2) {                                        // Switch
                    System.out.println("Choose a Pokemon");
                    System.out.print(player.getPokeList());
                    System.out.print(">> ");
                    int pok = sc.nextInt();

                    while (pok > player.getList().size() || pok < 1 || player.getList().get(pok-1).getFaintStatus()) {
                        System.out.println("Invalid choice. Choose again: ");
                        pok = sc.nextInt();
                    }
                    bat.switchPokemon(pok-1);
                    current = player.getList().get(pok-1);
                    continueBat = true;
                }

                else if (opt == 1) {                                         // Attack
                    System.out.println("Choose an attack: ");
                    System.out.print(current.movesToString());
                    System.out.print(">> ");
                    int moveInd = sc.nextInt()-1;
                    System.out.println();
                    if (moveInd >= current.getListOfAttacks().size() || moveInd < 0) {
                        while (moveInd >= current.getListOfAttacks().size() || moveInd <= 0) {
                            System.out.println("Invalid choice. Choose again: ");
                            moveInd = sc.nextInt()-1;
                        }
                    }
                    Move selected = current.getListOfAttacks().get(moveInd);
                    System.out.println(current.getName() + " (you) used " + selected.getName());
                    bat.attack(current, opponent, selected);
                    continueBat = true;
                }

                else {                                                    // Not an option
                    while (opt != 1 && opt != 2 && opt != 3 && opt != 4) {
                        System.out.println("Invalid choice. Choose again: ");
                        opt = sc.nextInt();
                    }
                }

                // check status of battle

                if (continueBat && !current.getFaintStatus() && !opponent.getFaintStatus()) {
                    int oppMoveInd = (int) (Math.random()*opponent.getListOfAttacks().size());
                    System.out.println(opponent.getName() + " used " + opponent.getListOfAttacks().get(oppMoveInd).getName());
                    bat.attack(opponent, current, opponent.getListOfAttacks().get(oppMoveInd));
                    System.out.println();
                }
                
                if (opponent.getFaintStatus()) {
                    continueBat = false;
                }
                
                //check if current pokemon has fainted
                if (current.getFaintStatus()) {
                    if (player.allFaint()) { // no more usable pokemon
                        System.out.println("Your " + current.getName() + " fainted.");
                        System.out.println("Player is out of usable Pokemon.");
                        System.out.println("Sorry, you must start over your Pokemon journey.");
                        System.out.println("Don't worry, though: In this world, you are always 10, so you can play forever.");
                        continueBat = false;
                        quit = true;
                    }
                    else {       // current pokemon fainted, but players still has more pokemon
                        System.out.println("Your " + current.getName() + " fainted.");
                        System.out.println("Use next Pokemon? (y/n)");
                        System.out.print(">> ");
                        String cont = sc.next().toLowerCase();
                        System.out.println();
                        if (cont.equals("y")) {                                          // Allows player to switch pokemon
                            System.out.print(player.getPokeList());
                            System.out.print(">> ");
                            int pok = sc.nextInt();

                            while (pok > player.getList().size() || pok < 1 || player.getList().get(pok-1).getFaintStatus()) {
                                System.out.println("Invalid choice. Choose again: ");
                                pok = sc.nextInt();
                            }
                            bat.switchPokemon(pok-1);
                            current = player.getList().get(pok-1);
                            continueBat = true;
                            
                        }
                        else if (cont.equals("n")) {                               // attempts to run
                            boolean r = bat.run(runAttempts);
                            if (r) {
                                System.out.println("Got away safely");
                                adder-=2;
                                continueBat = false;

                                // Quit option
                                System.out.println();
                                System.out.println("QUIT? (y/n)");
                                System.out.print(">> ");
                                String q = sc.next().toLowerCase();
                                System.out.println();
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
                            else {
                                System.out.println("Couldn't escape!");

                                // Player has to use next pokemon

                                System.out.print(player.getPokeList());
                                System.out.print(">> ");
                                int pok = sc.nextInt();

                                while (pok > player.getList().size() || pok < 1 || player.getList().get(pok-1).getFaintStatus()) {
                                    System.out.println("Invalid choice. Choose again: ");
                                    pok = sc.nextInt();
                                }
                                bat.switchPokemon(pok-1);
                                current = player.getList().get(pok-1);

                                continueBat = true;
                                
                            }
                            runAttempts++;
                        }
                        else {                                              // invalid choice
                            while (!cont.equals("y") && !cont.equals("n")) {
                                System.out.println("Invalid choice. Choose again: ");
                                cont = sc.next().toLowerCase();
                            }
                        }
                    }
                }

                // **********Opponent Attacks if battle continues**********
                

                won = bat.win();
            }
            // *************battle ended***************

            if (won) {                                         // if win, give EXP to winner
                System.out.println("The wild " + opponent.getName() + " fainted.");
                System.out.println(current.getName() + " gained " + opponent.giveEXP() + " EXP Points!");
                current.gainEXP(opponent.giveEXP());
            }

            // Quit option
            System.out.println();
            System.out.println("QUIT? (y/n)");
            System.out.print(">> ");
            String q = sc.next().toLowerCase();
            System.out.println();
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

            player.healAll();
        }

    }
}
