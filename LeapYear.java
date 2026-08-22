import java.util.Scanner;
public class LeapYear{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter year to check:");
        int n = sc.nextInt(); 
        if (n%4==0 && n%100 !=0){
          System.out.println("This is leap year!");  
        }else{
            System.out.println("This is not leap year!");
        }
        sc.close();
    }
}