package password_strength;

import java.io.*;
import java.util.*;

public class Password_strength {

    // Checking lower alphabet in string
    public static String printStrongNess(String password) {
        // Checking lower alphabet in string
        int n = password.length();
        boolean hasLower = false, hasUpper = false,
                hasDigit = false, specialChar = false;
        Set<Character> set = new HashSet<Character>(
                Arrays.asList('!', '@', '#', '$', '%', '^', '&',
                        '*', '(', ')', '-', '+'));
        for (char i : password.toCharArray()) {
            if (Character.isLowerCase(i))
                hasLower = true;
            if (Character.isUpperCase(i))
                hasUpper = true;
            if (Character.isDigit(i))
                hasDigit = true;
            if (set.contains(i))
                specialChar = true;
        }

        // Strength of password
        System.out.print("Strength of password: ");
        if (hasDigit && hasLower && hasUpper && specialChar && (n >= 8)) {
            return "Strong";
        } else if ((hasLower || hasUpper || specialChar) && (n >= 6)) {
            return "Moderate";
        } else {
            return "Weak";
        }
    }
}