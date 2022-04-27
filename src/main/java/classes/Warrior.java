package classes;

public class Warrior extends Character {
    private int stamina;
    private int strength;
    private final String characterType = "Warrior";




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
        if(hp <=0){
            super.setHp(0);
            super.setAlive(false);
        } else if(hp >= 100 && hp <= 200){
            super.setHp(hp);
        } else {
            super.setHp(hp);
        }
    }



    @Override
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




    //METHODS
    public int attack() {
        int damage = this.strength;
        if(this.stamina > 5){
            //Heavy attack
            this.stamina = this.stamina - 5;
            return damage;
        } else {
            //Weak attack
            this.stamina += 1;
            return (int) damage/2;
        }
    }

}
