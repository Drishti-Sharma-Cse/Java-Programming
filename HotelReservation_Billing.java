import java.util.ArrayList;
import java.util.Scanner;

// Class representing an individual Hotel Room
class Room {
    private int roomNumber;
    private String roomType; // e.g., Standard, Deluxe, Suite
    private double pricePerNight;
    private boolean isOccupied;
    private String guestName;
    private int bookedNights;

    public Room(int roomNumber, String roomType, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.isOccupied = false;
        this.guestName = "";
        this.bookedNights = 0;
    }

    // Getters and Setters
    public int getRoomNumber() { return roomNumber; }
    public String getRoomType() { return roomType; }
    public double getPricePerNight() { return pricePerNight; }
    public boolean isOccupied() { return isOccupied; }
    public String getGuestName() { return guestName; }
    public int getBookedNights() { return bookedNights; }

    public void checkIn(String guestName, int nights) {
        this.guestName = guestName;
        this.bookedNights = nights;
        this.isOccupied = true;
    }

    public void checkOut() {
        this.guestName = "";
        this.bookedNights = 0;
        this.isOccupied = false;
    }

    public void displayStatus() {
        String status = isOccupied ? "Occupied (Guest: " + guestName + ")" : "Available";
        System.out.printf("Room: %-5d | Type: %-12s | Price/Night: $%-7.2f | Status: %s%n", 
                roomNumber, roomType, pricePerNight, status);
    }
}

// Main Management Class
public class HotelReservation_Billing {
    private static ArrayList<Room> rooms = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Initialize hotel rooms
        rooms.add(new Room(101, "Standard", 80.00));
        rooms.add(new Room(102, "Standard", 80.00));
        rooms.add(new Room(201, "Deluxe", 150.00));
        rooms.add(new Room(202, "Deluxe", 150.00));
        rooms.add(new Room(301, "Suite", 300.00));

        int choice;
        do {
            System.out.println("\n===== HOTEL RESERVATION & BILLING SYSTEM =====");
            System.out.println("1. View Room Status & Rates");
            System.out.println("2. Book/Check-In Room");
            System.out.println("3. Check-Out & Generate Bill");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Please enter a valid menu number: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1 -> viewRooms();
                case 2 -> checkInGuest();
                case 3 -> checkOutGuest();
                case 4 -> System.out.println("Thank you for using the Hotel Management System!");
                default -> System.out.println("Invalid option. Please choose 1-4.");
            }
        } while (choice != 4);
    }

    private static void viewRooms() {
        System.out.println("\n--- Hotel Room Directory ---");
        for (Room room : rooms) {
            room.displayStatus();
        }
    }

    private static void checkInGuest() {
        System.out.print("Enter Room Number to book: ");
        int roomNum = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        Room room = findRoom(roomNum);
        if (room == null) {
            System.out.println("Error: Room number does not exist.");
            return;
        }

        if (room.isOccupied()) {
            System.out.println("Error: This room is already occupied.");
            return;
        }

        System.out.print("Enter Guest Full Name: ");
        String name = scanner.nextLine().trim();
        
        System.out.print("Enter Number of Nights: ");
        int nights = scanner.nextInt();

        room.checkIn(name, nights);
        System.out.println("Success: Room " + roomNum + " successfully booked for " + name + "!");
    }

    private static void checkOutGuest() {
        System.out.print("Enter Room Number for checkout: ");
        int roomNum = scanner.nextInt();

        Room room = findRoom(roomNum);
        if (room == null) {
            System.out.println("Error: Room number does not exist.");
            return;
        }

        if (!room.isOccupied()) {
            System.out.println("Error: This room is currently vacant.");
            return;
        }

        // Calculate billing figures
        double baseCost = room.getPricePerNight() * room.getBookedNights();
        double tax = baseCost * 0.12; // 12% hotel tax
        double totalBill = baseCost + tax;

        // Print Invoice Statement
        System.out.println("\n==========================================");
        System.out.println("             FINAL HOTEL BILL             ");
        System.out.println("==========================================");
        System.out.println("Guest Name:     " + room.getGuestName());
        System.out.println("Room Number:    " + room.getRoomNumber() + " (" + room.getRoomType() + ")");
        System.out.println("Nights Stayed:  " + room.getBookedNights());
        System.out.printf("Room Rate:      $%.2f / night%n", room.getPricePerNight());
        System.out.println("------------------------------------------");
        System.out.printf("Base Subtotal:  $%.2f%n", baseCost);
        System.out.printf("Tax (12%%):      $%.2f%n", tax);
        System.out.printf("TOTAL DUE:      $%.2f%n", totalBill);
        System.out.println("==========================================");

        room.checkOut();
        System.out.println("Checkout complete! Room " + roomNum + " is now clean and available.");
    }

    private static Room findRoom(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }
}
