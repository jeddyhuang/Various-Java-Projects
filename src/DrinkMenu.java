import java.util.Scanner; 

/**
 * A program that calculates a user's drink order!
 */
public class DrinkMenu {
    public static void main(String[] args) {
        int totalPrice = 0; 
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Would you like to order?");
        System.out.println("1. Water"); 
        System.out.println("2. Hot Tea");
        System.out.println("3. Soda");
        System.out.println("4. Coffee");
        
        int choice = scan.nextInt();
        switch(choice){
            case 1:{
                totalPrice = 1;
                break;
            }
            case 2:{
                totalPrice = 3;
                break;
            }
            case 3:{
                totalPrice = 2;
                break;
            }
            case 4:{
                totalPrice = 5;
                break;
            }
            default:{
                System.out.println("Error! Choose an item on the menu!"); 
            }
        }
        
        System.out.println("Your total is: $" + totalPrice); 
    }
}