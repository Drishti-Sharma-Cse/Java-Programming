import java.util.Scanner;
public class EvenNumbers {
   public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter max value to print even number");
        int n = sc.nextInt(); 
        int i=1;
        while(i<=n){
            if (i%2==0){
                System.out.println(i);
            }
            i++;
        }
    sc.close();
   }
}
