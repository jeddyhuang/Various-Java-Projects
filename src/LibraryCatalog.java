import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * LibraryCatalog 
 *
 * LibraryCatalog represents the catalog of books held by a library. Operations
 * such as borrowing and book searches are handled here. Furthermore, information
 * is read from a file in the beginning of the program, and saved back to the
 * file at the end of the program.
 */
public class LibraryCatalog {
    private ArrayList<Book> books;
    private String fileName;
    
    public LibraryCatalog(String fileName) throws FileNotFoundException,
            BookParseException {
        this.fileName = fileName;
        books = new ArrayList<Book>();
        try (BufferedReader bfr = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bfr.readLine()) != null) {
                books.add(this.parseBook(line));
            }
        } catch (FileNotFoundException | BookParseException e) {
            throw e;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static Book parseBook(String line) throws BookParseException {
        StringTokenizer tokens = new StringTokenizer(line);
        if (tokens.countTokens() != 5) {
            String msg = "Error parsing book! Data provided in a single line is invalid!";
            throw new BookParseException(msg);
        }
        try {
            String title = tokens.nextToken().replaceAll("_", " ");
            String author = tokens.nextToken().replaceAll("_", " ");
            float price = Float.valueOf(tokens.nextToken());
            int quantity = Integer.valueOf(tokens.nextToken());
            int year = Integer.valueOf(tokens.nextToken());
            return new Book(title, author, price, quantity, year);
        } catch (NumberFormatException e) {
            String msg = "Error parsing book! Failed to parse numbers from file";
            throw new BookParseException(msg);
        }
    }
    
    public ArrayList<Book> searchByName(String bookName) throws BookNotFoundException {
        ArrayList<Book> newList = new ArrayList<Book>();
        for (Book book : books) {
            if (book.getBookName().contains(bookName.toLowerCase())) newList.add(book);
        }
        if (newList.size() > 0) return newList;
        else {
            String msg = "No books found with the given book name!";
            throw new BookNotFoundException(msg);
        }
    }
    
    public ArrayList<Book> searchByAuthor(String authorName) throws BookNotFoundException {
        ArrayList<Book> newList = new ArrayList<Book>();
        for (Book book : books) {
            if (book.getAuthorName().contains(authorName.toLowerCase())) newList.add(book);
        }
        if (newList.size() > 0) return newList;
        else {
            String msg = "No books found with the given author name!";
            throw new BookNotFoundException(msg);
        }
    }
    
    public void borrowBook(String bookName) throws BookNotFoundException {
        for (int i = 0; i < books.size(); i++) {
            if (bookName.equals(books.get(i).getBookName())) {
                int quantity = books.get(i).getQuantity();
                if (quantity == 0) {
                    String msg = "The given book was not found.";
                    throw new BookNotFoundException(msg);
                }
                if (quantity > 0) {
                    books.get(i).setQuantity(quantity - 1);
                    return;
                }
            }
        }
        String msg = "The given book was not found.";
        throw new BookNotFoundException(msg);
    }
    
    public void writeChangesToFile() throws FileNotFoundException {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(fileName))) {
            for (Book book : books) {
                pw.print(book.getBookName().replaceAll(" ", "_") + " ");
                pw.print(book.getAuthorName().replaceAll(" ", "_") + " ");
                pw.printf("%.2f ", book.getPrice());
                pw.print(Integer.toString(book.getQuantity()) + " ");
                pw.println(Integer.toString(book.getYear()));
            }
            pw.close();
        } catch (FileNotFoundException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Book> getBookList() {
        return books;
    }
}
