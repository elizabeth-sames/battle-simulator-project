package Main;

import classes.Battle;
import classes.Party;
import classes.Warrior;
import classes.Wizard;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.random.RandomGenerator;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner= new Scanner(System.in);

        //get player info
        System.out.println("Welcome to the Battle! \n");
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

        System.out.println("Your party is ready for battle!");

        //create opponent team
        Party opponentsParty = new Party();
        opponentsParty.makeRandomParty();

        //start battle
        Battle battle = new Battle(playersParty, opponentsParty);
        while (playersParty.getSize() > 0 && opponentsParty.getSize() > 0) {
            //player chooses fighter
            System.out.println("Choose your fighter:");
            for (int i=0; i<playersParty.getSize(); i++) {
                System.out.println("Enter " + (i+1) + " for " + playersParty.getMembers().get(i).toString());
            }

            int indexPlayer = scanner.nextInt() - 1;
            while (indexPlayer > playersParty.getSize()-1) {
                System.out.println("Please enter a number between 1 and " + playersParty.getSize());
                indexPlayer = scanner.nextInt() - 1;
            }
            System.out.println("You have chosen: " + playersParty.getMembers().get(indexPlayer).toString());
            //choose opponent's fighter
            int indexOpponent = (int) Math.floor(Math.random() * opponentsParty.getSize());
            System.out.println("Your opponent has chosen: "
                    + opponentsParty.getMembers().get(indexOpponent).toString() + "\n");
            //fight
            battle.twoPlayersFight(indexPlayer, indexOpponent);


        }
        //add winner statement here


        scanner.close();

    }

}
