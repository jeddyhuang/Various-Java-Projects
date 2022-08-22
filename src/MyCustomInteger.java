/**
 * MyCustomInteger
 * 
 * A class that models a custom integer.
 */
public class MyCustomInteger {
    private int myInteger;
    
    public MyCustomInteger(int myInteger) {
        this.myInteger = myInteger;
    }
    
    public int getMyInteger() {
        return myInteger;
    }
    
    public void setMyInteger(int myInteger) {
        this.myInteger = myInteger;
    }
    
    public MyCustomString toMyString() {
        String value = Integer.toString(myInteger);
        int power = value.length() - 1;
        String target = "";
        for (int i = 0; i < value.length(); i ++) {
            target += value.charAt(i);
            if (power - i != 0) target += Integer.toString(power - i);
        }
        String finString = "";
        for (int i = 0; i < target.length(); i ++) {
            switch (target.charAt(i)) {
                case '0':
                    finString += "zero";
                    break;
                case '1':
                    finString += "one";
                    break;
                case '2':
                    finString += "two";
                    break;
                case '3':
                    finString += "three";
                    break;
                case '4':
                    finString += "four";
                    break;
                case '5':
                    finString += "five";
                    break;
                case '6':
                    finString += "six";
                    break;
                case '7':
                    finString += "seven";
                    break;
                case '8':
                    finString += "eight";
                    break;
                case '9':
                    finString += "nine";
                    break;
            }
        }
        return new MyCustomString(finString);
    }
}