import java.util.Scanner;
public class PrintNumbers {
     public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value of n: to print n Numbers");
        int n = sc.nextInt();
        for(int i= 1; i<=n; i++){
            System.out.println(i);
        }
    }
}
