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


    public Party removeDeadCharacterFromParty(Party party, int characterIndex){
        if( party == null || characterIndex < 0 || characterIndex >= party.getSize()){

            public Party removeDeadCharacterFromParty(Party party, int characterIndex) {
                if (party.getMembers() == null || characterIndex < 0 || characterIndex >= party.getMembers().size()) {

                    System.out.println("The character is not born yet!");
                    return party;
                }
                //alternate code (the ArrayList size should change automatically as items are removed):
                party.getMembers().remove(characterIndex);

                // Create another array of size one less

                party.removeMember(characterIndex);
                return party;

     /*   Party partyWithOutTheDeadCharacter = new Party(party.getSize()-1);
        for(int i=0; i< party.getSize();i++){
            if(i == characterIndex) {
            continue;
            }else{

        ArrayList partyWithOutTheDeadCharacter = new ArrayList(party.size() - 1);
        for (int i = 0; i < party.size(); i++) {
            if (i == characterIndex) {
                continue;
            } else {

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


        }else{
                //Here goes victory or defeat method
            }*/

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


