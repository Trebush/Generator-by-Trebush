import encryption.Encryption;
import password_strength.Password_strength;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Main {
    // Array containing ASCII values for special characters, digits, and letters
    static int[] ascii = {33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125,};

    // Method to display the menu options
    static void start() {
        System.out.println("\tGenerator by Trebush");
        System.out.println("1 \t - \t password generator");
        System.out.println("2 \t - \t login generator");
        System.out.println("3 \t - \t login and password generator");
        System.out.println("4 \t - \t check your password strength");
        System.out.println("0 \t - \t exit");
    }

    // Method to handle user's choice and generate the required login/password
    static void whatGenerator(int whatDo, int length, Scanner scanner, Password_strength password_strength) {
        do {
            start(); // Display menu
            whatDo = scanner.nextInt(); // Read user's choice
            switch (whatDo) {
                case 0:
                    System.out.println("Thanks for using ~ Trebush");
                    break;
                case 1:
                    System.out.println("How length do you need in password?");
                    length = scanner.nextInt();
                    System.out.print("Your password is ");
                    System.out.println(generator(length));
                    break;
                case 2:
                    System.out.println("How length do you need in login?");
                    length = scanner.nextInt();
                    System.out.print("Your login is ");
                    System.out.println(generator(length));
                    break;
                case 3:
                    System.out.println("How length do you need in login?");
                    length = scanner.nextInt();
                    System.out.print("Your login is ");
                    System.out.println(generator(length));
                    System.out.println("How length do you need in password?");
                    length = scanner.nextInt();
                    System.out.print("Your password is ");
                    System.out.println(generator(length));
                    break;
                case 4:
                    System.out.println("Enter your password what you want to check");
                    String password = scanner.next();
                    System.out.println(Password_strength.printStrongNess(password));
                    break;
                default:
                    System.out.println("Wrong number");
                    break;
            }
        } while (whatDo != 0); // Repeat until user chooses to exit
    }

    // Method to generate a random string of specified length
    static char[] generator(int length) {
        Random random = new Random();
        char[] characters = new char[length];
        for (int i = 0; i < length; i++) {
            characters[i] = (char) ascii[random.nextInt(93)]; // Randomly pick a character from ascii array
        }
        return characters;
    }

    // Main method to start the application
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create Scanner object to read input
        Encryption encryption = new Encryption(); // Create Encryption object
        System.out.println(encryption.test()); // Test encryption (example usage)
        Password_strength password_strength = new Password_strength();
        int whatDo = 0;
        int length = 0;
        whatGenerator(whatDo, length, scanner,password_strength); // Start the generator process
    }
}