import java.util.Scanner;
public class EvenOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your number");
        int no = sc.nextInt();
        if (no % 2 == 0){
            System.out.println("Number entered is even");
        }else{
            System.out.println("Number entered is odd");   
        }
        sc.close();
    }
}
