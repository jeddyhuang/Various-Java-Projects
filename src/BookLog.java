import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * BookLog
 * 
 * A class that models a book log.
 */
public class BookLog {
    private Book2 fiction;
    private Book2 nonfiction;
    
    public Book2 getFiction() {
        return fiction;
    }
    
    public void setFiction(Book2 book) {
        fiction = book;
    }
    
    public Book2 getNonfiction() {
        return nonfiction;
    }
    
    public void setNonfiction(Book2 book) {
        nonfiction = book;
    }
    
    public void add(String input) {
        if (input.charAt(0) == 'F') fiction.setBookList(fiction.getBookList() + "*" + input);
        else nonfiction.setBookList(nonfiction.getBookList() + "*" + input);
        System.out.println("Added!");
    }
    
    public void search(String input) {
        StringTokenizer tokens;
        if (input.charAt(0) == 'F') tokens = new StringTokenizer(fiction.getBookList(), "-");
        else tokens = new StringTokenizer(nonfiction.getBookList(), "-");
        boolean found = false;
        while (tokens.hasMoreTokens()) if (tokens.nextToken().indexOf(input) == 0) {
            found = true;
            break;
        }
        if (found) System.out.println("Found!");
        else System.out.println("Not Found!");
    }
    
    public void closeApp() {
        int numBooks = 0;
        double price = 0;
        StringTokenizer fTokens = new StringTokenizer(fiction.getBookList(), "*");
        int tokenNum = fTokens.countTokens();
        boolean fPresent = false;
        for (int i = 0; i < tokenNum; i ++) {
            fPresent = true;
            String currBook = fTokens.nextToken();
            price += Double.valueOf(currBook.substring(currBook.lastIndexOf("-") + 1));
            numBooks ++;
            if (i + 1 == tokenNum) System.out.println(currBook);
        }
        if (!fPresent) System.out.println("F-No Book Available-0.00");
        StringTokenizer nTokens = new StringTokenizer(nonfiction.getBookList(), "*");
        tokenNum = nTokens.countTokens();
        boolean nPresent = false;
        for (int i = 0; i < tokenNum; i ++) {
            nPresent = true;
            String currBook = nTokens.nextToken();
            price += Double.valueOf(currBook.substring(currBook.lastIndexOf("-") + 1));
            numBooks ++;
            if (i + 1 == tokenNum) System.out.println(currBook);
        }
        if (!nPresent) System.out.println("N-No Book Available-0.00");
        if (fPresent && nPresent) System.out.println("0.00");
        else System.out.println(price);
        System.out.println(numBooks);
    }
    
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        int command;
        while ((command = Integer.valueOf(scanner.nextLine())) != 3) {
            if (command == 1) add(scanner.nextLine());
            else if (command == 2) search(scanner.nextLine());
            else System.out.println("Enter a valid input!");
        }
        closeApp();
    }
}