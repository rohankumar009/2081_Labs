import java.util.Scanner;

public class Max {

    public static void main(String[] args) {
        // Create a Scanner object to take input from the user
        Scanner myScanner = new Scanner(System.in);

        // Prompt the user to enter a number
        System.out.println("Enter a number: ");

        // Read the user's input and store it in the variable 'num'
        int num = myScanner.nextInt();

        // Call the iterative method to find the largest digit and print the result
        System.out.println("The iterative Largest Digit is " + iterativMaxDigit(num));

        // Call the recursive method to find the largest digit and print the result
        System.out.println("The recursive Largest Digit is " + recursiveMaxDigit(num));

        // Close the Scanner object to prevent resource leaks
        myScanner.close();
    }

    // Method to find the largest digit iteratively
    public static int iterativMaxDigit(int num) {
        // Initialize 'store' with the last digit of the number (num % 10)
        int store = num % 10;

        // Loop through the digits of the number
        for (int i = num; i > 0; i = i / 10) {
            // Extract the last digit of the current value of 'i'
            int temp = i % 10;

            // Compare the extracted digit with the stored largest digit
            // If the current digit (temp) is greater than 'store', update 'store' with the current digit
            if (temp > store) {
                store = temp;
            }
        }

        // Return the largest digit found
        return store;
    }

    // Method to find the largest digit recursively
    public static int recursiveMaxDigit(int num) {
        // If the number is negative, convert it to positive and call the method recursively
        if (num < 0) {
            return recursiveMaxDigit(-1 * num);
        }
        // Base case: if the number is 0, return 0
        else if (num == 0) {
            return 0;
        }
        // Recursive case: find the maximum digit
        else {
            // Extract the last digit of the number
            int digit = num % 10;

            // Recursively call the method to process the remaining digits (num / 10)
            int maxDigit = recursiveMaxDigit(num / 10);

            // Compare the last digit with the maximum digit found in the remaining number
            if (digit > maxDigit) {
                maxDigit = digit; // Update maxDigit if the current digit is larger
            }

            // Return the largest digit found
            return maxDigit;
        }
    }
}

        /*
        int a, b, c;

        a = num / 100;
        b = num  % 100;
        c = num % 10;

        if (a > b) {
            if(a > c) {
                return (a);
            }

            else {
                return (c);
            }

        }
        else {
            if (b > c) {
                return (b);
            }

            else {
                return (c);
            }
        }
        */
