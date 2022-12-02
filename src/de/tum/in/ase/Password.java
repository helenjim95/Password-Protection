package de.tum.in.ase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


/**
 * Class with a simplified password security algorithm,
 * which gives feedback to the user with the help of Exceptions.
 */
public class Password {
    private String password;
    private int length;

    private boolean isStrong;
    private boolean upperCase;
    private boolean lowerCase;
    private boolean special;
    //2.2 Implement the constructor according to the UML. Initialize all attributes.
    // All boolean attributes must have the initial value false. Initialize the length according to the password's length

    public Password(String password) {
        this.password = password;
        this.length = password.length();
        this.isStrong = false;
        this.upperCase = false;
        this.lowerCase = false;
        this.special = false;
    }

    //Getters
    public String getPassword() {
        return password;
    }

    public int getLength() {
        return length;
    }

    public boolean isStrong() {
        return isStrong;
    }

    public boolean isUpperCase() {
        return upperCase;
    }

    public boolean isLowerCase() {
        return lowerCase;
    }

    public boolean isSpecial() {
        return special;
    }

    //2.3 Check Password
    public boolean checkStrength() {
        List<String> characters = List.of(password.split(""));
        List<Character> specialCharacters = new ArrayList<>(
                Arrays.asList('+', '~', '?', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '_', '-'));
        if (password.matches("(?=.*[A-Z]).*")) {
            this.upperCase = true;
        }
        if (password.matches("(?=.*[a-z]).*")) {
            this.lowerCase = true;
        }
        if (password.matches("(?=.*[+~?!@#$%^&*()_-]).*")) {
            this.special = true;
        }
        isStrong = lowerCase && upperCase && special;
        return isStrong;
    }

    //2.4 Strengthen Password
    public void strengthenPassword() throws UpperCaseNotFoundException, LowerCaseNotFoundException, SpecialCharNotFoundException {
        if (checkStrength()) {
            System.out.println("Your Password: " + passwordHidden() + " is strong enough.");
        } else {
            if (!this.upperCase) {
                throw new UpperCaseNotFoundException();
            }
            if (!this.lowerCase) {
                throw new LowerCaseNotFoundException();
            }
            if (!this.special) {
                throw new SpecialCharNotFoundException();
            }
        }
    }

    //Create Strong Password
    public static Password createStrongPassword() {
        System.out.println( "Create a strong password, which contains at least:\n One uppercase letter,\n One lowercase letter and\n One of the following special characters: ~ ? ! @ # $");
        System.out.println("Password:");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        Password password = new Password(userInput);
        try {
            password.strengthenPassword();
        } catch (LowerCaseNotFoundException le) {
            System.out.println(le);
        } catch (SpecialCharNotFoundException se) {
            System.out.println(password.special);
            System.out.println(se);
        } catch (UpperCaseNotFoundException ue) {
            System.out.println(ue);
        } finally {
            if (password.checkStrength()) {
                System.out.println("Great job!");
            } else {
                System.out.println("Keep on trying.");
            }
            return password;
        }
    }


    /**
     * Helper Method for printing in strengthenPassword()
     */
    public String passwordHidden() {
        return password.charAt(0) + "\u2022".repeat(Math.max(0, this.length - 1));
    }


    public static void main(String[] args) {
        createStrongPassword();
    }
}
