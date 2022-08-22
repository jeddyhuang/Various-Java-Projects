import java.io.*;
import java.net.*;
import javax.swing.*;

/**
 * CalculatorClient
 *
 * A class that defines a CalculatorClient.
 */
public class CalculatorClient {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome to the Calculator Client", "Calculator Client",
                JOptionPane.INFORMATION_MESSAGE);
        String socketName = JOptionPane.showInputDialog(null, "What is the host name?",
                "Calculator Client", JOptionPane.QUESTION_MESSAGE);
        String socketPort = JOptionPane.showInputDialog(null, "What is the port number?",
                "Calculator Client", JOptionPane.QUESTION_MESSAGE);
        boolean error = false;
        if ((socketName == null) || (socketName.isBlank()) || (socketPort == null) || (socketPort.isBlank())) {
            error = true;
        } else {
            try (Socket socket = new Socket(socketName, Integer.valueOf(socketPort));
                    PrintWriter writer = new PrintWriter(socket.getOutputStream());
                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                int dialogResult;
                JOptionPane.showMessageDialog(null, "Connection Established", "Calculator Client",
                        JOptionPane.INFORMATION_MESSAGE);
                do {
                    String response = "";
                    boolean doesLoop;
                    do {
                        doesLoop = false;
                        String equation = JOptionPane.showInputDialog(null, "Enter your equation",
                                "Calculator Client", JOptionPane.QUESTION_MESSAGE);
                        if ((equation == null) || (equation.isBlank())) {
                            JOptionPane.showMessageDialog(null, "Please enter a valid equation",
                                    "Calculator Client", JOptionPane.ERROR_MESSAGE);
                            doesLoop = true;
                        } else {
                            writer.write(equation);
                            writer.println();
                            writer.flush();
                            response = reader.readLine();
                            if (response.equals("error")) {
                                JOptionPane.showMessageDialog(null, "Please enter a valid equation",
                                        "Calculator Client", JOptionPane.ERROR_MESSAGE);
                                doesLoop = true;
                            }
                        }
                    } while (doesLoop);
                    JOptionPane.showMessageDialog(null, "Your Solution is: " + response, "Calculator Client",
                            JOptionPane.INFORMATION_MESSAGE);
                    dialogResult = JOptionPane.showConfirmDialog(null, "Would you like to enter another equation?",
                            "Calculator Client", JOptionPane.YES_NO_OPTION);
                    if (dialogResult == JOptionPane.NO_OPTION) {
                        JOptionPane.showMessageDialog(null, "Have a nice day", "Calculator Client",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                } while (dialogResult == JOptionPane.YES_OPTION);
            } catch (IOException | NumberFormatException e) {
                error = true;
            }
        }
        if (error) {
            JOptionPane.showMessageDialog(null, "Unable to Establish Connection", "Calculator Client",
                    JOptionPane.ERROR_MESSAGE);
        }
        System.exit(0);
    }
}