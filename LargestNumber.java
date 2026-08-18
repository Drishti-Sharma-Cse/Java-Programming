import java.util.Scanner;
public class LargestNumber {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter First Number");
        int n1 = sc.nextInt();
        System.out.println("Enter Second Number");
        int n2 = sc.nextInt();
        System.out.println("Enter Third Number");
        int n3 = sc.nextInt();
        if(n1>=n2 && n1>=n3){
           System.out.println("Largest number is"+n1); 
        }else if(n2>=n1 && n2>=n3){
           System.out.println("Largest number is\n"+n2);
        }else{
            System.out.println("Largest number is"+n3);  
        }
        sc.close();
    }
}