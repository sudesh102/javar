import java.util.*;

public class CollectionGenericsDemo {

    // Method to demonstrate List with Generics
    private static void demonstrateList() {
        System.out.println("=== List Demonstration ===");
        List<String> fruits = new ArrayList<>(); // Using Generics with ArrayList
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");

        System.out.println("Fruits List: " + fruits);
        fruits.remove("Banana");
        System.out.println("After removing 'Banana': " + fruits);

        // Iterate over the list
        System.out.println("Iterating over the list:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }

    // Method to demonstrate Set with Generics
    private static void demonstrateSet() {
        System.out.println("\n=== Set Demonstration ===");
        Set<Integer> uniqueNumbers = new HashSet<>(); // Using Generics with HashSet
        uniqueNumbers.add(10);
        uniqueNumbers.add(20);
        uniqueNumbers.add(30);
        uniqueNumbers.add(10); // Duplicate entry, won't be added

        System.out.println("Unique Numbers: " + uniqueNumbers);

        // Iterate over the set
        System.out.println("Iterating over the set:");
        for (Integer number : uniqueNumbers) {
            System.out.println(number);
        }
    }

    // Method to demonstrate Map with Generics
    private static void demonstrateMap() {
        System.out.println("\n=== Map Demonstration ===");
        Map<Integer, String> employeeMap = new HashMap<>(); // Using Generics with HashMap
        employeeMap.put(101, "Alice");
        employeeMap.put(102, "Bob");
        employeeMap.put(103, "Charlie");

        System.out.println("Employee Map: " + employeeMap);
        System.out.println("Employee with ID 102: " + employeeMap.get(102));

        // Iterate over the map
        System.out.println("Iterating over the map:");
        for (Map.Entry<Integer, String> entry : employeeMap.entrySet()) {
            System.out.println("ID: " + entry.getKey() + ", Name: " + entry.getValue());
        }
    }

    // Method to demonstrate Generics with a custom class
    private static void demonstrateCustomGenericClass() {
        System.out.println("\n=== Custom Generic Class Demonstration ===");
        Box<Integer> integerBox = new Box<>(123);
        Box<String> stringBox = new Box<>("Hello");

        System.out.println("Integer Box: " + integerBox.get());
        System.out.println("String Box: " + stringBox.get());
    }

    // Custom Generic Class
    static class Box<T> {
        private T value;

        public Box(T value) {
            this.value = value;
        }

        public T get() {
            return value;
        }

        public void set(T value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        demonstrateList();
        demonstrateSet();
        demonstrateMap();
        demonstrateCustomGenericClass();
    }
}
