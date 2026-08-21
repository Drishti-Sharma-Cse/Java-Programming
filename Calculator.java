import java.util.Scanner;
public class Calculator {
     public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("---Menu---");
        System.out.println("1.Addition");
        System.out.println("2.Subtraction");
        System.out.println("3.Multiplication");
        System.out.println("4.Division");
        System.out.println("Enter Your choice");
        int choice = sc.nextInt();
        switch(choice){
            case 1:
                System.out.println("Enter 1st Number");
                int n = sc.nextInt(); 
                System.out.println("Enter 2nd Number");       
                int m = sc.nextInt();
                int o = n + m; 
                System.out.println("Addition" + o);
                break;
            case 2:
                System.out.println("Enter 1st Number");
                int a = sc.nextInt(); 
                System.out.println("Enter 2nd Number");       
                int b = sc.nextInt();
                int c = a-b; 
                System.out.println("Subtraction" + c);
                break;
            case 3:
                System.out.println("Enter 1st Number");
                int i = sc.nextInt(); 
                System.out.println("Enter 2nd Number");       
                int j = sc.nextInt();
                int k = i * j; 
                System.out.println("Multiplication" + k);
                break;
            case 4:
                System.out.println("Enter 1st Number");
                int s = sc.nextInt(); 
                System.out.println("Enter 2nd Number");       
                int r = sc.nextInt();
                int g= s % r; 
                System.out.println("Division" + g);
                break;
            default:
                System.out.println("Invalid Choice!");
        }
    sc.close();
    } 
}
