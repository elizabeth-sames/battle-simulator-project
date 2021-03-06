package classes;

import java.util.Locale;
import java.util.Scanner;

public class Warrior extends Character {
    private int stamina;
    private int strength;
    private final String characterType = "Warrior";
    static String[] warriorNames = {"Milo", "Bertha", "Evander", "Sena", "Walter", "Hilda", "Marco", "Zelda", "Kane", "Magda",
            "Ragnar", "Otto", "Gunner", "Imelda", "Luther", "Clovis", "Igor", "Gert", "Harold", "Lou"};

    //CONSTRUCTOR
    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
        this.stamina = stamina;
        this.strength = strength;
        setStamina(stamina);
        setStrength(strength);
        setHp(hp);
    }

    public Warrior() {
    }

    //SETTERS
    public void setStrength(int strength) {
        if(strength >= 1 && strength <= 10){
            this.strength = strength;
        } else  if (strength < 1){
            this.strength = 1;
        } else {
            this.strength = 10;
        }
    }

    public void setStamina(int stamina) {
        if(stamina >= 10 && stamina <= 50){
            this.stamina = stamina;
        } else if(stamina < 10){
            this.strength = 10;
        } else {
            this.strength = 50;
        }
    }

    @Override
    public void setHp(int hp){
        if(hp >= 100 && hp <= 200){
            super.setHp(hp);
        } else if (hp<100){
            super.setHp(100);
        } else {
            super.setHp(200);
        }
    }

    public void applyDamageFromAttack(int hp){
        if(hp <=0){
            super.setHp(0);
            super.setAlive(false);
        } else {
            super.setHp(hp);
        }
    }




    public String toString() {
        return this.getName() + " (Warrior)  hp: " + this.getHp() + "  stamina: " + this.stamina
                + "  strength:" + strength;
    }

    //GETTERS
    public int getStamina() {
        return stamina;
    }
    public int getStrength() {
        return strength;
    }
    public String getCharacterType() {
        return characterType;
    }

    //METHODS
    public void makeRandom() {
        super.setHp((int) Math.floor(Math.random()*101 + 100));
        this.stamina = (int) Math.floor(Math.random()*41 + 10);
        this.strength = (int) Math.floor(Math.random()*10 + 1);
        super.setName(warriorNames[(int) Math.floor(Math.random()*(warriorNames.length))]);
    }
    public void makeCustom(Scanner scanner) {
        System.out.println("Please, choose a name for your warrior");
        String name = scanner.next();
        super.setName(name);
        System.out.println("Now choose a number between 100-200 representing the health points");
        int hp = Utility.verifyIntInput(scanner, 100,200);
        super.setHp(hp);
        System.out.println(("Choose stamina between 10 and 50"));
        int stamina = Utility.verifyIntInput(scanner, 10, 50);
        setStamina(stamina);
        System.out.println(("Choose a strength between 1 and 10"));
        int strength = Utility.verifyIntInput(scanner, 1, 10);
        setStrength(strength);
    }

    public int attack() {
        int damage = this.strength;
        if(this.stamina >= 5){
            //Heavy attack
            this.stamina = this.stamina - 5;
            return damage;
        } else {
            //Weak attack
            this.stamina += 1;
            return (int) damage/2;
        }
    }

    public String attackMessage() {
        if (this.getHp() >= 5) {
            return this.getName() + " launched a Heavy Attack";
        } else {
            return "Weak Attack by " + this.getName();
        }
    }

    public String warriorData() {
        return "Warrior," + super.getName() + "," + super.getHp() +
                "," + stamina +
                "," + strength +
                "\n";
    }
}
