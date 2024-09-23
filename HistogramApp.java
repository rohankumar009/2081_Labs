import java.util.Scanner;

public class HistogramApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the lower and upper bounds for the histogram range
        System.out.println("Enter lower and upper bounds for your histogram (e.g., 0 5): ");
        int lowerBound = scanner.nextInt();
        int upperBound = scanner.nextInt();

        // Create an instance of the Histogram class with the specified range
        Histogram histogram = new Histogram(lowerBound, upperBound);

        // Display options to the user
        System.out.println("---Histogram Console---");
        System.out.println("Options:");
        System.out.println("add - used to add numbers to the histogram");
        System.out.println("print - prints the histogram to the screen");
        System.out.println("quit - leaves the program");

        // Enter a loop to continue interacting with the user until they choose to quit
        boolean running = true;
        while (running) {
            System.out.print("Choose an option: ");
            String option = scanner.next(); // Get user command

            switch (option.toLowerCase()) {
                case "add":
                    System.out.println("Enter number(s) to add to the histogram (separate by space): ");
                    String input = scanner.nextLine(); // Consume leftover newline character
                    input = scanner.nextLine(); // Get actual input line

                    // Split the input into individual numbers and attempt to add each one
                    String[] numbers = input.split(" ");
                    for (String numStr : numbers) {
                        try {
                            int number = Integer.parseInt(numStr);
                            if (!histogram.add(number)) {
                                System.out.println(number + " is not in the range.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println(numStr + " is not a valid number.");
                        }
                    }
                    break;

                case "print":
                    // Print the histogram
                    System.out.println(histogram);
                    break;

                case "quit":
                    // Exit the loop and terminate the program
                    running = false;
                    System.out.println("Bye!");
                    break;

                default:
                    // Handle unrecognized commands by reminding the user of available options
                    System.out.println("Invalid option. Available commands: add, print, quit.");
            }
        }

        // Close the scanner
        scanner.close();
    }
}
