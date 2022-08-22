/**
 * MyCustomString
 * 
 * A class that models a custom String.
 */
public class MyCustomString {
    private String myString;
    
    public MyCustomString(String myString) {
        this.myString = myString;
    }
    
    public String getMyString() {
        return myString;
    }
    
    public void setMyString(String myString) {
        this.myString = myString;
    }
    
    public MyCustomInteger parseMyInt() {
        String tempString = myString;
        String target = "";
        while (tempString.length() != 0) {
            if (tempString.indexOf("one") == 0) {
                target += '1';
                tempString = tempString.substring(4);
            } else if (tempString.indexOf("two") == 0) {
                target += '2';
                tempString = tempString.substring(4);
            } else if (tempString.indexOf("three") == 0) {
                target += '3';
                tempString = tempString.substring(6);
            } else if (tempString.indexOf("four") == 0) {
                target += '4';
                tempString = tempString.substring(5);
            } else if (tempString.indexOf("five") == 0) {
                target += '5';
                tempString = tempString.substring(5);
            } else if (tempString.indexOf("six") == 0) {
                target += '6';
                tempString = tempString.substring(4);
            } else if (tempString.indexOf("seven") == 0) {
                target += '7';
                tempString = tempString.substring(6);
            } else if (tempString.indexOf("eight") == 0) {
                target += '8';
                tempString = tempString.substring(6);
            } else if (tempString.indexOf("nine") == 0) {
                target += '9';
                tempString = tempString.substring(5);
            } else if (tempString.indexOf("zero") == 0) {
                target += '0';
                tempString = tempString.substring(5);
            }
        }
        String finString = "";
        for (int i = 0; i < target.length(); i +=2) finString += target.charAt(i);
        return new MyCustomInteger(Integer.valueOf(finString));
    }
    
    public MyCustomString getAlternateCase() {
        String lowercase = myString.toLowerCase();
        String uppercase = myString.toUpperCase();
        String target = "";
        for (int i = 0; i < myString.length(); i ++) {
            if (i % 2 == 0) target += uppercase.charAt(i);
            else target += lowercase.charAt(i);
        }
        return new MyCustomString(target);
    }
}