import java.io.File; // Importing the File class to handle file operations
import java.io.FileNotFoundException; // Importing the exception class for handling file not found errors
import java.util.Scanner; // Importing the Scanner class for reading input from the file

public class OwlPopulation {
    // Private member variables
    private String fileName; // Stores the name of the CSV file
    private Owl[] data; // Array of Owl objects that holds the population data
    
    // Method to populate the Owl array by reading data from a file
    public void populateData() throws FileNotFoundException {
        File f = new File(fileName); // Creates a File object with the given filename
        Scanner scanner = new Scanner(f); // Creates a Scanner to read the file
        
        int numLines = 0; // Variable to store the number of lines in the file (number of owls)
        
        // Loop through the file to count how many lines (owls) there are
        while(scanner.hasNextLine()) { 
            numLines++; // Increment line count for each line
            String s = scanner.nextLine(); // Read the next line (though it's not used here)
        }
        scanner.close(); // Close the scanner after counting lines
        
        data = new Owl[numLines]; // Initialize the Owl array to the size of numLines (number of owls)
        scanner = new Scanner(f); // Reinitialize the Scanner to read the file again for actual data
        
        // Loop to populate the Owl array
        for (int i = 0; i < numLines; i++) {
            String[] stringArray = scanner.nextLine().split(","); // Split each line by commas into an array
            // Create a new Owl object with the name, age, and weight parsed from the file, and store it in the array
            data[i] = new Owl(stringArray[0], Integer.parseInt(stringArray[1]), Double.parseDouble(stringArray[2]));
        }
    }
    
    // Constructor for the OwlPopulation class, takes a filename and calls populateData()
    public OwlPopulation(String fileName) throws FileNotFoundException {
        this.fileName = fileName; // Set the fileName variable
        populateData(); // Populate the data array by reading the file
    }
    
    // Method to calculate and return the average age of all the owls
    public double averageAge() {
        double sumOfAges = 0; // Variable to store the sum of all ages
        // Loop through the data array and add each owl's age to the sum
        for (int i = 0; i < data.length; i++) {
            sumOfAges += data[i].getAge(); // Add the age of the current owl
        }
        return sumOfAges / data.length; // Return the average age by dividing the sum by the number of owls
    }
    
    // Method to return the youngest owl in the population
    public Owl getYoungest() {
        int indexOfYoungest = 0; // Start by assuming the first owl is the youngest
        
        // Loop through the data array to find the youngest owl
        for (int i = 0; i < data.length; i++) {
            // If the current owl's age is less than the age of the current youngest owl
            if (data[i].getAge() < data[indexOfYoungest].getAge()) {
                indexOfYoungest = i; // Update the index of the youngest owl
            }
        }
        return data[indexOfYoungest]; // Return the youngest owl
    }
    
    // Method to return the heaviest owl in the population
    public Owl getHeaviest() {
        double heaviest = 0; // Variable to store the weight of the heaviest owl
        int indexOfHeaviest = 0; // Start by assuming the first owl is the heaviest
        
        // Loop through the data array to find the heaviest owl
        for (int i = 0; i < data.length; i++) {
            // If the current owl's weight is greater than the weight of the current heaviest owl
            if (data[i].getWeight() > data[indexOfHeaviest].getWeight()) {
                indexOfHeaviest = i; // Update the index of the heaviest owl
            }
        }
        return data[indexOfHeaviest]; // Return the heaviest owl
    }
    
    // Method to return a summary of the owl population
    public String toString() {
        String output = ""; // String to store the final output message
        
        Owl young = this.getYoungest(); // Get the youngest owl
        Owl heaviest = this.getHeaviest(); // Get the heaviest owl
        
        // Add the details of the youngest owl to the output string
        output += "The youngest owl is " + young.getName() + ", which is " + young.getAge() + " years old.\n";
        // Add the details of the heaviest owl to the output string
        output += "The heaviest owl is " + heaviest.getName() + " , which weighs " + heaviest.getWeight() + " pounds.\n";
        // Add the average age of the population to the output string
        output += "The average age of the population is " + averageAge() + ".\n";
        
        return output; // Return the output string
    }
    
    // Method to check if a given owl exists in the population
    public boolean containsOwl(Owl other) {
        int containsCheck = 0; // Counter to track if the owl exists in the data
        if (other instanceof Owl) { // Check if the object passed is an instance of Owl
            Owl otherOwl = (Owl) other; // Cast the object to an Owl
            // Loop through the owl population
            for (int i = 0; i < data.length; i++) {
                // If an owl in the population matches the given owl (by name, age, and weight)
                if (data[i].getWeight() == otherOwl.getWeight() && data[i].getName().equals(otherOwl.getName()) && data[i].getAge() == otherOwl.getAge()) {
                    containsCheck++; // Increment the counter if a match is found
                }
            }
            if (containsCheck != 0) { // If a match was found
                return true; // Return true
            }
        }
        return false; // Return false if no match was found
    }
    
    // Method to merge another OwlPopulation with the current one, without adding duplicates
    public void merge(OwlPopulation other) {
        // Temporary array to store the distinct owls after merging
        Owl[] tempDistinctOwls = new Owl[data.length + other.popSize()];
        int distinctOwlCount = 0; // Counter for the number of distinct owls
        int duplicateCount = 0; // Counter for duplicate owls
        
        // Add all owls from the current population to the temporary array
        for (int i = 0; i < data.length; i++) {
            tempDistinctOwls[distinctOwlCount] = data[i]; // Add owl to temp array
            distinctOwlCount++; // Increment the distinct owl counter
        }
        
        // Loop through the other population and add non-duplicate owls to the temp array
        for (int a = 0; a < other.popSize(); a++) {
            for (int i = 0; i < data.length; i++) {
                // Check if the current owl from the other population already exists in this population
                if (data[i].getWeight() == other.data[a].getWeight() && data[i].getName().equals(other.data[a].getName()) && data[i].getAge() == other.data[a].getAge()) {
                    duplicateCount++; // Increment duplicate counter if owl is already present
                }
            }
            if (duplicateCount == 0) { // If no duplicates are found
                tempDistinctOwls[distinctOwlCount] = other.data[a]; // Add owl from other population
                distinctOwlCount++; // Increment distinct owl counter
            }
            duplicateCount = 0; // Reset the duplicate counter for the next iteration
        }
        
        // Create a new array with the correct number of distinct owls
        Owl[] distinctOwls = new Owl[distinctOwlCount];
        for (int k = 0; k < distinctOwlCount; k++) {
            distinctOwls[k] = tempDistinctOwls[k]; // Copy the distinct owls to the final array
        }
        this.data = distinctOwls; // Set the new distinct owls as the population's data
    }
    
    // Method to return the size of the owl population
    public int popSize() {
        return data.length; // Return the length of the data array (number of owls)
    }
    
    // Main method for testing
    public static void main(String[] args) {
        try {
            // Create and print details for two OwlPopulations
            OwlPopulation pop1 = new OwlPopulation("owlPopulation1.csv");
            System.out.println();
            System.out.println("Population one size: " + pop1.popSize());
            System.out.println(pop1.toString());
            
            OwlPopulation pop2 = new OwlPopulation("owlPopulation2.csv");
            System.out.println("Population two size: " + pop2.popSize());
            System.out.println(pop2.toString());
            
            // Merge the two populations and print the result
            pop1.merge(pop2);
            System.out.println("Merged population size: " + pop1.popSize());
            System.out.println(pop1.toString());
            
        } catch (FileNotFoundException f) {
            System.out.println("File not found."); // Print an error if the file is not found
        }
    }
}
