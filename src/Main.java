import password_strength.Password_strength;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Random;

public class Main {
    static int[] ascii = {33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125};
    private static password_strength.Password_strength Password_strength;

    public static void main(String[] args) {
        int test;
        SwingUtilities.invokeLater(Main::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Generator by Trebush");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));

        JButton passwordButton = new JButton("Password Generator");
        JButton loginButton = new JButton("Login Generator");
        JButton loginPasswordButton = new JButton("Login and Password Generator");
        JButton checkStrengthButton = new JButton("Check Password Strength");
        JButton showLoginOrPassword = new JButton("Show Login or Password");
        JButton exitButton = new JButton("Exit");

        panel.add(passwordButton);
        panel.add(loginButton);
        panel.add(loginPasswordButton);
        panel.add(checkStrengthButton);
        panel.add(showLoginOrPassword);
        panel.add(exitButton);

        frame.getContentPane().add(panel);

        passwordButton.addActionListener(e -> generatePassword(frame));
        loginButton.addActionListener(e -> generateLogin(frame));
        loginPasswordButton.addActionListener(e -> generateLoginAndPassword(frame));
        checkStrengthButton.addActionListener(e -> checkPasswordStrength(frame));
        showLoginOrPassword.addActionListener(e -> showLoginOrPassword(frame));
        exitButton.addActionListener(e -> System.exit(0));

        frame.setVisible(true);
    }

    private static void generatePassword(JFrame frame) {
        String website = JOptionPane.showInputDialog(frame, "Enter website: ");
        String lengthStr = JOptionPane.showInputDialog(frame, "Enter password length:");
        int length = Integer.parseInt(lengthStr);
        String password = new String(generator(length));
        int save = JOptionPane.showConfirmDialog(frame, "Do you want to save the password?");
        if (save == JOptionPane.YES_OPTION) {
            saveToFile(frame, "\n\nWebsite: " + website + "\nGenerated Password: " + password);
        }
        JOptionPane.showMessageDialog(frame, "Generated Password: " + password);
    }

    private static void generateLogin(JFrame frame) {
        String lengthStr = JOptionPane.showInputDialog(frame, "Enter login length:");
        int length = Integer.parseInt(lengthStr);
        String login = new String(generator(length));
        JOptionPane.showMessageDialog(frame, "Generated Login: " + login);
    }

    private static void generateLoginAndPassword(JFrame frame) {
        String website = JOptionPane.showInputDialog(frame, "Enter website: ");
        String loginLengthStr = JOptionPane.showInputDialog(frame, "Enter login length:");
        int loginLength = Integer.parseInt(loginLengthStr);
        String login = new String(generator(loginLength));
        String passwordLengthStr = JOptionPane.showInputDialog(frame, "Enter password length:");
        int passwordLength = Integer.parseInt(passwordLengthStr);
        String password = new String(generator(passwordLength));
        int save = JOptionPane.showConfirmDialog(frame, "Do you want to save the login and password?");
        if (save == JOptionPane.YES_OPTION) {
            saveToFile(frame, "\n\nWebsite: " + website + "\nLogin: " + login + "\nPassword: " + password);
        }
        JOptionPane.showMessageDialog(frame, "Website: " + website + "\nGenerated Login: " + login + "\nGenerated Password: " + password);
    }

    private static void checkPasswordStrength(JFrame frame) {
        String password = JOptionPane.showInputDialog(frame, "Enter password to check strength:");
        // Assuming Password_strength class exists and has a printStrongNess method
        String strength = Password_strength.printStrongNess(password);
        JOptionPane.showMessageDialog(frame, "Password Strength: " + strength);
    }

    private static void showLoginOrPassword(JFrame frame) {
        String filePath = "file.txt";
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Error reading from file: " + e.getMessage());
        }

        if (content.length() == 0) {
            content.append("File is empty or not found");
        }

        JTextArea textArea = new JTextArea(content.toString());
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(400, 300));

        JOptionPane.showMessageDialog(frame, scrollPane, "Your login and password", JOptionPane.INFORMATION_MESSAGE);
    }

    private static char[] generator ( int length){
            Random random = new Random();
            char[] characters = new char[length];
            for (int i = 0; i < length; i++) {
                characters[i] = (char) ascii[random.nextInt(ascii.length)];
            }
            return characters;
        }

        private static void saveToFile (JFrame frame, String content){
            try (FileWriter fileWriter = new FileWriter("file.txt", true);
                 PrintWriter printWriter = new PrintWriter(fileWriter)) {
                printWriter.println(content);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(frame, "Error saving to file: " + e.getMessage());
            }
        }
    }