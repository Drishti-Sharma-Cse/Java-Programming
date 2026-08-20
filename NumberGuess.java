import java.util.Scanner;
public class NumberGuess {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int secret = 26;
        System.out.println("---Guess a Number---");
        System.out.println("Enter your number");
        int n = sc.nextInt(); 
        if (n==secret){
            System.out.println("Bravo!!Your Guess matched!");
        }else if(n>secret){
            System.out.println("Too Big");
        }else{
            System.out.println("Too Small");
        }
    sc.close();
    }
}
