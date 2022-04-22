package classes;

import interfaces.Attacker;

public abstract class Character implements Attacker {
    private int id; //use int or other type???
    private String name;
    private int hp;
    private boolean isAlive;

    public Character(int id, String name, int hp) {
        this.id = id;
        this.name = name;
        this.hp = hp;
        this.isAlive = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
