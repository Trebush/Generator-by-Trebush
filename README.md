# Password and Login Generator

## Overview

This Java program provides a graphical user interface (GUI) for generating passwords, logins, and combinations of both. It also allows users to check the strength of passwords and view saved login-password pairs. The program uses Swing for the GUI and has functionalities for saving generated credentials to a file.

## Features

1. **Password Generator**: Generate a random password of specified length.
2. **Login Generator**: Generate a random login of specified length.
3. **Login and Password Generator**: Generate a random login and password for a given website and save them if desired.
4. **Check Password Strength**: Evaluate and display the strength of a given password.
5. **Show Login or Password**: Display saved logins and passwords from a file.
6. **Exit**: Close the application.

## Usage

### Running the Application

To run the application, execute the `Main` class. The main method initializes and displays the GUI.

### GUI Components

- **Password Generator**: Prompts for the desired password length and optionally a website. Generates and displays the password, with an option to save it.
- **Login Generator**: Prompts for the desired login length. Generates and displays the login.
- **Login and Password Generator**: Prompts for the website, login length, and password length. Generates and displays both, with an option to save them.
- **Check Password Strength**: Prompts for a password and displays its strength using the `password_strength.Password_strength` class.
- **Show Login or Password**: Reads and displays saved logins and passwords from `file.txt`.
- **Exit**: Closes the application.

### Generating Passwords and Logins

The `generator` method creates a random string of specified length using a predefined set of ASCII characters.

### Saving to File

Generated logins and passwords can be saved to `file.txt`. The `saveToFile` method appends the content to this file.

## Code Structure

- **Main Class**: Contains the main method and GUI setup.
- **createAndShowGUI Method**: Sets up the main window and adds buttons for various functionalities.
- **ActionListener Methods**: Define actions for each button.
- **generator Method**: Generates a random string.
- **saveToFile Method**: Saves content to a file.
- **Password Strength Check**: Uses the `password_strength.Password_strength` class to evaluate password strength.

## Dependencies

- `javax.swing.*`: For GUI components.
- `java.awt.*`: For layout management.
- `java.awt.event.*`: For event handling.
- `java.io.*`: For file operations.
- `java.util.Random`: For generating random strings.
- `password_strength.Password_strength`: For checking password strength.

## Setup

1. Ensure you have Java installed on your machine.
2. Compile the program using `javac Main.java`.
3. Run the program using `java Main`.

## License

This project is licensed under the MIT License. See the `LICENSE` file for details.

## Author

Trebush

## Contact

For any queries or issues, please contact Trebush at Github
