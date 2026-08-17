import java.util.Scanner;
public class Addition {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter first number :");
        int First=sc.nextInt();
        System.out.print("Enter second number :");
        int Second=sc.nextInt();
        int Add = First+Second;
        System.out.println("Hello First number is:"+First);
        System.out.println("Second number is:"+Second);
        System.out.println("Addition of the numbers is:"+ Add);
        sc.close();
    }
    
}
