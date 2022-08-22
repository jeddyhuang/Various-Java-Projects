import javax.swing.*;

public class OrderFormGUI {
    public static void main(String[] args) {
        /** DO NOT CHANGE VALUES BELOW **/
        boolean hoodieInStock = true;
        boolean tshirtInStock = false;
        boolean longsleeveInStock = true;
        String item = "";
        int quantity = 0;
        String name = "";
        /** DO NOT CHANGE VALUES ABOVE **/
        
        int dialogResult;
        do {
            //TODO: display error GUI if item selected is out of stock
            String[] options = {"Hoodie", "T-shirt", "Long sleeve"};
            boolean inStock;
            do {
                inStock = false;
                item = (String) JOptionPane.showInputDialog(null, "Select item style", "Order Form",
                        JOptionPane.PLAIN_MESSAGE, null, options, null);
                if (item != null) switch (item) {
                    case "Hoodie":
                        inStock = hoodieInStock;
                        break;
                    case "T-Shirt":
                        inStock = tshirtInStock;
                        break;
                    case "Long sleeve":
                        inStock = longsleeveInStock;
                        break;
                }
                if (!inStock) {
                    JOptionPane.showMessageDialog(null, "Out of Stock",
                            "Order Form", JOptionPane.ERROR_MESSAGE);
                }
            } while (!inStock);

            //TODO: display error GUI if input is not an int or if input is less than 1
            String quantityString;
            boolean isNum;
            boolean doesLoop1;
            do {
                doesLoop1 = false;
                isNum = true;
                quantityString = JOptionPane.showInputDialog(null, "Enter quantity", "Order Form",
                        JOptionPane.QUESTION_MESSAGE);
                if ((quantityString != null) && !(quantityString.isBlank())) {
                    for (int i = 0; i < quantityString.toCharArray().length; i++) {
                        if (i == 0) {
                            if (quantityString.charAt(i) != '-') {
                                if (!Character.isDigit(quantityString.charAt(i))) isNum = false;
                            }
                        } else if (!Character.isDigit(quantityString.charAt(i))) isNum = false;
                    }
                    if (isNum) quantity = Integer.parseInt(quantityString);
                }
                if ((quantityString == null) || (quantityString.isBlank()) || !isNum) {
                    JOptionPane.showMessageDialog(null, "Enter an integer", "Order Form",
                            JOptionPane.ERROR_MESSAGE);
                    doesLoop1 = true;
                } else if (quantity <= 0) {
                    JOptionPane.showMessageDialog(null, "Enter a number greater than 0", "Order Form",
                            JOptionPane.ERROR_MESSAGE);
                    doesLoop1 = true;
                }
            } while (doesLoop1);

            //TODO: display error GUI if input does not include a space
            boolean doesLoop2;
            do {
                doesLoop2 = false;
                name = JOptionPane.showInputDialog(null, "Enter your Name", "Order Form",
                        JOptionPane.QUESTION_MESSAGE);
                if ((name == null) || (name.isBlank())) {
                    JOptionPane.showMessageDialog(null, "Enter first and last name",
                            "Order Form", JOptionPane.ERROR_MESSAGE);
                    doesLoop2 = true;
                } else if (name != null) if (!name.contains(" ")) {
                    JOptionPane.showMessageDialog(null, "Enter first and last name",
                            "Order Form", JOptionPane.ERROR_MESSAGE);
                    doesLoop2 = true;
                }
            } while (doesLoop2);

            /** Order Confirmation Message **/
            String resultMessage = "Name: " + name + "\nItem: " + item + "\nQuantity: " + quantity;
            JOptionPane.showMessageDialog(null, resultMessage, "Order Confirmation", JOptionPane.INFORMATION_MESSAGE);

            //TODO: loop through order form again if YES
            dialogResult = JOptionPane.showConfirmDialog(null, "Would you like to place another order?", "Order Form", JOptionPane.YES_NO_OPTION);
        } while (dialogResult == JOptionPane.YES_OPTION);
    }
}
