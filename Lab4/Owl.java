public class Owl {
    // Private member variables for each Owl's name, age, and weight
    private String name; // The name of the owl
    private int age; // The age of the owl
    private double weight; // The weight of the owl in pounds
    
    // Constructor to initialize the Owl's attributes (name, age, weight)
    public Owl(String name, int age, double weight) {
        this.name = name; // Set the owl's name
        this.age = age; // Set the owl's age
        this.weight = weight; // Set the owl's weight
    }
    
    // Getter method for the name attribute
    public String getName() {
        return name; // Return the owl's name
    }
    
    // Setter method for the name attribute
    public void setName(String name) {
        this.name = name; // Set the owl's name
    }
    
    // Getter method for the age attribute
    public int getAge() {
        return age; // Return the owl's age
    }
    
    // Setter method for the age attribute
    public void setAge(int age) {
        this.age = age; // Set the owl's age
    }
    
    // Getter method for the weight attribute
    public double getWeight() {
        return weight; // Return the owl's weight
    }
    
    // Setter method for the weight attribute
    public void setWeight(double weight) {
        this.weight = weight; // Set the owl's weight
    }
    
    // Equals method to compare two Owl objects based on their name, age, and weight
    public boolean equals(Owl other) {
        // Return true if the names are the same, and both age and weight match
        return name.equals(other.name) && this.age == other.age && this.weight == other.weight;
    }
    
    // Main method for testing the Owl class
    public static void main(String[] args) {
        // Create three Owl objects
        Owl owl1 = new Owl("owl1", 5, 12); // Owl with name "owl1", age 5, weight 12 lbs
        Owl owl2 = new Owl("owl2", 5, 12); // Owl with name "owl2", age 5, weight 12 lbs
        Owl owl3 = new Owl("owl1", 5, 12.0); // Owl with name "owl1", age 5, weight 12.0 lbs
        
        // Compare owl1 and owl2 using the equals method and print the result
        System.out.println(owl1.equals(owl2)); // False because the names are different
        
        // Compare owl1 and owl3 using the equals method and print the result
        System.out.println(owl1.equals(owl3)); // True because all attributes match
    }
}
