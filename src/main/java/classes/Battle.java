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

            players.setHp(players.getHp() - damageCausedByOpponent);
            opponents.setHp(opponents.getHp() - damageCausedByPlayer);
            System.out.println("Round " + round + ":   \n" +
                     players.toString() + "\n" +
                     opponents.toString());

            if (!players.isAlive()) {
                graveyardList.add(playersParty.getMembers().get(indexPlayer));
                //playersParty = removeDeadCharacterFromParty(playersParty, indexPlayer);
                playersParty.getMembers().remove(indexPlayer);
                System.out.println("Your opponent has won this fight");
            }
            if (!opponents.isAlive()) {
                graveyardList.add(opponentsParty.getMembers().get(indexOpponent));
                //opponentsParty = removeDeadCharacterFromParty(opponentsParty, indexOpponent);
                opponentsParty.getMembers().remove(indexOpponent);
                System.out.println("You have won this fight!");
            }
            round++;
        }

    }
}



