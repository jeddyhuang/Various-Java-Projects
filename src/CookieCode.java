import java.util.Scanner;

/**
 * Cookie Code
 *
 * A program that generates alphanumeric codes to track and identify
 * merchandise.
 */
public class CookieCode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int warehouse = Integer.valueOf(scanner.nextLine());
        String unparsePackDate = scanner.nextLine();
        String packDate = unparsePackDate.substring(0, 2) + unparsePackDate.substring(3);
        String unparseExpDate = scanner.nextLine();
        String expDate = unparseExpDate.substring(0, 2) + unparseExpDate.substring(3);
        int flavor = Integer.valueOf(scanner.nextLine());
        String flavorChar = "";
        switch(flavor) {
            case 1:
                if (Integer.valueOf(scanner.nextLine()) == 1) flavorChar = "D";
                else flavorChar = "R";
                break;
            case 2:
                flavorChar = "O";
                break;
            case 3:
                flavorChar = "A";
                break;
            case 4:
                flavorChar = "B";
                break;
            case 5:
                flavorChar = "S";
                break;
        }
        String itemName = scanner.nextLine();
        int prodNumber = Integer.valueOf(scanner.nextLine());
        String identPt1 = Integer.toString(prodNumber + 1).substring(Integer.toString(prodNumber + 1).length() - 5);
        if (itemName.length() % 2 == 1) itemName = itemName.substring(itemName.length() / 2 + 1)
                + itemName.substring(0, itemName.length() / 2);
        else itemName = itemName.substring(itemName.length() / 2)
                + itemName.substring(0, itemName.length() / 2);
        String identPt2 = Character.toString(itemName.charAt(itemName.length() - 1))
                + Character.toString(itemName.charAt(1));
        identPt2 = identPt2.toUpperCase();
        String identPt3 = Integer.toString(prodNumber + 1).substring(0, 2);
        System.out.println("W" + warehouse + packDate +  expDate + flavorChar + identPt1 + identPt2 + identPt3);
    }
}
