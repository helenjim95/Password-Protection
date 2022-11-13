package de.tum.in.ase;

/**
 * Class with a simplified password security algorithm,
 * which gives feedback to the user with the help of Exceptions.
 */
public class Password {
    private String password;
    private int length;

    //TODO: 2.1. Implement all attributes of Password and their getters.

    //TODO: 2.2 Implement the constructor according to the UML. Initialize all attributes.
    // All boolean attributes must have the initial value false. Initialize the length according to the password's length

    //TODO: Getters

    //TODO: 2.3 Check Password

    //TODO: 2.4 Strengthen Password

    //TODO: Create Strong Password


    /**
     * Helper Method for printing in strengthenPassword()
     */
    public String passwordHidden() {
        return password.charAt(0) + "\u2022".repeat(Math.max(0, this.length - 1));
    }


    public static void main(String[] args) {
        //TODO: Uncomment the following line once you're done with all the subtasks
        //createStrongPassword();
    }
}
