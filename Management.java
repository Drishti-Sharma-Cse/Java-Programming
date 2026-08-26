import java.util.Scanner;

// Class representing an individual Item in the inventory
class Item {
    private int id;
    private String name;
    private int quantity;
    private double price;

    // Constructor to initialize an item
    public Item(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }

    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setPrice(double price) { this.price = price; }

    // Display item details
    public void displayItem() {
        System.out.printf("ID: %-5d | Name: %-15s | Qty: %-5d | Price: $%.2f%n", id, name, quantity, price);
    }
}

// Main class to manage operations
public class Management {
    private static Item[] inventory = new Item[100]; // Array capacity of 100 items
    private static int itemCount = 0; // Tracks active number of items
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        // Redirecting standard system input stream
        scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== INVENTORY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. Update Product Stock");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");
            
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Please enter a number: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    viewProducts();
                    break;
                case 3:
                    updateStock();
                    break;
                case 4:
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 4);
    }

    // 1. Add Product Method
    private static void addProduct() {
        if (itemCount >= inventory.length) {
            System.out.println("Error: Inventory storage is completely full!");
            return;
        }

        System.out.print("Enter Product ID (Integer): ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        // Check if ID already exists
        for (int i = 0; i < itemCount; i++) {
            if (inventory[i].getId() == id) {
                System.out.println("Error: A product with this ID already exists.");
                return;
            }
        }

        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Quantity: ");
        int qty = scanner.nextInt();

        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();

        inventory[itemCount] = new Item(id, name, qty, price);
        itemCount++;
        System.out.println("Product added successfully!");
    }

    // 2. View All Products Method
    private static void viewProducts() {
        if (itemCount == 0) {
            System.out.println("No items found in the inventory.");
            return;
        }
        System.out.println("\n--- Current Inventory Status ---");
        for (int i = 0; i < itemCount; i++) {
            inventory[i].displayItem();
        }
    }

    // 3. Update Product Stock Method
    private static void updateStock() {
        if (itemCount == 0) {
            System.out.println("Inventory empty. No products to update.");
            return;
        }

        System.out.print("Enter Product ID to update: ");
        int id = scanner.nextInt();

        for (int i = 0; i < itemCount; i++) {
            if (inventory[i].getId() == id) {
                System.out.print("Enter new quantity for " + inventory[i].getName() + ": ");
                int newQty = scanner.nextInt();
                inventory[i].setQuantity(newQty);
                System.out.println("Stock updated successfully!");
                return;
            }
        }
        System.out.println("Error: Product ID not found.");
    }
}
