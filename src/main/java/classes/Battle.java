package classes;

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

    //Remove method

    public Party removeDeadCharacterFromParty (Party party,int characterIndex) {
        if (party.getMembers() == null || characterIndex < 0 || characterIndex >= party.getMembers().size()) {

            System.out.println("The character is not born yet!");
            return party;
        } else {
            //alternate code (the ArrayList size should change automatically as items are removed):
            party.getMembers().remove(characterIndex);

            party.removeMember(characterIndex);
            return party;
        }
    }

    public List<Object> getGraveyardList() {
        return graveyardList;
    }

    public void twoPlayersFight(int indexPlayer, int indexOpponent){
        Character players = (Character) playersParty.getMembers().get(indexPlayer);
        Character opponents = (Character) opponentsParty.getMembers().get(indexOpponent);

        int round =1;
        while (players.isAlive() && opponents.isAlive()) {
            int damageCausedByPlayer = players.attack();
            int damageCausedByOpponent = opponents.attack();

            String attackTypePlayer = "";
            if(players.getCharacterType() == "Warrior") {
                if (players.getHp() > 5) {
                    attackTypePlayer = "Heavy Attack";
                } else {
                    attackTypePlayer = "Weak Attack";
                }
            } else {
                if (players.getHp() > 5) {
                    attackTypePlayer = "Fireball";
                } else {
                    attackTypePlayer = "Staff hit";
                }
            }

            String attackTypeOpponent = "";
            if(opponents.getCharacterType() == "Warrior") {
                if (players.getHp() > 5) {
                    attackTypeOpponent = "Heavy Attack";
                } else {
                    attackTypeOpponent = "Weak Attack";
                }
            } else {
                if (players.getHp() > 5) {
                    attackTypeOpponent = "Fireball";
                } else {
                    attackTypeOpponent = "Staff hit";
                }
            }

            players.setHp(players.getHp() - damageCausedByOpponent);
            opponents.setHp(opponents.getHp() - damageCausedByPlayer);
            System.out.println("\nRound " + round + ":   \n" +
                     players.getName() + " has done a " + attackTypePlayer + "\n" +
                    opponents.getName() + " has done a " + attackTypeOpponent);

            if (!players.isAlive()) {
                graveyardList.add(((Character) playersParty.getMembers().get(indexPlayer)).getName());
                //playersParty = removeDeadCharacterFromParty(playersParty, indexPlayer);
                playersParty.getMembers().remove(indexPlayer);
                System.out.println("\nYour opponent has won this fight");
                System.out.println("Graveyard: " + graveyardList.toString() + "\n");
            }
            if (!opponents.isAlive()) {
                graveyardList.add(((Character) opponentsParty.getMembers().get(indexOpponent)).getName());
                //opponentsParty = removeDeadCharacterFromParty(opponentsParty, indexOpponent);
                opponentsParty.getMembers().remove(indexOpponent);
                System.out.println("\nYou have won this fight!");
                System.out.println("Graveyard: " + graveyardList.toString() + "\n");
            }
            round++;
        }

    }
}



