package classes;

import interfaces.Attacker;

import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;

public abstract class Character implements Attacker {
    private int id; //use int or other type???
    private String name;
    private int hp;
    private boolean isAlive = true;
    private static int totalCharacterCount = 0;
    private  String characterType;

    //CONSTRUCTOR
    public Character(String name, int hp) {
        totalCharacterCount++;
        this.id = totalCharacterCount;
        this.name = name;
        this.hp = hp;
    }

    public Character() {
    }

    //SETTERS
    public void setHp(int hp){
        if(hp <= 0) {
            this.hp = 0;
            this.isAlive = false;
        } else {
            this.hp = hp;
        }
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
        return this.hp > 0;
    }

    public int getHp() {
        return hp;
    }

    public String getCharacterType() {
        return characterType;
    }

    //METHODS
    public void changeNameIfDuplicate(List<String> usedNames) {
        if (usedNames.contains(this.name.toLowerCase())) {
            this.name = this.name + " Jr";
        }
    }

}
