/**
 * StringFinder
 * 
 * A class that will search a String for the number of occurrences of a given
 * sub-string.
 */
public class StringFinder extends Thread {
    private static final Object GATEKEEPER = new Object();
    private static int counter = 0;
    private int start;
    private int end;
    private String inputText;
    private String wordToFind;
    
    public StringFinder(String inputText, String wordToFind, int start, int end) {
        this.inputText = inputText;
        this.wordToFind = wordToFind;
        this.start = start;
        this.end = end;
    }
    
    @Override
    public void run() {
        synchronized (GATEKEEPER) {
            String[] words = inputText.substring(start, end).split(" ");
            for (String str : words) {
                if (str.contains(",") || str.contains(".") || str.contains(":") ||
                        str.contains(";") || str.contains("!") ||str.contains("?")) {
                    str = str.substring(str.length() - 1);
                }
                if (str.equalsIgnoreCase(wordToFind)) counter++;
            }
        }
    }
    
    public static int getCounter() {
        return counter;
    }
    
    public static void main(String[] args) {
        String inputText = "She didn’t understand how change worked." +
                   "When she looked at today compared to yesterday," +
                   " there was nothing that she could see that was different." +
                   " Yet, when she looked at today compared to last year, " + 
                   "she couldn’t see how anything was ever the same.";
        StringFinder one = new StringFinder(inputText, "she", 0, 40);
        StringFinder two = new StringFinder(inputText, "she", 40, 88);
        one.start();
        two.start();
        try {
            one.join();
            two.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println(StringFinder.getCounter());
    }
}
