import java.util.Scanner;
public class SimpleMenu {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("---Menu---");
        System.out.println("1.Hello");
        System.out.println("2.Good Morning");
        System.out.println("3.Good Night");
        System.out.println("Enter Your choice");
        int choice = sc.nextInt();
        switch(choice){
            case 1:
                System.out.println("Hello! Beautiful");
                break;
            case 2:
                System.out.println("Good Morning Dear! Have nice day!");
                break;
            case 3:
                System.out.println("Good Night Dear! Sweet Dreams!");
                break;
            default:
                System.out.println("Invalid Choice!");
        }
    sc.close();
    }
}
