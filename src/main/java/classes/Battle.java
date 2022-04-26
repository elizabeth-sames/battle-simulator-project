package classes;

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

    public Party removeDeadCharacterFromParty(Party party, int characterIndex){
        if( party == null || characterIndex < 0 || characterIndex >= party.getSize()){
            System.out.println("The character is not born yet!");
            return party;
        }
        // Create another array of size one less
        party.removeMember(characterIndex);
        return party;
        
     /*   Party partyWithOutTheDeadCharacter = new Party(party.getSize()-1);
        for(int i=0; i< party.getSize();i++){
            if(i == characterIndex) {
            continue;
            }else{
                partyWithOutTheDeadCharacter.add(party.get(i));
            }
            return partyWithOutTheDeadCharacter;


        }*/

    }

    public void twoPlayersFight(int indexPlayer, int indexOponent){
        Character players = playersParty.getMembers().get(indexPlayer);
        Character oponents = oponentsParty.getMembers().get(indexOponent);

        while(players.isAlive() && oponents.isAlive()) {
            int damageCausedByPlayer = players.attack();
            int damageCausedByOponent = oponents.attack();

            players.setHp(players.getHp() - damageCausedByOponent);
            oponents.setHp(oponents.getHp() - damageCausedByPlayer);

    }
        if(!players.isAlive()){
            playersParty = removeDeadCharacterFromParty(playersParty, indexPlayer);
            //add randomPlayer to graveyard
        }
        if(!oponents.isAlive()){
            oponentsParty = removeDeadCharacterFromParty(oponentsParty, indexOponent);
            //add randomOponent to graveyard
        }
}
    /*public void fight(){

        while(playersParty.getSize() > 0 &&  oponentsParty.getSize() > 0){
            int randomPlayerIndex = new Random().nextInt(playersParty.getSize());
            int randomOponentIndex = new Random().nextInt(oponentsParty.getSize());

            int randomPlayer = playersParty.get(randomPlayerIndex).getId();//to access the ID
            int randomOponent = oponentsParty.get(randomOponentIndex).getId();

            while(randomPlayer.isAlive() && randomOponent.isAlive()) {
                int damageCausedByPlayer = randomPlayer.attack();
                int damageCausedByOponent = randomOponent.attack();

                randomPlayer.setHp(randomPlayer.getHp() - damageCausedByOponent);
                randomOponent.setHp(randomOponent.getHp() - damageCausedByPlayer);


            }else{
                if(!randomPlayer.isAlive()){
                    playersParty = removeDeadCharacterFromParty(playersParty, randomPlayerIndex);
                    //add randomPlayer to graveyard
                }
                if(!randomOponent.isAlive()){
                    oponentsParty = removeDeadCharacterFromParty(oponentsParty, randomOponentIndex);
                    //add randomOponent to graveyard
            }

        }else{
                //Here goes victory or defeat method
            }*/

        //While there is at least one member in each party do:
        //Choose a member from each party to duel against one each other
        //Call attack method to both members
        //Check if they are alive, if they are still alive they keep attacking until one is dead.
        //If one of the members is dead send it to graveyard and remove it from the party (The other member stays in its party).

        //Else if at least one party is empty call method winner and defeat method.

    }


