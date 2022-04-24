package classes;

import java.util.ArrayList;
import java.util.Random;

public class Battle {
    private ArrayList playersParty;
    private ArrayList oponentsParty;

    public Battle(ArrayList playersParty, ArrayList oponentsParty) {
        this.playersParty = playersParty;
        this.oponentsParty = oponentsParty;
    }

    public ArrayList getPlayersParty() {
        return playersParty;
    }

    public ArrayList getOponentsParty() {
        return oponentsParty;
    }

    public void setPlayersParty(ArrayList playersParty) {
        this.playersParty = playersParty;
    }

    public void setOponentsParty(ArrayList oponentsParty) {
        this.oponentsParty = oponentsParty;
    }

    //Remove method

    public ArrayList removeDeadCharacterFromParty(ArrayList party, int characterIndex){
        if( party == null || characterIndex < 0 || characterIndex >= party.size()){
            System.out.println("The character is not born yet!");
            return party;
        }
        // Create another array of size one less
        ArrayList partyWithOutTheDeadCharacter = new ArrayList(party.size()-1);
        for(int i=0; i< party.size();i++){
            if(i == characterIndex) {
            continue;
            }else{
                partyWithOutTheDeadCharacter.add(party.get(i));
            }
            return partyWithOutTheDeadCharacter;


        }

    }

    public void fight(){

        while(playersParty.size() > 0 &&  oponentsParty.size() > 0){
            int randomPlayerIndex = new Random().nextInt(playersParty.size());
            int randomOponentIndex = new Random().nextInt(oponentsParty.size());

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
            }

        //While there is at least one member in each party do:
        //Choose a member from each party to duel against one each other
        //Call attack method to both members
        //Check if they are alive, if they are still alive they keep attacking until one is dead.
        //If one of the members is dead send it to graveyard and remove it from the party (The other member stays in its party).

        //Else if at least one party is empty call method winner and defeat method.

    }


