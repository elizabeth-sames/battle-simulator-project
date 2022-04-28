package Main;


import classes.Battle;
import classes.Party;
import classes.Warrior;
import classes.Wizard;


import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import java.io.FileNotFoundException;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.random.RandomGenerator;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scanner= new Scanner(System.in);


        FileWriter writer = new FileWriter("Output.txt",true);


        //get player info
        System.out.println("Welcome to the Battle!");
        writer.write("Welcome to the Battle!\n\n\n");
        System.out.println("Please enter your name: ");
        String playerName = scanner.nextLine();
        System.out.println("Welcome to the battle, " + playerName + "! Time to build your battle party." +
                "\nHow would you like to choose your battle party members?" +
                "\nEnter R to create a random party." +
                "\nEnter C to create a customized party." +
                "\nEnter U to upload a party from a CSV file."
        );

        String[] partyOptions = {"r", "c", "u"};
        String partyChoice = scanner.nextLine().toLowerCase();
        while(!Arrays.asList(partyOptions).contains(partyChoice)) {
            System.err.println("That is not a valid option.");
            System.out.println(
                    "Enter R to create a random party." +
                    "\nEnter C to create a customized party." +
                    "\nEnter U to upload a party from a CSV file."
            );
            partyChoice = scanner.nextLine().toLowerCase();
        }

        //create the player's party using their method of choice
        Party playersParty = new Party();
        switch(partyChoice) {
            case "r":
                playersParty.makeRandomParty();
                break;
            case "c":
                playersParty.makeCustomParty(scanner);
                break;
            case "u":
                playersParty.makeCsvParty1();
                break;
        }
        //scanner.close();
        System.out.println("Your party is ready for battle!");
        //create opponent team
        Party opponentsParty = new Party();
        opponentsParty.makeRandomParty();

        //start battle
        Battle battle = new Battle(playersParty, opponentsParty);

        while (playersParty.getSize() > 0 && opponentsParty.getSize() > 0) {
            //player chooses fighter
            System.out.println("Choose your fighter:");
            writer.write("Your battle party had those members:  \n");
            for (int i=0; i<playersParty.getSize(); i++) {
                System.out.println("Enter " + (i+1) + " for " + playersParty.getMembers().get(i).toString());
                writer.write( playersParty.getMembers().get(i).toString() +"\n");
            }

            int indexPlayer = scanner.nextInt() - 1;
            while (indexPlayer > playersParty.getSize()-1) {
                System.out.println("Please enter a number between 1 and " + playersParty.getSize());
                indexPlayer = scanner.nextInt() - 1;
            }
            System.out.println("You have chosen: " + playersParty.getMembers().get(indexPlayer).toString());
            writer.write("You have chosen: " + playersParty.getMembers().get(indexPlayer).toString() +"\n");
            //choose opponent's fighter
            int indexOpponent = (int) Math.floor(Math.random() * opponentsParty.getSize());
            System.out.println("Your opponent has chosen: "
                    + opponentsParty.getMembers().get(indexOpponent).toString());
            writer.write("Your opponent has chosen: "
                    + opponentsParty.getMembers().get(indexOpponent).toString() +"\n");
            writer.write("===========================================================================\n");
            //fight
            battle.twoPlayersFight(indexPlayer, indexOpponent);
            System.out.println("Graveyard: " + battle.getGraveyardList().toString());
            writer.write("Graveyard: " + battle.getGraveyardList().toString() +"\n");

        }
        //add winner statement here
        if (opponentsParty.getSize() == 0 ){
            System.out.println("__  ______  __  __   _       ______  _   __   __\n" +
                    "\\ \\/ / __ \\/ / / /  | |     / / __ \\/ | / /  / /\n" +
                    " \\  / / / / / / /   | | /| / / / / /  |/ /  / / \n" +
                    " / / /_/ / /_/ /    | |/ |/ / /_/ / /|  /  /_/  \n" +
                    "/_/\\____/\\____/     |__/|__/\\____/_/ |_/  (_)   \n" +
                    "                                              ");
        }else{
            System.out.println("__  ______  __  __   __    ____  ___________\n" +
                    "\\ \\/ / __ \\/ / / /  / /   / __ \\/ ___/_  __/\n" +
                    " \\  / / / / / / /  / /   / / / /\\__ \\ / /   \n" +
                    " / / /_/ / /_/ /  / /___/ /_/ /___/ // /    \n" +
                    "/_/\\____/\\____/  /_____/\\____//____//_/     \n" +
                    "                                      ");
        }

        writer.close();
        scanner.close();


    }

}

