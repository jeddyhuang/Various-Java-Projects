import java.io.*;
import java.math.*;
import java.net.*;

/**
 * CalculatorServer
 *
 * A class that defines a CalculatorServer.
 */
public class CalculatorServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4242);
        System.out.println("Waiting for the client to connect...");
        
        Socket socket = serverSocket.accept();
        System.out.println("Client connected!");
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter writer = new PrintWriter(socket.getOutputStream());
        
        while (true) try {
            String message = reader.readLine();
            if (message == null) break;
            System.out.printf("Received from client:\n%s\n", message);

            String response = "";
            String[] equation = message.split(" ");
            if (equation.length != 3) response = "error";
            else {
                try {
                    boolean valid = true;
                    BigDecimal val1 = new BigDecimal(equation[0]);
                    BigDecimal val2 = new BigDecimal(equation[2]);
                    if (equation[1].length() != 1) response = "error";
                    else {
                        BigDecimal val3 = new BigDecimal(0);
                        char val = equation[1].charAt(0);
                        switch (val) {
                            case '+':
                                val3 = val1.add(val2);
                                break;
                            case '-':
                                val3 = val1.subtract(val2);
                                break;
                            case '*':
                                val3 = val1.multiply(val2);
                                break;
                            case '/':
                                val3 = val1.divide(val2);
                                break;
                            default:
                                valid = false;
                        }
                        if (valid) response = val3.toString();
                        else response = "error";
                    }
                } catch (Exception e) {
                    response = "error";
                }
            }

            writer.write(response);
            writer.println();
            writer.flush(); // Ensure data is sent to the client.
            System.out.printf("Sent to client:\n%s\n", response);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        
        writer.close();
        reader.close();
        System.exit(0);
    }
}