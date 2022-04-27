package classes;

import java.util.ArrayList;

public class Battle {
    private Party playersParty;
    private Party oponentsParty;
   ArrayList<String> graveyardList = new ArrayList<>();

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
        if( party == null || characterIndex < 0 || characterIndex >= party.getSize()) {

            public Party removeDeadCharacterFromParty (Party party,int characterIndex){
                if (party.getMembers() == null || characterIndex < 0 || characterIndex >= party.getMembers().size()) {

                    System.out.println("The character is not born yet!");
                    return party;
                }
                //alternate code (the ArrayList size should change automatically as items are removed):
                party.getMembers().remove(characterIndex);

                party.removeMember(characterIndex);
                return party;

            }


            public void twoPlayersFight(int indexPlayer, int indexOponent){
                Character players = (Character) playersParty.getMembers().get(indexPlayer);
                Character oponents = (Character) oponentsParty.getMembers().get(indexOponent);

                while (players.isAlive() && oponents.isAlive()) {
                    int damageCausedByPlayer = players.attack();
                    int damageCausedByOponent = oponents.attack();

                    players.setHp(players.getHp() - damageCausedByOponent);
                    oponents.setHp(oponents.getHp() - damageCausedByPlayer);

                }

                if (!players.isAlive()) {
                    playersParty = removeDeadCharacterFromParty(playersParty, indexPlayer);
                    //add randomPlayer to graveyard
                    System.out.println(oponents.getName() + " has won this fight!");
                }
                if (!oponents.isAlive()) {
                    oponentsParty = removeDeadCharacterFromParty(oponentsParty, indexOponent);
                    //add randomOponent to graveyard
                    System.out.println(players.getName() + " has won this fight!");
                }


            }
        }



