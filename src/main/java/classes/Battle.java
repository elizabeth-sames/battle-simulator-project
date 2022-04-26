package classes;

import java.lang.management.PlatformLoggingMXBean;
import java.util.ArrayList;
import java.util.Random;

public class Battle {
    private Party playersParty;
    private Party oponentsParty;

    public Battle(Party playersParty, Party oponentsParty) {
        this.playersParty = playersParty;
        this.oponentsParty = oponentsParty;
    }

    public Party getPlayersParty() {
        return playersParty;
    }

    public Party getOponentsParty() {
        return oponentsParty;
    }

    public void setPlayersParty(Party playersParty) {
        this.playersParty = playersParty;
    }

    public void setOponentsParty(Party oponentsParty) {
        this.oponentsParty = oponentsParty;
    }

    //Remove method

    public Party removeDeadCharacterFromParty(Party party, int characterIndex) {
        if (party.getMembers() == null || characterIndex < 0 || characterIndex >= party.getMembers().size()) {
            System.out.println("The character is not born yet!");
            return party;
        }
        //alternate code (the ArrayList size should change automatically as items are removed):
        party.getMembers().remove(characterIndex);

        // Create another array of size one less
        ArrayList partyWithOutTheDeadCharacter = new ArrayList(party.size() - 1);
        for (int i = 0; i < party.size(); i++) {
            if (i == characterIndex) {
                continue;
            } else {
                partyWithOutTheDeadCharacter.add(party.get(i));
            }
            return partyWithOutTheDeadCharacter;


        }

    }

    public void fight() {

        while (playersParty.getMembers().size() > 0 && oponentsParty.getMembers().size() > 0) {
            int randomPlayerIndex = new Random().nextInt(playersParty.getMembers().size());
            int randomOponentIndex = new Random().nextInt(oponentsParty.getMembers().size());

            //can't create a Character... need to add characterType to attributes to differentiate
            // which are warriors and which are wizards in order to create appropriate variables for them...
            Character randomPlayer = playersParty.getMembers().get(randomPlayerIndex);
            Character randomOponent = oponentsParty.getMembers().get(randomOponentIndex);

            while (randomPlayer.isAlive() && randomOponent.isAlive()) {
                int damageCausedByPlayer = randomPlayer.attack();
                int damageCausedByOponent = randomOponent.attack();

                randomPlayer.setHp(randomPlayer.getHp() - damageCausedByOponent);
                randomOponent.setHp(randomOponent.getHp() - damageCausedByPlayer);
            }
            if (!randomPlayer.isAlive()) {
                playersParty = removeDeadCharacterFromParty(playersParty, randomPlayerIndex);
                //add randomPlayer to graveyard
                System.out.println(randomOponent.getName() + " has won this fight!");
            }
            if (!randomOponent.isAlive()) {
                oponentsParty = removeDeadCharacterFromParty(oponentsParty, randomOponentIndex);
                //add randomOponent to graveyard
                System.out.println(randomPlayer.getName() + " has won this fight!");
            }
        }


        //While there is at least one member in each party do:
        //Choose a member from each party to duel against one each other
        //Call attack method to both members
        //Check if they are alive, if they are still alive they keep attacking until one is dead.
        //If one of the members is dead send it to graveyard and remove it from the party (The other member stays in its party).

        //Else if at least one party is empty call method winner and defeat method.

    }
}


