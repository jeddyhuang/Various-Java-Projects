/**
 * Book2
 * 
 * A class that models a book.
 */
public class Book2 {
    private String name;
    private char type;
    private double sellPrice;
    private static String bookList;
    
    public Book2(String name, char type, double sellPrice) {
        this.name = name;
        this.type = type;
        this.sellPrice = sellPrice;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public char getType() {
        return type;
    }
    
    public void setType(char type) {
        this.type = type;
    }
    
    public double getSellPrice() {
        return sellPrice;
    }
    
    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }
    
    public String getBookList() {
        return bookList;
    }
    
    public void setBookList(String booklist) {
        this.bookList = booklist;
    }
    
    public double calculatePrice() {
        if (type == 'F') return sellPrice * 1.05;
        else return sellPrice * 1.025;
    }
    
    public String toString() {
        String price = Double.toString(calculatePrice());
        return type + "-" + name + "-" + price.substring(0,price.indexOf(".") + 3);
    }
}