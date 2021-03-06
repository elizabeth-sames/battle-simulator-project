package classes;

import java.io.*;
import java.util.*;

public class Party {
    private List<Object> members;
    static String[] warriorNames = {"Milo", "Bertha", "Evander", "Sena", "Walter", "Hilda", "Marco", "Zelda", "Kane", "Magda",
            "Ragnar", "Otto", "Gunner", "Imelda", "Luther", "Clovis", "Igor", "Gert", "Harold", "Lou"};
    static String[] wizardNames = {"Albus", "Alva", "Bertram", "Circe", "Fredo", "Glinda", "Lazar", "Vesta", "Merlin", "Olive",
            "Ulfred", "Raven", "Elric", "Agnes", "Lucien", "Minerva", "Ren", "Morgan", "Osiris", "Ursula"};

    public Party() {
        this.members = new ArrayList<>();
    }

    public void makeRandomParty() throws IOException {
        //FileWriter writer2 = new FileWriter("import-parties.csv", true);
        Random rand = new Random();
        List<String> usedNames = new ArrayList<>();
        while(this.members.size() < 4){
            boolean isWarrior = rand.nextBoolean();
            if(isWarrior == true){
                Warrior newWarrior = new Warrior();
                newWarrior.makeRandom();
                newWarrior.changeNameIfDuplicate(usedNames);
                usedNames.add(newWarrior.getName().toLowerCase());
                this.members.add(newWarrior);
                //writer2.write(newWarrior.warriorData());
            } else {
                Wizard newWizard = new Wizard();
                newWizard.makeRandom();
                newWizard.changeNameIfDuplicate(usedNames);
                usedNames.add(newWizard.getName().toLowerCase());
                this.members.add(newWizard);
                //writer2.write(newWizard.wizardData());

            }
        }
        //writer2.close();
    }

    public void makeCustomParty(Scanner scanner) throws FileNotFoundException {
        //PrintWriter writer2 = new PrintWriter("exported-parties.csv");
        List<String> usedNames = new ArrayList<>();
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
            //make a warrior
            if (character.equals("warrior")) {
                Warrior newWarrior = new Warrior();
                newWarrior.makeCustom(scanner);
                newWarrior.changeNameIfDuplicate(usedNames);
                usedNames.add(newWarrior.getName().toLowerCase());
                System.out.println(newWarrior);
                this.members.add(newWarrior);
                //writer2.write(newWarrior.warriorData());
            } else {
                //make a wizard
                Wizard newWizard = new Wizard();
                newWizard.makeCustom(scanner);
                newWizard.changeNameIfDuplicate(usedNames);
                usedNames.add(newWizard.getName().toLowerCase());
                System.out.println(newWizard);
                this.members.add(newWizard);
                //writer2.write(newWizard.wizardData());
            }
        }
        //writer2.close();
    }

    public void makeCsvParty(File file) throws FileNotFoundException {
        List<String> usedNames = new ArrayList<>();
        Scanner scanner = new Scanner(file);
        while(this.members.size() < 4 && scanner.hasNextLine()){
            String data = scanner.nextLine();
            String[] dataArray = data.split(",");
            if(dataArray[0].equals("Warrior")) {
                Warrior newWarrior = new Warrior();
                newWarrior.setName(dataArray[1]);
                newWarrior.changeNameIfDuplicate(usedNames);
                usedNames.add(newWarrior.getName());
                newWarrior.setHp(Integer.parseInt(dataArray[2]));
                newWarrior.setStamina(Integer.parseInt(dataArray[3]));
                newWarrior.setStrength(Integer.parseInt(dataArray[4]));
                this.members.add(newWarrior);
            } else {
                Wizard newWizard = new Wizard();
                newWizard.setName(dataArray[1]);
                newWizard.changeNameIfDuplicate(usedNames);
                usedNames.add(newWizard.getName());
                newWizard.setHp(Integer.parseInt(dataArray[2]));
                newWizard.setMana(Integer.parseInt(dataArray[3]));
                newWizard.setIntelligence(Integer.parseInt(dataArray[4]));
                this.members.add(newWizard);
            }
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

    @Override
    public String toString() {
        return this.members.get(0).toString() + "\n" + this.members.get(1).toString() + "\n"
                + this.members.get(2).toString() + "\n" + this.members.get(3).toString();
    }

    public int chooseFighter(Scanner scanner, Writer writer) throws IOException {
        System.out.println("Choose your fighter:");
        writer.write("Your battle party had these members:  \n");
        for (int i=0; i<members.size(); i++) {
            System.out.println("Enter " + (i+1) + " for " + members.get(i).toString());
            writer.write( members.get(i).toString() + "\n");
        }
        int index = Utility.verifyIntInput(scanner, 0, members.size()) - 1;
        System.out.println("You have chosen: " + members.get(index).toString());
        writer.write("\nYou have chosen: " + members.get(index).toString() +"\n");
        return index;
    }

}
