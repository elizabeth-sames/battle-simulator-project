package classes;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Battle {
    private Party playersParty;
    private Party opponentsParty;
    private List<Object> graveyardList = new ArrayList<>();

    public Battle(Party playersParty, Party opponentsParty) {
        this.playersParty = playersParty;
        this.opponentsParty = opponentsParty;
    }

    public Party getPlayersParty() {
        return playersParty;
    }

    public Party getOpponentsParty() {
        return opponentsParty;
    }

    public void setPlayersParty(Party playersParty) {
        this.playersParty = playersParty;
    }

    public void setOpponentsParty(Party opponentsParty) {
        this.opponentsParty = opponentsParty;
    }


    public void twoPlayersFight(int indexPlayer, int indexOpponent, Writer writer) throws IOException {
        Character players = (Character) playersParty.getMembers().get(indexPlayer);
        Character opponents = (Character) opponentsParty.getMembers().get(indexOpponent);

        int round = 1;
        while (players.isAlive() && opponents.isAlive()) {
            int damageCausedByPlayer = players.attack();
            int damageCausedByOpponent = opponents.attack();

            players.applyDamageFromAttack(players.getHp() - damageCausedByOpponent);
            opponents.applyDamageFromAttack(opponents.getHp() - damageCausedByPlayer);
            System.out.println("Round " + round + ":   " +
                     players.attackMessage().concat(".   ") +
                            opponents.attackMessage().concat("."));
            writer.write("Round " + round + ":   " +
                    players.attackMessage().concat(".   ") +
                    opponents.attackMessage().concat(".\n"));

            if (!players.isAlive() && !opponents.isAlive()) {
                graveyardList.add(((Character) playersParty.getMembers().get(indexPlayer)).getName());
                playersParty.getMembers().remove(indexPlayer);
                graveyardList.add(((Character) opponentsParty.getMembers().get(indexOpponent)).getName());
                opponentsParty.getMembers().remove(indexOpponent);
                System.out.println("\n\nIt's a tie, both fighters died in this battle.");
                writer.write("\n\nIt's a tie, both fighters died in this battle.");
            } else if (!players.isAlive()) {
                graveyardList.add(((Character) playersParty.getMembers().get(indexPlayer)).getName());
                playersParty.getMembers().remove(indexPlayer);
                System.out.println("\n\n" + players.getName() + " has died. Your opponent won this fight.");
                writer.write("\n\n" + players.getName() + " has died. Your opponent won this fight.");
            } else if (!opponents.isAlive()) {
                graveyardList.add(((Character) opponentsParty.getMembers().get(indexOpponent)).getName());
                opponentsParty.getMembers().remove(indexOpponent);
                System.out.println("\n\n" + opponents.getName() + " has died. You won this fight!");
                writer.write("\n\n" + opponents.getName() + " has died. You won this fight!");
            }
            round++;
        }
        System.out.println("Graveyard: " + graveyardList.toString() + "\n");
        writer.write("\nGraveyard: " + graveyardList.toString());
    }

    public void fullBattle(Scanner scanner, Writer writer) throws IOException {
        int i = 1;
        while (playersParty.getSize() > 0 && opponentsParty.getSize() > 0) {
            //player chooses fighter
            writer.write("Duel " + i + "\n");
            int indexPlayer =  playersParty.chooseFighter(scanner, writer);
            int indexOpponent = (int) Math.floor(Math.random() * opponentsParty.getSize());
            System.out.println("Your opponent has chosen: "
                    + opponentsParty.getMembers().get(indexOpponent).toString());
            writer.write("Your opponent has chosen: "
                    + opponentsParty.getMembers().get(indexOpponent).toString() + "\n\n");
            this.twoPlayersFight(indexPlayer, indexOpponent, writer);
            writer.write("\n===========================================================================\n");
            i++;
        }
        declareWinner(scanner, writer);
    }

    public void declareWinner(Scanner scanner, Writer writer) throws IOException {
        if (opponentsParty.getSize() == 0 && playersParty.getSize()==0) {

            System.out.println("\nIt's a tie!");
            writer.write("IT'S A TIE");
            System.out.println("    __________   _________    ___       ________________   __\n" +
                    "   /  _/_  __/  /  _/ ___/   /   |     /_  __/  _/ ____/  / /\n" +
                    "   / /  / /     / / \\__ \\   / /| |      / /  / // __/    / / \n" +
                    " _/ /  / /    _/ / ___/ /  / ___ |     / / _/ // /___   /_/  \n" +
                    "/___/ /_/    /___//____/  /_/  |_|    /_/ /___/_____/  (_) ");


            writer.write("  __________   _________    ___       ________________   __\n" +
                    "   /  _/_  __/  /  _/ ___/   /   |     /_  __/  _/ ____/  / /\n" +
                    "   / /  / /     / / \\__ \\   / /| |      / /  / // __/    / / \n" +
                    " _/ /  / /    _/ / ___/ /  / ___ |     / / _/ // /___   /_/  \n" +
                    "/___/ /_/    /___//____/  /_/  |_|    /_/ /___/_____/  (_) ");


        } else if (opponentsParty.getSize() == 0 ) {
            System.out.println("\nYou have defeated all of your opponents!");
            writer.write("\nYou have defeated all of your opponents!\n\n");
            System.out.println("\n__  ______  __  __   _       ______  _   __   __\n" +
                    "\\ \\/ / __ \\/ / / /  | |     / / __ \\/ | / /  / /\n" +
                    " \\  / / / / / / /   | | /| / / / / /  |/ /  / / \n" +
                    " / / /_/ / /_/ /    | |/ |/ / /_/ / /|  /  /_/  \n" +
                    "/_/\\____/\\____/     |__/|__/\\____/_/ |_/  (_)   \n" +
                    "                                              ");
            writer.write("__  ______  __  __   _       ______  _   __   __\n" +
                    "\\ \\/ / __ \\/ / / /  | |     / / __ \\/ | / /  / /\n" +
                    " \\  / / / / / / /   | | /| / / / / /  |/ /  / / \n" +
                    " / / /_/ / /_/ /    | |/ |/ / /_/ / /|  /  /_/  \n" +
                    "/_/\\____/\\____/     |__/|__/\\____/_/ |_/  (_)   \n" +
                    "                                              ");
        }else{
            System.out.println("\nAll of your fighters have died.");
            writer.write("\nAll of your fighters have died.\n\n");
            System.out.println("\n__  ______  __  __   __    ____  ___________\n" +
                    "\\ \\/ / __ \\/ / / /  / /   / __ \\/ ___/_  __/\n" +
                    " \\  / / / / / / /  / /   / / / /\\__ \\ / /   \n" +
                    " / / /_/ / /_/ /  / /___/ /_/ /___/ // /    \n" +
                    "/_/\\____/\\____/  /_____/\\____//____//_/     \n" +
                    "                                      ");

            writer.write("__  ______  __  __   __    ____  ___________\n" +
                    "\\ \\/ / __ \\/ / / /  / /   / __ \\/ ___/_  __/\n" +
                    " \\  / / / / / / /  / /   / / / /\\__ \\ / /   \n" +
                    " / / /_/ / /_/ /  / /___/ /_/ /___/ // /    \n" +
                    "/_/\\____/\\____/  /_____/\\____//____//_/     \n" +
                    "                                      ");
        }
    }
}




