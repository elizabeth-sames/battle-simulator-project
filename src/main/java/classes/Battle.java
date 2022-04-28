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


    @Override
    public String toString() {
        return super.toString();
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


    public void twoPlayersFight(int indexPlayer, int indexOpponent) {
        Character players = (Character) playersParty.getMembers().get(indexPlayer);
        Character opponents = (Character) opponentsParty.getMembers().get(indexOpponent);

        int round = 1;
        while (players.isAlive() && opponents.isAlive()) {
            int damageCausedByPlayer = players.attack();
            int damageCausedByOpponent = opponents.attack();

            players.applyDamageFromAttack(players.getHp() - damageCausedByOpponent);
            opponents.applyDamageFromAttack(opponents.getHp() - damageCausedByPlayer);
            System.out.println("Round " + round + ":   \n" +
                     players.attackMessage().concat("\n") +
                            opponents.attackMessage().concat("\n"));

            if (!players.isAlive()) {
                graveyardList.add(((Character) playersParty.getMembers().get(indexPlayer)).getName());
                playersParty.getMembers().remove(indexPlayer);
                System.out.println("Your opponent has won this fight");
                System.out.println("Graveyard: " + graveyardList.toString() + "\n");
            }
            if (!opponents.isAlive()) {
                graveyardList.add(((Character) opponentsParty.getMembers().get(indexOpponent)).getName());
                opponentsParty.getMembers().remove(indexOpponent);
                System.out.println("You have won this fight!");
                System.out.println("Graveyard: " + graveyardList.toString() + "\n");
            }
            round++;
        }

    }

}




