import java.util.Scanner;

public class Fib {

    // recursino
    public static int fibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static void main(String[] args) { // make a scanner so you can get the inputs
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the position of Fibonacci number to calculate: ");
        int n = scanner.nextInt(); // Getting user input (int cuz ur looking for a integer value)

        // Call the recursive Fibonacci method
        int result = fibonacciRecursive(n);

        System.out.println("Fibonacci number at position " + n + " is: " + result);

        scanner.close();
    }
}
