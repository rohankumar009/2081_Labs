public class Histogram {
    private int lowerBound;
    private int upperBound;
    private int[] frequencies;

    // Constructor to initialize the histogram with a given range
    public Histogram(int lowerBound, int upperBound) {
        // If the bounds are provided in reverse order, swap them
        if (upperBound < lowerBound) {
            int temp = upperBound;
            upperBound = lowerBound;
            lowerBound = temp;
        }

        this.lowerBound = lowerBound;
        this.upperBound = upperBound;

        // Initialize an array to hold frequencies, one slot for each possible value
        frequencies = new int[upperBound - lowerBound + 1];
    }

    // Method to add a number to the histogram, if it is within the bounds
    public boolean add(int number) {
        if (number >= lowerBound && number <= upperBound) {
            frequencies[number - lowerBound]++; // Increment the frequency for the given number
            return true; // Successfully added
        }
        return false; // Number is out of bounds
    }

    // Override the toString method to return the histogram as a formatted string
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < frequencies.length; i++) {
            result.append(lowerBound + i).append(": ");
            for (int j = 0; j < frequencies[i]; j++) {
                result.append("*"); // Add a star for each occurrence
            }
            result.append("\n");
        }
        return result.toString();
    }
}
