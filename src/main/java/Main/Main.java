package Main;

import classes.Party;
import classes.Warrior;
import classes.Wizard;

import java.util.random.RandomGenerator;

public class Main {
    public static void main(String[] args) {
        Party testParty = new Party();
        testParty.makeRandomParty();
        System.out.println(testParty.toString());



    }


}
