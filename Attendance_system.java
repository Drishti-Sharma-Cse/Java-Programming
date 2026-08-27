import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Attendance_system {
    // Key: Student Name, Value: Attendance Status (Present / Absent)
    private static final HashMap<String, String> attendanceRecords = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

      public static void main(String[] args) {
        int choice = 0;

        do {
            // Display operations menu
            System.out.println("\n--- ATTENDANCE MANAGEMENT SYSTEM ---");
            System.out.println("1. Register New Student");
            System.out.println("2. Mark / Update Attendance");
            System.out.println("3. View Attendance Report");
            System.out.println("4. Exit Application");
            System.out.print("Enter choice (1-4): ");
            
            // Read input as a safe String first to avoid scanner crashes
            String input = scanner.nextLine().trim();

            // Try to convert the string to a safe number
            try {
                // This removes any accidental single/double quotes typed by mistake
                input = input.replace("'", "").replace("\"", "");
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Error: Please type a valid number only. No text or quotes allowed.");
                choice = 0; // Reset choice to trigger the default switch case safely
                continue;   // Skip the switch and jump directly to the next loop iteration
            }

            switch (choice) {
                case 1:
                    registerStudent();
                    break;
                case 2:
                    markAttendance();
                    break;
                case 3:
                    viewReport();
                    break;
                case 4:
                    System.out.println("Exiting application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid selection. Please choose numbers 1 to 4.");
            }
        } while (choice != 4);
    }

    // Method 1: Pre-populate or register students into the system
    private static void registerStudent() {
        System.out.print("Enter student's full name to register: ");
        String name = scanner.nextLine().trim();
        
        if (name.isEmpty()) {
            System.out.println("Error: Name cannot be empty.");
            return;
        }

        if (attendanceRecords.containsKey(name)) {
            System.out.println("Error: " + name + " is already registered.");
        } else {
            attendanceRecords.put(name, "Not Marked"); // Default initialization status
            System.out.println("Success: " + name + " registered successfully.");
        }
    }

    // Method 2: Change status to Present or Absent
    private static void markAttendance() {
        if (attendanceRecords.isEmpty()) {
            System.out.println("No students registered yet. Register students first.");
            return;
        }

        System.out.print("Enter registered student name: ");
        String name = scanner.nextLine().trim();

        if (!attendanceRecords.containsKey(name)) {
            System.out.println("Error: Student '" + name + "' not found in registry.");
            return;
        }

        System.out.print("Enter status (P for Present / A for Absent): ");
        String statusInput = scanner.nextLine().trim().toUpperCase();

        if (statusInput.equals("P")) {
            attendanceRecords.put(name, "Present");
            System.out.println("Status updated: " + name + " marked Present.");
        } else if (statusInput.equals("A")) {
            attendanceRecords.put(name, "Absent");
            System.out.println("Status updated: " + name + " marked Absent.");
        } else {
            System.out.println("Error: Invalid input. Use 'P' or 'A' only.");
        }
    }

    // Method 3: Iterate through records and print a clean breakdown summary
    private static void viewReport() {
        if (attendanceRecords.isEmpty()) {
            System.out.println("No attendance logs available. System is empty.");
            return;
        }

        int presentCount = 0;
        int absentCount = 0;
        int unmarkedCount = 0;

        System.out.println("\n===== DAILY ATTENDANCE REPORT =====");
        System.out.printf("%-25s | %-12s\n", "Student Name", "Status");
        System.out.println("----------------------------------------");

        for (Map.Entry<String, String> entry : attendanceRecords.entrySet()) {
            String name = entry.getKey();
            String status = entry.getValue();
            
            System.out.printf("%-25s | %-12s\n", name, status);

            // Calculate metrics breakdown
            if (status.equals("Present")) presentCount++;
            else if (status.equals("Absent")) absentCount++;
            else unmarkedCount++;
        }

        // Display totals summary block
        System.out.println("----------------------------------------");
        System.out.println("Total Present: " + presentCount);
        System.out.println("Total Absent : " + absentCount);
        System.out.println("Unmarked Records: " + unmarkedCount);
    }
}
