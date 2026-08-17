import java.util.Scanner;
public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter first number :");
        int a= sc.nextInt();
        System.out.print("Enter second number :");
        int b= sc.nextInt();
        int Add = a+b;
        int Sub =a-b;
        int multiply = a*b;
        double divide = a/b;
        System.out.println("Hello First number is:"+a);
        System.out.println("Second number is:"+b);
        System.out.println("Addition of the numbers is:"+ Add);
        System.out.println("Subtraction of the numbers is:"+ Sub);
        System.out.println("Multiplication of the numbers is:"+ multiply);
        System.out.println("Division of the numbers is:"+ divide );
        sc.close();
    } 
}
