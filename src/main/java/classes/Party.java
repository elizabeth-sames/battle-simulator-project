package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Party {
    private List<Character> members;
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

//    public void makeCustomParty() {
//        while(this.members.size()<4){
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("type R to make a Warrior or Z to make a Wizard ");
//            String type = scanner.nextLine().toUpperCase();
//            if(type == "R"){
//                System.out.println("Please name your Warrior");
//                String name = scanner.nextLine();
//                //continue with hp, stamina, and strength
//                Warrior newWarrior = new Warrior(name, hp, stamina, strength);
//                members.add(newWarrior);
//            } else if (type == "Z"){
//                //similar code here, but for wizard
//            }
//        }
//    }

    public List<Character> getMembers() {
        return members;
    }

    //to get the size of Party
    public int getSize(){return members.size();}


    public void setMembers(List<Character> members) {
        this.members = members;
    }

    //method to remove the character in Battle
    public void removeMember(int removeIndex){
         this.members.remove(removeIndex);
    }

    @Override
    public String toString() {
        return this.members.get(0).toString() + "\n" + this.members.get(1).toString() + "\n"
                + this.members.get(2).toString() + "\n" + this.members.get(3).toString();
    }
}
