package Main;

import classes.Battle;
import classes.Party;
import classes.Warrior;
import classes.Wizard;

import java.util.Arrays;
import java.util.Scanner;
import java.util.random.RandomGenerator;

public class Main {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);

        //get player info
        System.out.println("Welcome to the Battle!");
        System.out.println("Please enter your name: ");
        String playerName = scanner.nextLine();
        System.out.println("Welcome to the battle, " + playerName + "! Time to build your battle party." +
                "\nHow would you like to choose your battle party members?" +
                "\nEnter R to create a random party." +
                "\nEnter C to create a customized party." +
                "\nEnter U to upload a party from a CSV file."
        );
        String[] partyOptions = {"r", "c", "u"};
        String partyChoice = scanner.nextLine();
        while(!Arrays.asList().contains(partyChoice)) {
            System.err.println("That is not a valid option.");
            System.out.println(
                    "Enter R to create a random party." +
                    "\nEnter C to create a customized party." +
                    "\nEnter U to upload a party from a CSV file."
            );
            partyChoice = scanner.nextLine().toLowerCase();
        }

        //create the player's party using their method of choice
        Party playerParty = new Party();
        switch(partyChoice) {
            case "r":
                playerParty.makeRandomParty();
                break;
            case "c":
                //method to make a customized party;
                break;
            case "u":
                //method to upload a party from CSV
                break;
        }
        System.out.println("Your party is ready for battle!");

        //create opponent team
        Party opponentParty = new Party();
        opponentParty.makeRandomParty();

        //battle code here
        Battle battle = new Battle(playerParty, opponentParty);
        battle.fight();

        scanner.close();

    }

}

//    public static void partyCustomized(){
//        int stamina;
//        int strength;
//        int mana;
//        int intelligence;
//        int hp;
//        String name;
//        int id=0;
//        String newCharacter = "yes";
//
//        List<Object> team = new ArrayList<>();
//
//        Scanner scanner = new Scanner(System.in);
//        while(newCharacter.equals("yes")) {
//            System.out.println("Please, choose a new member for your party");
//            System.out.println("Warrior/Wizard");
//
//            String character = scanner.next().toLowerCase();
//            while (!character.equals("wizard") && !character.equals("warrior")) {
//                System.err.println("This character does not exist.");
//                System.err.println("Please, choose between warrior and wizard");
//                character = scanner.next();
//            }
//
//            System.out.println("You have chosen " + character);
//            System.out.println("Please, choose a name for your " + character);
//            name = scanner.next();
//
//            System.out.println(name + " is a new " + character + " of your party");
//
//
//            if (character.equals("warrior")) {
//
//                System.out.println("Now choose a number between 100-200 representing the health points");
//                hp = scanner.nextInt();
//
//
//                while (hp < 100 || hp > 200) {
//                    System.err.println("Choose 100-200");
//                    hp = scanner.nextInt();
//                }
//                System.out.println(name + " has " + hp + " of health points");
//
//
//                System.out.println(("Choose stamina between 10 and 50"));
//                stamina = scanner.nextInt();
//
//                while (stamina < 10 || stamina > 50) {
//                    System.err.println("Choose 10-50");
//                    stamina = scanner.nextInt();
//                }
//                System.out.println(name + " has " + stamina + " of stamina");
//
//                System.out.println((name + " needs an strength between 1 and 10"));
//                strength = scanner.nextInt();
//
//                while (strength < 1 || strength > 10) {
//                    System.err.println("Choose 1-10");
//                    strength = scanner.nextInt();
//                }
//
//
//                Warrior warrior = new Warrior(name, hp, stamina, strength);
//
//                System.out.println(warrior);
//
//                team.add(warrior);
//
//            } else {
//
//                System.out.println("Now choose a number between 50-100 representing the health points");
//                hp = scanner.nextInt();
//
//                while (hp < 50 || hp > 100) {
//                    System.err.println("Choose 50-100");
//                    hp = scanner.nextInt();
//                }
//                System.out.println(name + " has " + hp + "of health points");
//
//                System.out.println((name + " needs mana between 10 and 50"));
//                mana = scanner.nextInt();
//                while (mana < 10 || mana > 50) {
//                    System.err.println("Choose a number between 10 and 50");
//                    mana = scanner.nextInt();
//                }
//                System.out.println(name + " has an health point of " + mana);
//
//                System.out.println("Please, choose intelligence for " + name + " a number between 1 and 50");
//                intelligence = scanner.nextInt();
//                while (intelligence < 1 || intelligence > 50) {
//                    System.err.println("Choose a number between 1 and 50");
//                    intelligence = scanner.nextInt();
//                }
//                System.out.println(name + " has an health point of " + intelligence);
//
//                Wizard wizard = new Wizard(name, hp, mana, intelligence);
//
//                System.out.println(wizard);
//
//                team.add(wizard);
//
//
//            }
//            id++;
//
//
//
//            System.out.println("Do you want to create a new character in your team?  (yes/no)");
//
//            newCharacter = scanner.next().toLowerCase();
//
//            while(!newCharacter.equals("yes") && !newCharacter.equals("no")){
//                System.err.println("Please, answer yes or no");
//                newCharacter = scanner.next().toLowerCase();
//            }
//
//        }
//
//        scanner.close();
//
//        for(int i = 0; i<team.size(); i++){
//            System.out.println(team.get(i));
//        }
//
//
//
//    }
