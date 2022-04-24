package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Party {
    private List<Object> members;
    static String[] warriorNames = {"Milo", "Bertha", "Evander", "Sena", "Walter", "Hilda", "Marco", "Zelda", "Kane", "Magda",
            "Ragnar", "Otto", "Gunner", "Imelda", "Luther", "Clovis", "Igor", "Gert", "Harold", "Lou"};
    static String[] wizardNames = {"Albus", "Alva", "Bertram", "Circe", "Fredo", "Glinda", "Lazar", "Vesta", "Merlin", "Olive",
            "Ulfred", "Raven", "Elric", "Agnes", "Lucien", "Minerva", "Ren", "Morgan", "Osiris", "Ursula"};

    public Party() {
        this.members = new ArrayList<>();
    }

    public void makeRandomParty() {
        Random rand = new Random();
        List<String> usedNames = new ArrayList<>();
        while(this.members.size() < 4){
            boolean isWarrior = rand.nextBoolean();
            if(isWarrior == true){
                //random name
                int min = 0;
                int max = warriorNames.length-1;
                String name = warriorNames[(int) Math.floor(Math.random()*(max - min + 1) + min)];
                //check if name already exists in party, add Jr if it does
                if(usedNames.contains(name)){
                    name = name + "Jr";
                }
                usedNames.add(name);

                //random hp, stamina, strength
                int hp = (int) Math.floor(Math.random()*101 + 100);
                int stamina = (int) Math.floor(Math.random()*41 + 10);
                int strength = (int) Math.floor(Math.random()*10 + 1);

                //create new warrior and add to party
                Warrior newWarrior = new Warrior(name, hp, stamina, strength);
                this.members.add(newWarrior);
            } else {
                //random name
                String name = wizardNames[rand.nextInt(wizardNames.length)];
                //check if name already exists in party, add Jr if it does
                if(usedNames.contains(name)){
                    name = name + "Jr";
                }
                usedNames.add(name);

                //random hp, mana, intelligence
                int hp = (int) Math.floor(Math.random()*51 + 50);
                int mana = (int) Math.floor(Math.random()*41 + 10);
                int intelligence = (int) Math.floor(Math.random()*50 + 1);

                //create new wizard and add to party
                Wizard newWizard = new Wizard(name, hp, mana, intelligence);
                this.members.add(newWizard);
            };
        };
    };

    public List<Object> getMembers() {
        return members;
    }

    public void setMembers(List<Object> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return this.members.get(0).toString() + "\n" + this.members.get(1).toString() + "\n"
                + this.members.get(2).toString() + "\n" + this.members.get(3).toString();
    }
}
