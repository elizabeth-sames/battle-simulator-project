package classes;

public class Warrior extends Character {
    private int stamina;
    private int strength;



    //CONSTRUCTOR
    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
        this.stamina = stamina;
        this.strength = strength;
        setStamina(stamina);
        setStrength(strength);
        setHp(hp);
    }



    //SETTERS
    public void setStrength(int strength) {
        if(strength >= 1 && strength <= 10){
            this.strength = strength;
        } else {
            System.out.println("Warrior's strength needs to be in between 1 and 10 both inclusive, insert other number.");
        }
    }

    public void setStamina(int stamina) {
        if(stamina >= 10 && stamina <= 50){
            this.stamina = stamina;
        } else {
            System.out.println("Warrior's stamina needs to be in between 10 and 50 both inclusive, insert other number.");
        }
    }

    @Override
    public void setHp(int hp){
        if(hp >= 100 && hp <= 200){
            super.setHp(hp);
        } else {
            System.out.println("Warrior's hp needs to be in between 100 and 200 both inclusive, insert other number.");
        }
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
        if(this.stamina >= 5){
            //Heavy attack
            this.stamina -= 5;
            return damage;
        } else {
            //Weak attack
            this.stamina += 1;
            return damage/2;
        }
    }

}
