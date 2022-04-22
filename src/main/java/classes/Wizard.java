package classes;

public class Wizard extends Character{
    private int mana;
    private int intelligence;

    public Wizard(int id, String name, int hp, int mana, int intelligence) {
        super(id, name, hp);
        this.mana = mana;
        this.intelligence = intelligence;
    }

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

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
}
