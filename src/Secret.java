import java.io.*;

/**
 * Secret
 *
 * A class that defines a Secret.
 */
public class Secret {
    public static String readSecretFromFile(String filename) throws UnsupportedFileException {
        if (!new File(filename).exists()) return null;
        try (BufferedReader bfr = new BufferedReader(new FileReader(filename))) {
            String line = bfr.readLine();
            int shift = Integer.valueOf(line);
            String message = "";
            while ((line = bfr.readLine()) != null) {
                message += Secret.changeText(false, shift, line);
            }
            return message;
        } catch (NumberFormatException e) {
            throw new UnsupportedFileException("Invalid format.");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static void writeSecretToFile(int shift, String message, String filename) {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(filename))) {
            pw.println(shift);
            pw.println(Secret.changeText(true, shift, message));
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public static String changeText(boolean encrypt, int shift, String message) {
        char[] chars = message.toCharArray();
        if (encrypt) {
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != ' ') chars[i] = (char) ((int) chars[i] + shift);
            }
        } else {
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != ' ') chars[i] = (char) ((int) chars[i] - shift);
            }
        }
        message = "";
        for (char temp : chars) message += temp;
        return message;
    }
}
