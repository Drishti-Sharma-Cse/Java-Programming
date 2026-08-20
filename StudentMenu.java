import java.util.Scanner;

public class StudentMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Declared outside the switch block so all cases can access them
        String name = "";
        int age = 0;
        int marks = 0;
        boolean exit = false;

        // Loop added to keep the menu active until option 4 is selected
        while (!exit) {
            System.out.println("\n---Menu---");
            System.out.println("1. Add Student Details ");
            System.out.println("2. Display Student Details");
            System.out.println("3. Check Result");
            System.out.println("4. Exit");
            System.out.print("Enter Your choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine(); // Consumes the leftover newline character from nextInt()

            switch (choice) {
                case 1:
                    System.out.println("----Entering Student Details----");
                    System.out.print("Enter Student name: ");
                    name = sc.nextLine(); 
                    System.out.print("Enter Student Age: ");
                    age = sc.nextInt();
                    System.out.print("Enter Student Marks: ");
                    marks = sc.nextInt();
                    break;
                    
                case 2:
                    System.out.println("----Student Details----");
                    System.out.println("Student Name: " + name);
                    System.out.println("Student Age: " + age);
                    System.out.println("Student Marks: " + marks);
                    break;
                    
                case 3:
                    if (marks >= 40) {
                        System.out.println("Student is Pass");
                    } else {
                        System.out.println("Student is Fail");
                    }
                    break;
                    
                case 4:
                    System.out.println("Exiting Program. Goodbye!");
                    exit = true;
                    break;
                    
                default:
                    System.out.println("Invalid Choice! Please try again.");
            }
        }
        sc.close();
    }
}
