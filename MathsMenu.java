import java.util.Scanner;
public class MathsMenu {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice; 

        do {

            System.out.println("\n---Menu---");
            System.out.println("1. Square Root");
            System.out.println("2. Power");
            System.out.println("3. Absolute Value");
            System.out.println("4. Maximum");
            System.out.println("5. Minimum");
            System.out.println("6. Exit");
            System.out.print("Enter Your choice: ");
            
            choice = sc.nextInt(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter a Number: ");
                    double n = sc.nextInt();
                    double y= Math.sqrt(n);
                    System.out.print("Square Root of number is " + y );
                    break;

                case 2:
                    System.out.print("Enter a Number: ");
                    double num = sc.nextInt();
                    System.out.print("Enter Power: ");
                    double pow = sc.nextInt();
                    double a= Math.pow(num ,pow );
                    System.out.print("Final number is " + a );
                    break;
                case 3:
                    System.out.print("Enter a Number: ");
                    double Q = sc.nextInt();
                    double p= Math.abs(Q);
                    System.out.print("Absolute number is " + p );
                    break;
                case 4:
                    System.out.print("Enter 1st Number: ");
                    double c = sc.nextInt();
                    System.out.print("Enter 2nd Number: ");
                    double d = sc.nextInt();
                    double f= Math.max(c,d);
                    System.out.print(" Maxium number is " + f );
                    break;
                case 5:
                    System.out.print("Enter 1st Number: ");
                    double h = sc.nextInt();
                    System.out.print("Enter 2nd Number: ");
                    double g = sc.nextInt();
                    double k= Math.min(h,g);
                    System.out.print(" Maxium number is " + k );
                    break;

                default:
                    System.out.println("Invalid Choice! Kripya 1 se 4 ke beech chune.");
            }
        } while (choice != 6);    
        
        sc.close();
    }
}
