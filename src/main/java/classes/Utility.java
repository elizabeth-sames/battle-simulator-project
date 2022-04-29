package classes;

import java.util.Scanner;

public class Utility {

    public static int verifyIntInput(Scanner scanner, int min, int max) {
        boolean flag;
        int num = -1;
        String input;
        do { input = scanner.next();
            try {
                Integer.parseInt(input);
                flag = false;
            } catch (NumberFormatException e) {
                System.err.println("Enter a number " + min + "-" + max);
                flag = true;
            }
            if (!flag) {
                num = Integer.parseInt(input);
                if (num > max || num < min) {
                    System.err.println("Enter a number " + min + "-" + max);
                    flag = true;
                }
            }
        } while (flag);
        return num;
    }

}
