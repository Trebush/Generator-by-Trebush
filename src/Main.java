import encryption.Encryption;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static int[] ascii = {33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125,};

    static void start() {
        System.out.println("\tGenerator by Trebush");
        System.out.println("1 \t - \t passowrd generator");
        System.out.println("2 \t - \t login generator");
        System.out.println("3 \t - \t login and password generator");
        System.out.println("0 \t - \t exit");
    }

    static void whatGenerator(int whatDo, int lenght, Scanner scanner) {
        do {
            start();
            whatDo = scanner.nextInt();
            switch (whatDo) {
                case 0:
                    System.out.println("Thanks for using ~ Trebush");
                    break;
                case 1:
                    System.out.println("How lenght u need in password?");
                    lenght = scanner.nextInt();
                    System.out.print("Your password is ");
                    System.out.println(generator(lenght));
                    break;
                case 2:
                    System.out.println("How lenght u need in login?");
                    lenght = scanner.nextInt();
                    System.out.print("Your login is ");
                    System.out.println(generator(lenght));
                    break;
                case 3:
                    System.out.println("How lenght u need in login?");
                    lenght = scanner.nextInt();
                    System.out.print("Your login is ");
                    System.out.println(generator(lenght));
                    System.out.println("How lenght u need in password?");
                    lenght = scanner.nextInt();
                    System.out.print("Your password is ");
                    System.out.println(generator(lenght));
                    break;
                default:
                    System.out.println("Wrong number");
                    break;
            }
        } while (whatDo != 0);
    }

    static char[] generator(int length) {
        Random random = new Random();
        char[] characters = new char[length];
        for (int i = 0; i < length; i++) {
            characters[i] = (char) ascii[random.nextInt(93)];
        }
        return characters;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Encryption encryption = new Encryption();
        System.out.println(encryption.test());
        int whatDo = 0;
        int lenght = 0;
        whatGenerator(whatDo, lenght, scanner);
    }
}