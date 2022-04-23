package classes;

import interfaces.Attacker;

import java.util.random.RandomGenerator;

public abstract class Character implements Attacker {
    private int id; //use int or other type???
    private String name;
    private int hp;
    private boolean isAlive;



    //CONSTRUCTOR
    public Character(int id, String name, int hp) {
        this.id = id;
        this.name = name;
        this.hp = hp;
        this.isAlive = true;
    }



    //SETTERS
    public void setHp(int hp){
        this.hp = hp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void setName(String name) {
        this.name = name;
    }



    //GETTERS
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public int getHp() {
        return hp;
    }
}
