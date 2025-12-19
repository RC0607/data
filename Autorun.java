import java.util.*;

public class Autorun {
    public static void main(String[] args) {
        // Example list of full names
        List<String> names = Arrays.asList(
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
            "King Louis IV"
        );

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
}