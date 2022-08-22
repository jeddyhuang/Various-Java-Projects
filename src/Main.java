import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Main {
  /**
   * Iterate through each line of input.
   */
  public static void main(String[] args) throws IOException {
    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    BufferedReader in = new BufferedReader(reader);
    String line;
    while ((line = in.readLine()) != null) {
      boolean latch = true;
      char mon = '0';
      for(int i = line.length()-1; i >= 0 && latch; i --) if(0 > (line.charAt(i)-'0') || (line.charAt(i)-'0') > 9){
        latch = false;
        mon = line.charAt(i);
      }
      System.out.println(mon);
    }
  }
}