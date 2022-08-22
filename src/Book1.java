/**
 * Book1
 * 
 * A class that models a book.
 */
public class Book1 {
    // The name of this book.
    private String bookName;
    // The author of this book.
    private String author;
    // The edition of this book.
    private int edition;
    // The price of 1 book.
    private double price;
    // The quantity of this book available in the store.
    private int quantityAvailable;
    // The average rating of this book.
    private double averageRating;
    // The number of ratings this book has.
    private int numberOfRatings;
    
    /**
     * Constructs a newly allocated Book object with the specified bookName,
     * author, edition, price, quantityAvailable, averageRating, numberOfRatings.
     * 
     * @param bookName the bookName to be used in construction
     * @param author the author to be used in construction
     * @param edition the edition to be used in construction
     * @param price the price to be used in construction
     * @param quantityAvailable the quantityAvailable to be used in construction
     * @param averageRating the averageRating to be used in construction
     * @param numberOfRatings the numberOfRatings to be used in construction
     */
    public Book1(String bookName, String author, int edition, double price,
            int quantityAvailable, double averageRating, int numberOfRatings) {
        this.bookName = bookName;
        this.author = author;
        this.edition = edition;
        this.price = price;
        this.quantityAvailable = quantityAvailable;
        this.averageRating = averageRating;
        this.numberOfRatings = numberOfRatings;
    }
    
    /**
     * Returns the discount of this book based on the following conditions given the quantity.
     * 
     * @param quantity quantity * price is used to compute total price to calculate discount.
     * @return the discount calculated for the given quantity of this book.
     */
    public double calculateDiscount(int quantity) {
        double totalPrice = quantity * price;
        if (0 <= totalPrice && totalPrice < 10) return 0;
        else if (10 <= totalPrice && totalPrice < 13) return 0.1;
        else if (13 <= totalPrice && totalPrice < 15) return 0.2;
        else if (15 <= totalPrice && totalPrice < 20) return 0.3;
        else return 0.4;
    }
    
    /**
     * Returns the final price of the total books purchased after applying discount 
     * Remember to update the quantityAvailable after the purchase.
     * Note that if the given quantity is greater than the quantity available,
     * calculate the price only for the amount of available books.
     * Return 0 if the quantityAvailable is 0.
     * 
     * @param quantity the amount of books to be purchased
     * @return the total price of the book or books purchased.
     */
    public double purchaseBook(int quantity) {
        if (quantity > quantityAvailable) {
            quantity = quantityAvailable;
        }
        double discount = this.calculateDiscount(quantity);
        double cost = price * quantity * (1 - discount);
        quantityAvailable = quantityAvailable - quantity;
        return cost;
    }
    
    /**
     * Replaces all the attributes of this book with that of the given book.
     * 
     * @param book the book used to replace the current one.
     */
    public void replaceBook(Book1 book) {
        this.bookName = book.getBookName();
        this.author = book.getAuthor();
        this.edition = book.getEdition();
        this.price = book.getPrice();
        this.quantityAvailable = book.getQuantityAvailable();
        this.averageRating = book.getAverageRating();
        this.numberOfRatings = book.getNumberOfRatings();
    }
    
    /**
     * Sets the price of this book to the given price.
     * 
     * @param newPrice the new price of this book
     */
    public void changePrice(double newPrice) {
        this.price = newPrice;
    }
    
    /**
     * Updates the average rating and number of ratings of this book
     * by using the given formula:
     * Average Rating = ((Average Rating * Total Number of ratings)
     * + Given rating) / New Total Number of Ratings
     * 
     * @param rating 1 additional rating for the book.
     */
    public void rateBook(int rating) {
        averageRating = ((averageRating * numberOfRatings) + rating) / ++numberOfRatings;
    }
    
    /**
     * Adds the given quantity to the quantity available of this book.
     * 
     * @param quantity the amount of books added to the stock.
     */
    public void restock(int quantity) {
        quantityAvailable += quantity;
    }
    
    /**
     * Returns the name of this book.
     * 
     * @return the name of this book
     */
    public String getBookName() {
        return bookName;
    }
    
    /**
     * Returns the author of this book.
     * 
     * @return the author of this book
     */
    public String getAuthor() {
        return author;
    }
    
    /**
     * Returns the edition of this book.
     * 
     * @return the edition of this book
     */
    public int getEdition() {
        return edition;
    }
    
    /**
     * Returns the price of this book.
     * 
     * @return the price of this book
     */
    public double getPrice() {
        return price;
    }
    
    /**
     * Returns the quantity of this book available in the store.
     * 
     * @return the quantityAvailable of this book
     */
    public int getQuantityAvailable() {
        return quantityAvailable;
    }
    
    /**
     * Returns the average rating of this book.
     * 
     * @return the averageRating of this book
     */
    public double getAverageRating() {
        return averageRating;
    }
    
    /**
     * Returns the number of rating this book has.
     * 
     * @return the numberOfRatings of this book
     */
    public int getNumberOfRatings() {
        return numberOfRatings;
    }
    
    /**
     * Returns the {@code String} representation of this book. The returned {@code String} should be in the following
     * format:
     * <pre>
     Book1 book = new Book1("Harry Potter", "J K Rowling", 2012, 12, 4, 5, 200);
     System.out.println(book);
 </pre>
     *
     * The output should look like:
     * <pre>
     Book1 Name: Harry Potter
     Author: J K Rowling
     Edition: 2012
     Price: $12
     Quantity Available: 4
     Average Rating: 5
     Number of Ratings: 200
 </pre>
     *
     * @return the {@code String} representation of this book
     */
    @Override
    public String toString() {
        return  "Book Name : " + bookName + '\n' +
                "Author: " + author + '\n' +
                "Edition: " + edition + '\n' +
                "Price: $" + price + '\n' +
                "Quantity Available: " + quantityAvailable + '\n' +
                "Average Rating: " + averageRating + '\n' +
                "Number Of Ratings: " + numberOfRatings;
    }

    /**
     * Determines whether or not the specified object is equal to this book. {@code true} is returned if and
     * only if the specified object is an instance of {@code Book1} and if all its attributes are equal to this book's
     *
     * @param o the object to be used in the comparisons
     * @return {@code true}, if the specified object is equal to this book and {@code false} otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof Book1) {
            Book1 book = (Book1) o;
            return this.bookName.equals(book.getBookName()) &&
                    this.author.equals(book.getAuthor()) &&
                    this.edition == book.getEdition() &&
                    this.price == book.getPrice() &&
                    this.quantityAvailable == book.getQuantityAvailable() &&
                    this.averageRating == book.getAverageRating() &&
                    this.numberOfRatings == book.getNumberOfRatings();
        }
        return false;
    }
}