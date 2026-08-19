import java.util.Scanner;

public class NumberMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice; // Variable ko upar declare kiya taaki loop condition ise use kar sake

        do {
            // 1. Menu ko loop ke andar daala taaki ye har baar screen par dikhe
            System.out.println("\n---Menu---");
            System.out.println("1. Print 1 to N");
            System.out.println("2. Print Even numbers");
            System.out.println("3. Print Odd numbers");
            System.out.println("4. Exit"); // 4th choice Exit ke liye
            System.out.print("Enter Your choice: ");
            
            choice = sc.nextInt(); // 2. Input ab loop ke andar hai taaki naya choice update ho sake

            switch (choice) {
                case 1:
                    System.out.print("Enter value of n: ");
                    int n = sc.nextInt();
                    for (int i = 1; i <= n; i++) {
                        System.out.println(i);
                    }
                    break;

                case 2:
                    System.out.print("Enter max value to print even number: ");
                    int m = sc.nextInt(); 
                    int j = 1;
                    while (j <= m) {
                        if (j % 2 == 0) {
                            System.out.println(j);
                        }
                        j++;
                    }
                    break;

                case 3:
                    System.out.print("Enter max value to print odd number: ");
                    int o = sc.nextInt(); 
                    int k = 1;
                    while (k <= o) {
                        // FIX: Aapke code mein yahan even ka logic tha (==0), use (!=0) kiya
                        if (k % 2 != 0) { 
                            System.out.println(k);
                        }
                        k++;
                    }
                    break;

                case 4:
                    System.out.println("Program se exit ho rahe hain... Bye!");
                    break;

                default:
                    System.out.println("Invalid Choice! Kripya 1 se 4 ke beech chune.");
            }

        // FIX: Jab tak choice 4 ke barabar nahi hai (!= 4), tab tak loop chalta rahega
        } while (choice != 4);    
        
        sc.close();
    }
}

