import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Sign Up
 *
 * Accepts input from a user to sign them up for a credit card.
 */
public class SignUp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Full Name:");
        String name = scanner.nextLine();
        System.out.println("Date of Birth:");
        String dob = scanner.nextLine();
        System.out.println("Annual Income:");
        double income = Double.valueOf(scanner.nextLine());
        System.out.println("Social Security Number:");
        String ssn = scanner.nextLine();
        System.out.println("Phone Number:");
        String phone = scanner.nextLine();
        System.out.println("Email:");
        String email = scanner.nextLine();
        System.out.println("Address:");
        String address = scanner.nextLine();
        
        StringTokenizer nametokens = new StringTokenizer(name);
        String firstname = nametokens.nextToken();
        String lastname = nametokens.nextToken();
        StringTokenizer dobtokens = new StringTokenizer(dob, "-");
        String month = dobtokens.nextToken();
        String day = dobtokens.nextToken();
        String year = dobtokens.nextToken();
        String username = firstname.toLowerCase().charAt(0) + lastname.toLowerCase() + day;
        StringTokenizer addresstokens = new StringTokenizer(address, ",");
        int cc1 = (int) lastname.charAt(lastname.length() - 1);
        char cc2 = (char)((int) lastname.charAt(0) + Integer.valueOf(month));
        int cc3 = ((int) income) % 77;
        StringTokenizer emailtokens = new StringTokenizer(email, "@");
        String emailbody = emailtokens.nextToken();
        char cc4 = emailbody.charAt(emailbody.length() - 1);
        String cc5 = phone.substring(0, 2);
        String cc = Integer.toString(cc1) + cc2 + Integer.toString(cc3) + cc4 + cc5;
        firstname = Character.toUpperCase(firstname.charAt(0)) + firstname.toLowerCase().substring(1);
        lastname = Character.toUpperCase(lastname.charAt(0)) + lastname.toLowerCase().substring(1);
        System.out.println(firstname + " " + lastname);
        System.out.println("Date of Birth: " + month + "/" + day + "/" + year);
        System.out.printf("Income: $%.2f\n", income);
        System.out.println("SSN: XX-XXX-" + ssn.substring(ssn.length() - 4));
        System.out.println("Phone: (" + phone.substring(0, 3) + ")" + phone.substring(3, 6) + "-" + phone.substring(6));
        System.out.println("Email: " + email);
        System.out.println("Address:");
        System.out.println(addresstokens.nextToken());
        System.out.println(addresstokens.nextToken());
        System.out.println("Username: " + username);
        System.out.println("Confirmation Code: " + cc);
    }
}
