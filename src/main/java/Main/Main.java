package Main;

import classes.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scanner= new Scanner(System.in);
        FileWriter writer = new FileWriter("battle-log.txt",true);

        String welcomeMessage = " _      _____  / /________  ____ ___  ___      / /_____      / /_/ /_  ___      \n" +
                "| | /| / / _ \\/ / ___/ __ \\/ __ `__ \\/ _ \\    / __/ __ \\    / __/ __ \\/ _ \\     \n" +
                "| |/ |/ /  __/ / /__/ /_/ / / / / / /  __/   / /_/ /_/ /   / /_/ / / /  __/     \n" +
                "|__/|__/\\___/_/\\___/\\____/_/ /_/ /_/\\___/    \\__/\\____/    \\__/_/ /_/\\___/      \n" +
                "        ________  ____  _   __     ____  ___  ______________    ______          \n" +
                "       /  _/ __ \\/ __ \\/ | / /    / __ )/   |/_  __/_  __/ /   / ____/          \n" +
                "       / // /_/ / / / /  |/ /    / __  / /| | / /   / / / /   / __/             \n" +
                "     _/ // _, _/ /_/ / /|  /    / /_/ / ___ |/ /   / / / /___/ /___             \n" +
                "    /___/_/ |_|\\____/_/ |_/    /_____/_/  |_/_/   /_/ /_____/_____/             ";
        System.out.println(welcomeMessage+ "\n\n");

        writer.write(welcomeMessage+ "\n\n");
        writer.write("    ------------------------\n\n");

        System.out.println("How would you like to choose your battle party?" +
                "\nEnter R to create a random party." +
                "\nEnter C to create a customized party." +
                "\nEnter U to upload a party from a CSV file." +
                "\nOr Enter X for express battle."
        );
        String[] partyOptions = {"r", "c", "u", "x"};
        String partyChoice = scanner.nextLine().toLowerCase();
        while(!Arrays.asList(partyOptions).contains(partyChoice)) {
            System.err.println("That is not a valid option.");
            System.out.println(
                    "Enter R to create a random party." +
                    "\nEnter C to create a customized party." +
                    "\nEnter U to upload a party from a CSV file." +
                            "\nEnter X for express battle."
            );
            partyChoice = scanner.nextLine().toLowerCase();
        }
        Party playersParty = new Party();
        Party opponentsParty = new Party();
        opponentsParty.makeRandomParty();
        Battle battle = new Battle(playersParty, opponentsParty);
        battle.setOpponentsParty(opponentsParty);

        switch(partyChoice) {
            case "r":
                playersParty.makeRandomParty();
                System.out.println("Your party is ready for battle!\n");
                battle.setPlayersParty(playersParty);
                battle.fullBattle(scanner, writer);
                break;
            case "c":
                playersParty.makeCustomParty(scanner);
                System.out.println("Your party is ready for battle!\n");
                battle.setPlayersParty(playersParty);
                battle.fullBattle(scanner, writer);
                break;
            case "u":
                File file = new File("import-parties.csv");
                playersParty.makeCsvParty(file);
                System.out.println(playersParty.getMembers().toString());
                battle.setPlayersParty(playersParty);
                System.out.println("Your party is ready for battle!\n");
                battle.fullBattle(scanner, writer);
                break;
            case "x":
                writer.write("Express Battle\n\n");
                playersParty.makeRandomParty();
                battle.setPlayersParty(playersParty);
                battle.fullBattleRandom(scanner, writer);
                break;
        }

        writer.close();
        scanner.close();
    }

}