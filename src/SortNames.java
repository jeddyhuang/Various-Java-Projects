import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections; 
/**
 * A program that reads names from a text file, sorts them, then writes them to another text file.
 */
public class SortNames {

    public static ArrayList<String> readFile(String filename)
        throws FileNotFoundException {
        ArrayList<String> list = new ArrayList<String>(); 
        try (BufferedReader bfr = new BufferedReader(new FileReader(filename))) {
            String line = bfr.readLine();
            while (line != null) {
                list.add(line);
                line = bfr.readLine();
            }
        } catch(FileNotFoundException e){
            throw e;
        } catch (IOException e){
            e.printStackTrace();
        }
        return list; 
    }

    public static void writeFile(String fileName, ArrayList<String> names) 
        throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream(new File(fileName),true); 
        PrintWriter pw = new PrintWriter(fos);
        for(String name : names) pw.println(name);
        pw.close();
    }

    public static void main(String[] args) {
        ArrayList<String> names;
        System.out.println("Enter filename with unsorted names");
        Scanner sc = new Scanner(System.in);
        String filename = sc.nextLine();
        try {
    	    names = readFile(filename);
            Collections.sort(names);
            writeFile("sorted_names.txt", names);
        } catch (FileNotFoundException e){
            System.out.println("File not found!");
            return;
        }
        System.out.println("Sorted names written to sorted_names.txt");
    }
}