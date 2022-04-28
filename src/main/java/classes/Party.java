package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

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

    public void makeCustomParty(Scanner scanner) {
        //Scanner scanner2= new Scanner(System.in);
        while(this.members.size()<4) {
            System.out.println(
                    "Please, choose a new member for your party" +
                    "\nEnter Warrior or Wizard"
            );
            String character = scanner.next().toLowerCase();
            while (!character.equals("wizard") && !character.equals("warrior")) {
                System.err.println("This character does not exist.");
                System.err.println("Please, choose between warrior and wizard");
                character = scanner.next().toLowerCase();
            }
            System.out.println("You have chosen " + character);
            System.out.println("Please, choose a name for your " + character);
            String name = scanner.next();
            System.out.println(name + " is a new " + character + " of your party");

            //make a warrior
            if (character.equals("warrior")) {
                System.out.println("Now choose a number between 100-200 representing the health points");
                int hp = scanner.nextInt();
                    if ((int) hp < 100 || hp > 200) {
                        System.err.println("Choose 100-200");
                        hp = scanner.nextInt();
                    }
                System.out.println(name + " has " + hp + " of health points");

                System.out.println(("Choose stamina between 10 and 50"));
                int stamina = scanner.nextInt();

                while (stamina < 10 || stamina > 50) {
                    System.err.println("Choose 10-50");
                    stamina = scanner.nextInt();
                }
                System.out.println(name + " has " + stamina + " of stamina");

                System.out.println((name + " needs an strength between 1 and 10"));
                int strength = scanner.nextInt();

                while (strength < 1 || strength > 10) {
                    System.err.println("Choose 1-10");
                    strength = scanner.nextInt();
                }

                Warrior warrior = new Warrior(name, hp, stamina, strength);
                System.out.println(warrior);
                this.members.add(warrior);
            } else {
                //make a wizard
                System.out.println("Now choose a number between 50-100 representing the health points");
                int hp = scanner.nextInt();

                while (hp < 50 || hp > 100) {
                    System.err.println("Choose 50-100");
                    hp = scanner.nextInt();
                }
                System.out.println(name + " has " + hp + "of health points");

                System.out.println((name + " needs mana between 10 and 50"));
                int mana = scanner.nextInt();
                while (mana < 10 || mana > 50) {
                    System.err.println("Choose a number between 10 and 50");
                    mana = scanner.nextInt();
                }
                System.out.println(name + " has an health point of " + mana);

                System.out.println("Please, choose intelligence for " + name + " a number between 1 and 50");
                int intelligence = scanner.nextInt();
                while (intelligence < 1 || intelligence > 50) {
                    System.err.println("Choose a number between 1 and 50");
                    intelligence = scanner.nextInt();
                }
                System.out.println(name + " has an health point of " + intelligence);

                Wizard wizard = new Wizard(name, hp, mana, intelligence);
                System.out.println(wizard);
                this.members.add(wizard);
            }
        }
        //scanner2.close();
    }

    public void makeCsvParty1(){
        List<String> usedNames = new ArrayList<>();
        while(this.members.size() < 4){
            Scanner scanner = new Scanner("party1.csv");
            while(scanner.hasNextLine()) {
                String data = scanner.nextLine();
                String[] dataArray = data.split(",");
                if(dataArray[0] == "Warrior") {
                    Warrior newWarrior = new Warrior();
                    newWarrior.setName(dataArray[2]);
                    if(usedNames.contains(newWarrior.getName())){
                        newWarrior.setName(newWarrior.getName() + "Jr");
                    }
                    usedNames.add(newWarrior.getName());
                    newWarrior.setHp(Integer.parseInt(dataArray[3]));
                    newWarrior.setStamina(Integer.parseInt(dataArray[5]));
                    newWarrior.setStrength(Integer.parseInt(dataArray[6]));
                    this.members.add(newWarrior);
                } else {
                    Wizard newWizard = new Wizard();
                    newWizard.setName(dataArray[2]);
                    if(usedNames.contains(newWizard.getName())){
                        newWizard.setName(newWizard.getName() + "Jr");
                    }
                    usedNames.add(newWizard.getName());
                    newWizard.setHp(Integer.parseInt(dataArray[3]));
                    newWizard.setMana(Integer.parseInt(dataArray[7]));
                    newWizard.setIntelligence(Integer.parseInt(dataArray[8]));
                    this.members.add(newWizard);
                }
            }
            //scanner.close();
        }
    }



    public List<Object> getMembers() {
        return members;
    }

    public void setMembers(List<Object> members) {
        this.members = members;
    }

    //Get size of the party
    public int getSize(){return members.size();}

    //Remove character in Battle
    public void removeMember(int removeIndex){
        this.members.remove(removeIndex);
    }



    @Override
    public String toString() {
        return this.members.get(0).toString() + "\n" + this.members.get(1).toString() + "\n"
                + this.members.get(2).toString() + "\n" + this.members.get(3).toString();
    }
}
