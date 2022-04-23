package classes;

import java.util.random.RandomGenerator;

public class Wizard extends Character{
    private int mana;
    private int intelligence;


    
    //CONSTRUCTOR
    public Wizard(int id, String name, int hp, int mana, int intelligence) {
        super(id, name, hp);
        this.mana = mana;
        this.intelligence = intelligence;
        setIntelligence(intelligence);
        setHp(hp);
        setMana(mana);
    }



    //SETTERS
    public void setIntelligence(int intelligence) {
        if(intelligence >= 1 && intelligence <= 50){
            this.intelligence = intelligence;
        } else {
            System.out.println("Wizard's intelligence needs to be in between 1 and 50 both inclusive, insert other number.");
        }
    }

    public void setMana(int mana) {
        if(mana >= 10 && mana <= 50){
            this.mana = mana;
        } else {
            System.out.println("Wizard's mana needs to be in between 10 and 50 both inclusive, insert other number.");
        }
    }

    @Override
    public void setHp(int hp){
        if(hp >= 50 || hp <= 100){
            super.setHp(hp);
        } else {
            System.out.println("Wizard's hp needs to be in between 50 and 100 both inclusive, insert other number.");
        }
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
        if(this.intelligence>5){
            //Fireball
            this.mana = this.mana - 5;
            return damage;
        } else {
            //Staff hit
            this.mana = this.mana - 1;
            return 2;
        }
    }
}
