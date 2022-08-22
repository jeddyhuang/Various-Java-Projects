import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * CarDealership
 * 
 * A class that models a car dealership.
 */
public class CarDealership {
    private Car1 carOne;
    private Car1 carTwo;
    private Car1 carThree;
    private double dailyTransactions;
    
    public CarDealership() {
        this.dailyTransactions = 0;
    }
    
    public CarDealership(Car1 carOne, Car1 carTwo, Car1 carThree) {
        this();
        this.carOne = carOne;
        this.carTwo = carTwo;
        this.carThree = carThree;
    }
    
    public void performMaintenance(Scanner scan) {
        int choice = 0;
        System.out.println("Welcome to the Maintenance menu!");
        while (choice != 2) {
            System.out.println("Please select the service you wish to record:");
            System.out.println("1. Oil Change ($50)");
            System.out.println("2. Tire Rotation ($30)");
            System.out.println("3. Detailing ($100)");
            System.out.println("4. Tune-up ($200)");
            String input = scan.nextLine();
            for (char curr : input.toCharArray()) {
                if (!Character.isDigit(curr)) {
                    System.out.println("An error occurred!");
                    return;
                }
            }
            choice = Integer.valueOf(input);
            switch (choice) {
                case 1:
                    dailyTransactions += 50;
                    break;
                case 2:
                    dailyTransactions += 30;
                    break;
                case 3:
                    dailyTransactions += 100;
                    break;
                case 4:
                    dailyTransactions += 200;
                    break;
                default:
                    System.out.println("An error occurred!");
                    return;
            }
            System.out.println("Your selection has been recorded!");
            System.out.println("Did you sell another service?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            input = scan.nextLine();
            for (char curr : input.toCharArray()) {
                if (!Character.isDigit(curr)) {
                    System.out.println("An error occurred!");
                    return;
                }
            }
            choice = Integer.valueOf(input);
            switch (choice) {
                case 1:
                    break;
                case 2:
                    System.out.println("Thank you! Now returning to the Main Menu...");
                    return;
                default:
                    System.out.println("An error occurred!");
                    return;
            }
        }
    }
    
    public void sellCar(Scanner scan) {
        int choice = 0;
        boolean firsttime = true;
        System.out.println("Welcome to the Sales Menu!");
        while (choice != 2) {
            if (carOne == null && carTwo == null && carThree == null) {
                choice = 2;
                System.out.println("No vehicles currently available.");
                System.out.println("Thank you! Now returning to the Main Menu...");
                return;
            } else {
                this.printInventory();
                if (firsttime) System.out.println("Did you sell a vehicle?");
                else System.out.println("Did you sell another vehicle?");
                System.out.println("1. Yes");
                System.out.println("2. No");
                String input = scan.nextLine();
                for (char curr : input.toCharArray()) {
                    if (!Character.isDigit(curr)) {
                        System.out.println("An error occurred!");
                        return;
                    }
                }
                choice = Integer.valueOf(input);
                switch (choice) {
                    case 1:
                        break;
                    case 2:
                        System.out.println("Thank you! Now returning to the Main Menu...");
                        return;
                    default:
                        System.out.println("An error occurred!");
                        return;
                }
                System.out.println("Which vehicle was sold? Please enter"
                        + " the Make, Model, and Year separated by commas.");
                StringTokenizer tokens = new StringTokenizer(scan.nextLine(), ",");
                if (tokens.countTokens() != 3) {
                    System.out.println("An error occurred!");
                    return;
                }
                String make = tokens.nextToken();
                String model = tokens.nextToken();
                String temp = tokens.nextToken();
                for (char curr : temp.toCharArray()) {
                    if (!Character.isDigit(curr)) {
                        System.out.println("An error occurred!");
                        return;
                    }
                }
                int year = Integer.valueOf(temp);
                boolean soldyet = false;
                if (carOne != null && !soldyet) {
                    if (carOne.getMake().equals(make) &&
                            carOne.getModel().equals(model) &&
                            carOne.getYear() == year) {
                        carOne = carTwo;
                        carTwo = carThree;
                        carThree = null;
                        dailyTransactions += 15000;
                        soldyet = true;
                        System.out.println("The vehicle list has been updated!");
                    }
                }
                if (carTwo != null && !soldyet) {
                    if (carTwo.getMake().equals(make) &&
                            carTwo.getModel().equals(model) &&
                            carTwo.getYear() == year) {
                        carTwo = carThree;
                        carThree = null;
                        dailyTransactions += 15000;
                        soldyet = true;
                        System.out.println("The vehicle list has been updated!");
                    }
                }
                if (carThree != null && !soldyet) {
                    if (carThree.getMake().equals(make) &&
                            carThree.getModel().equals(model) &&
                            carThree.getYear() == year) {
                        carThree = null;
                        dailyTransactions += 15000;
                        soldyet = true;
                        System.out.println("The vehicle list has been updated!");
                    }
                }
                if (!soldyet) {
                    System.out.println("An error occurred!");
                    return;
                }
                firsttime = false;
            }
        }
    }
    
    public void buyCar(Scanner scan) {
        int choice = 0;
        boolean firsttime = true;
        System.out.println("Welcome to the Purchasing Menu!");
        while (choice != 2) {
            if (!(carOne == null && carTwo == null && carThree == null)) this.printInventory();
            if (carOne != null && carTwo != null && carThree != null) {
                System.out.println("The Vehicle Inventory is now full.");
                System.out.println("Thank you! Now returning to the Main Menu...");
                return;
            } else {
                if (firsttime) System.out.println("Did you purchase a vehicle?");
                else System.out.println("Did you purchase another vehicle?");
                System.out.println("1. Yes");
                System.out.println("2. No");
                String input = scan.nextLine();
                for (char curr : input.toCharArray()) {
                    if (!Character.isDigit(curr)) {
                        System.out.println("An error occurred!");
                        return;
                    }
                }
                choice = Integer.valueOf(input);
                switch (choice) {
                    case 1:
                        break;
                    case 2:
                        System.out.println("Thank you! Now returning to the Main Menu...");
                        return;
                    default:
                        System.out.println("An error occurred!");
                        return;
                }
                System.out.println("Please enter the Vehicle Details!");
                System.out.println("Make:");
                String make = scan.nextLine();
                System.out.println("Model:");
                String model = scan.nextLine();
                System.out.println("Year:");
                input = scan.nextLine();
                for (char curr : input.toCharArray()) {
                    if (!Character.isDigit(curr)) {
                        System.out.println("An error occurred!");
                        return;
                    }
                }
                int year = Integer.valueOf(input);
                Car1 newCar = new Car1(make, model, year);
                if (carOne == null) carOne = newCar;
                else if (carTwo == null) carTwo = newCar;
                else if (carThree == null) carThree = newCar;
                dailyTransactions -= 10000;
                firsttime = false;
            }
        }
    }
    
    public void printInventory() {
        System.out.println("Current Inventory is Listed Below:");
        if (carOne != null) System.out.println(carOne.toString());
        if (carTwo != null) System.out.println(carTwo.toString());
        if (carThree != null) System.out.println(carThree.toString());
    }
    
    public void menu() {
        Scanner in = new Scanner(System.in);
        int choice = 0;
        while (choice != 5) {
            System.out.println("Welcome to the Main Menu!");
            System.out.printf("The Daily Transactions value is currently: $%.2f%n", dailyTransactions);
            System.out.println("Please select an Option:");
            System.out.println("1. Perform Maintenance");
            System.out.println("2. Sell Car");
            System.out.println("3. Buy Car");
            System.out.println("4. Print Inventory");
            System.out.println("5. Quit");
            String input = in.nextLine();
            boolean latch = true;
            for (char curr : input.toCharArray()) {
                if (!Character.isDigit(curr)) {
                    latch = false;
                    choice = 0;
                }
            }
            if (latch) choice = Integer.valueOf(input);
            switch (choice) {
                case 1:
                    this.performMaintenance(in);
                    break;
                case 2:
                    this.sellCar(in);
                    break;
                case 3:
                    this.buyCar(in);
                    break;
                case 4:
                    this.printInventory();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("An error occurred!");
                    break;
            }
        }
        System.out.println("Thank you for using the Car Dealership program!");
    }
    
    public static void main(String[] args) {
        CarDealership temp = new CarDealership();
        temp.menu();
    }
}