package Main;

import classes.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scanner= new Scanner(System.in);
        FileWriter writer = new FileWriter("battle-log.txt",true);

        System.out.println("Welcome to the Battle!\n");
        writer.write("     Welcome to the Battle!\n");
        writer.write("    ------------------------\n\n\n");

        System.out.println("How would you like to choose your battle party?" +
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
                playersParty.makeCsvParty();
                break;
        }
        System.out.println("Your party is ready for battle!\n");
        //create opponent team
        Party opponentsParty = new Party();
        opponentsParty.makeRandomParty();

        //battle
        Battle battle = new Battle(playersParty, opponentsParty);
        battle.fullBattle(scanner, writer);

        writer.close();
        scanner.close();
    }

}