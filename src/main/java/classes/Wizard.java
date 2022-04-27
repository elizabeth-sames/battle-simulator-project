package classes;

import java.util.random.RandomGenerator;

public class Wizard extends Character{
    private int mana;
    private int intelligence;
    private final String characterType = "Wizard";

    
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

    @Override
    public String toString() {
        return this.getName() + " (Wizard)     hp: " + this.getHp() + "     mana: " + this.mana
                + "     intelligence:" + intelligence;
    }


    //GETTERS
    public int getMana() {
        return mana;
    }
    public int getIntelligence() {
        return intelligence;
    }



    //METHODS
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
}
