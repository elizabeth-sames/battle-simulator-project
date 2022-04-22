package classes;

public class Warrior extends Character {
    private int stamina;
    private int strength;

    public Warrior(int id, String name, int hp, int stamina, int strength) {
        super(id, name, hp);
        this.stamina = stamina;
        this.strength = strength;
    }

    public int attack() {
        int damage = this.stamina;
        if(this.stamina>5){
            //Heavy attack
            this.stamina = this.strength - 5;
            return damage;
        } else {
            //Weak attack
            this.stamina = this.stamina - 1;
            return damage/2;
        }
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
}
