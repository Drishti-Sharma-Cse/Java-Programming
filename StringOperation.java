import java.util.Scanner;

public class StringOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("\n---Menu---");
        System.out.println("1. String Length");
        System.out.println("2. String Uppercase");
        System.out.println("3. String Lowercase");
        System.out.println("4. Character at position");
        System.out.println("5. Remove Spaces");
        System.out.println("6. Exit");
        System.out.print("Enter Your choice: ");
        
        choice = sc.nextInt();
        sc.nextLine(); // 🔥 FIX: Consumes the leftover newline character

        switch (choice) {
            case 1:
                System.out.print("Enter a String: ");
                String name = sc.nextLine();
                System.out.println("Length: " + name.length());
                break;
            case 2:
                System.out.print("Enter a String: ");
                String n = sc.nextLine();
                System.out.println("Uppercase: " + n.toUpperCase());
                break;
            case 3:
                System.out.print("Enter a String: ");
                String p = sc.nextLine();
                System.out.println("Lowercase: " + p.toLowerCase());
                break;
            case 4:
                System.out.print("Enter a String: ");
                String o = sc.nextLine();
                System.out.print("Enter indexing: ");
                int v = sc.nextInt();
                System.out.println("Character: " + o.charAt(v));
                break;
            case 5:
                System.out.print("Enter a String: ");
                String e = sc.nextLine();
                System.out.println("Result: " + e.trim()); 
                break;
            case 6:
                System.out.println("Exiting program. Bye!");
                break;
            default:
                System.out.println("Invalid Choice! Kripya 1 se 6 ke beech chune.");
        }
        sc.close();
    }
}
