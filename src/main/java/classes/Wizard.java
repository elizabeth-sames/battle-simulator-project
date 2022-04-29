package classes;

import java.util.Scanner;

public class Wizard extends Character{
    private int mana;
    private int intelligence;
    private final String characterType = "Wizard";

    static String[] wizardNames = {"Albus", "Alva", "Bertram", "Circe", "Fredo", "Glinda", "Lazar", "Vesta", "Merlin", "Olive",
            "Ulfred", "Raven", "Elric", "Agnes", "Lucien", "Minerva", "Ren", "Morgan", "Osiris", "Ursula"};

    
    //CONSTRUCTOR
    public Wizard(String name, int hp, int mana, int intelligence) {
        super(name, hp);
        this.mana = mana;
        this.intelligence = intelligence;
        setIntelligence(intelligence);
        setHp(hp);
        setMana(mana);
    }

    public Wizard() {
    }


    //SETTERS
    public void setIntelligence(int intelligence) {
        if(intelligence >= 1 && intelligence <= 50){
            this.intelligence = intelligence;
        } else if(intelligence < 1) {
            this.intelligence = 1;
        } else {
            this.intelligence = 50;
        }
    }

    public void setMana(int mana) {
        if(mana >= 10 && mana <= 50){
            this.mana = mana;
        } else if(mana < 10){
            this.mana = 10;
        } else {
            this.mana = 50;
        }
    }

    @Override
    public void setHp(int hp){
        if(hp >= 50 || hp <= 100){
            super.setHp(hp);
        } else if (hp < 50){
            super.setHp(50);
        } else {
            super.setHp(100);
        }
    }

    //GETTERS
    public int getMana() {
        return mana;
    }
    public int getIntelligence() {
        return intelligence;
    }
    public String getCharacterType() {
        return characterType;
    }

    //METHODS
    public void makeRandom() {
        super.setHp((int) Math.floor(Math.random()*51 + 50));
        this.mana = (int) Math.floor(Math.random()*41 + 10);
        this.intelligence = (int) Math.floor(Math.random()*50 + 1);
        super.setName(wizardNames[(int) Math.floor(Math.random()*(wizardNames.length))]);
    }
    public void makeCustom(Scanner scanner) {
        System.out.println("Please, choose a name for your warrior");
        String name = scanner.next();
        super.setName(name);
        System.out.println("Now choose a number between 50-100 representing the health points");
        int hp = Utility.verifyIntInput(scanner, 50, 100);
        super.setHp(hp);
        System.out.println(("Choose a mana between 10 and 50"));
        int mana = Utility.verifyIntInput(scanner,10,50);
        setMana(mana);
        System.out.println("Please, choose intelligence between 1 and 50");
        int intelligence = Utility.verifyIntInput(scanner,1,50);
        setIntelligence(intelligence);
    }

    public int attack() {
        int damage = this.intelligence;
        if(this.mana >= 5){
            //Fireball
            this.mana = this.mana - 5;
            return damage;
        } else {
            //Staff hit
            this.mana = this.mana + 1;
            return 2;
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
    public String attackMessage() {
        if (this.getHp() >= 5) {
            return this.getName() + " threw a Fireball";
        } else {
            return "Staff hit by " + this.getName();
        }
    }

    @Override
    public String toString() {
        return this.getName() + " (Wizard)  hp: " + this.getHp() + "  mana: " + this.mana
                + "  intelligence:" + intelligence;
    }

}
