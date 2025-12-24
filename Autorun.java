import java.io.*;
import  java.util.*;

public class Autorun {
    private List<String> names;
    private List<String> content;
    private String multipleLines;

    public Autorun(){
        this.names  = Arrays.asList(
            "Lord James Fetherstonhaugh", 
            "Lord Edward Fetherstonhaugh", 
            "Lady Catherine Fetherstonhaugh", 
            "Lady Caroline Fetherstonhaugh", 
            "Lady Hilda Fetherstonhaugh", 
            "Lady Diana Fetherstonhaugh", 
            "Lord Surmont Fetherstonhaugh", 
            "Lady Carlos Fetherstonhaugh", 
            "Lord Patrick Fetherstonhaugh", 
            "Prince Adelford of Valemont", 
            "Lord Arthur Blackwood", 
            "King Edwards II", 
            "King Louis IV", 
            "Lord Franklin Hatherleigh", 
            "Prince Belford of Valemont", 
            "Princess Mary of Valemont", 
            "Lady Alexa Hatherleigh", 
            "Lord Daniel Hatherleigh"
        );

        this.content = new ArrayList<String>();
        this.multipleLines = "";

    }
    public  void main(String[] args) throws FileNotFoundException {
        System.out.println("What task do you want to execute: ");
        Scanner scan = new Scanner(System.in);
        int ans = Integer.parseInt(scan.nextLine());
        if(ans == 1){
            GenerateURL(names);
        }
        else if (ans == 2){
            scanAndFormat(new File("content.txt"));
            formatContent(content);
        }
        else if (ans == 3){
            scanAndFormat(new File("content.txt"));
            toSingleLine(content);
        }
        else{
            scanContent(new File("content.txt"));
            toSingleLine(content);
        }

    }

    public void GenerateURL(List<String> names){
                // Base URL prefix
        String baseUrl = "https://cdn.jsdelivr.net/gh/RC0607/imageStorage/";

        // Generate JSON-style lines
        for (String fullName : names) {
            // Split by spaces
            String[] parts = fullName.split(" ");
            // Assume first name is the second word (after title like Lord/Lady/Sir)
            String firstName = parts[1].toLowerCase();
            String url = baseUrl + firstName + ".webp";

            // Print in JSON key -> value format
            System.out.println("  \"" + fullName + "\": \"" + url + "\",");
        }
    }
    
    public void scanAndFormat(File file) throws FileNotFoundException {
    Scanner scanner = new Scanner(file);

    while (scanner.hasNextLine()) {
        String line = scanner.nextLine().trim();

        // Skip empty lines
        if (line.isEmpty()) {
            continue;
        }

        content.add(line);
    }

    scanner.close();
    }

    public void scanContent(File file) throws FileNotFoundException {
    Scanner scanner = new Scanner(file);

    while (scanner.hasNextLine()) {
        String line = scanner.nextLine().trim();

        content.add(line);
    }

    scanner.close();
    }

    public void formatContent(List<String> content) throws FileNotFoundException{
        PrintStream output = new PrintStream(new File("formatted-content.txt"));
        for(String line: content){
            if (line == null) {
                output.println("<br></br>") ;
            }

            String trimmed = line.trim();
            output.println("<br>" + trimmed + "</br>") ;

        }
            System.out.println("Finished formatting output");
    }

    public void toSingleLine(List<String> content) throws FileNotFoundException{
        PrintStream output = new PrintStream(new File("single-line.txt"));
        for(String line: content){
            String trimmed = line.trim();
            output.print("<br>" + trimmed + "</br>") ;
        }
            System.out.println("Finished formatting output");
    }
}
