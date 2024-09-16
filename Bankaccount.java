import java.util.Scanner;

public class BankAccount {
    // Fields to store account holder's name, password, and balance
    String name;
    String password;
    double balance;

    public static void main(String[] args) {
        // Create a new BankAccount object with initial values for name, password, and balance
        BankAccount myAccount = new BankAccount("Java", "CSCI2081 rules!", 100.50);

        // Prompt user to enter the password
        System.out.println("Enter password of the account: ");
        Scanner myScanner = new Scanner(System.in);
        String inputPassword = myScanner.nextLine();

        // Keep asking for the password until the user enters the correct one
        while (!inputPassword.equals(myAccount.password)) {
            System.out.println("Incorrect password. Please enter the correct password: ");
            inputPassword = myScanner.nextLine();
        }

        // Password is correct, proceed with deposit and withdrawal actions
        System.out.println("Password is correct. You can now perform transactions.");

        // Ask for deposit amount from the user
        System.out.println("Enter the deposit amount: ");
        double depositAmount = myScanner.nextDouble();
        // Call the deposit method to add the entered amount to the account balance
        myAccount.deposit(inputPassword, depositAmount);
        // Print the new balance after deposit
        System.out.println("My account balance after deposit is: " + myAccount.getBalance(inputPassword));

        // Ask for withdrawal amount from the user
        System.out.println("Enter the withdrawal amount: ");
        double withdrawalAmount = myScanner.nextDouble();
        // Call the withdraw method to subtract the entered amount from the account balance
        myAccount.withdraw(inputPassword, withdrawalAmount);
        // Print the new balance after withdrawal
        System.out.println("My account balance after withdrawal is: " + myAccount.getBalance(inputPassword));
    }

    // Constructor to initialize a new BankAccount object
    public BankAccount(String initName, String initPass, double initBalance) {
        this.name = initName;
        this.password = initPass;
        this.balance = initBalance;
    }

    // Method to withdraw an amount from the account if the password is correct and sufficient balance exists
    public void withdraw(String enteredPassword, double amount) {
        if (password.equals(enteredPassword) && balance >= amount) {
            balance = balance - amount; // Deduct the amount from balance
        } else {
            // Show error if the password is incorrect or there are insufficient funds
            System.out.println("Withdrawal failed. Incorrect password or insufficient funds.");
        }
    }

    // Method to deposit an amount to the account if the password is correct
    public void deposit(String enteredPassword, double amount) {
        if (password.equals(enteredPassword)) {
            balance = balance + amount; // Add the amount to balance
        }
    }

    // Method to get the current balance if the correct password is provided
    public double getBalance(String enteredPassword) {
        if (password.equals(enteredPassword)) {
            return balance; // Return the current balance
        } else {
            return -1; // Return -1 if the password is incorrect
        }
    }

    // Method to change the password if the correct old password is provided
    public boolean setPassword(String oldPassword, String newPassword) {
        if (password.equals(oldPassword)) {
            password = newPassword; // Update the password
            return true; // Return true if password was successfully changed
        } else {
            return false; // Return false if the old password is incorrect
        }
    }

    // Unnecessary method (this seems like a mistake, it's not used and doesn't update password correctly)
    public boolean getPassword(String otherPassword, String newPassword) {
        if (password.equals(otherPassword)) {
            otherPassword = newPassword; // This doesn't actually change anything, as it's a local variable
            return true;
        } else {
            return false;
        }
    }
}
