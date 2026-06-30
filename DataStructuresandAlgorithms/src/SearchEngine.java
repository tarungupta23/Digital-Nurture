
import java.util.Arrays;

public class SearchEngine {

    // 1. Linear Search Implementation
    public static Product linearSearch(Product[] products, int targetId) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductId() == targetId) {
                return products[i]; // Found target
            }
        }
        return null; // Target not found
    }

    // 2. Binary Search Implementation
    public static Product binarySearch(Product[] sortedProducts, int targetId) {
        int left = 0;
        int right = sortedProducts.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Prevents potential integer overflow

            if (sortedProducts[mid].getProductId() == targetId) {
                return sortedProducts[mid]; // Found target
            }
            
            if (sortedProducts[mid].getProductId() < targetId) {
                left = mid + 1; // Discard left half
            } else {
                right = mid - 1; // Discard right half
            }
        }
        return null; // Target not found
    }

    public static void main(String[] args) {
        // An unsorted array representation of an inventory
        Product[] inventory = {
            new Product(302, "Wireless Mouse", "Electronics"),
            new Product(105, "Running Shoes", "Apparel"),
            new Product(440, "Coffee Maker", "Kitchen"),
            new Product(210, "Desk Lamp", "Home Decor"),
            new Product(115, "Mechanical Keyboard", "Electronics")
        };

        int searchTarget = 210;

        // --- Test 1: Linear Search ---
        System.out.println("=== Running Linear Search ===");
        Product resultLinear = linearSearch(inventory, searchTarget);
        System.out.println("Search Result: " + resultLinear);

        // --- Test 2: Binary Search ---
        System.out.println("\n=== Running Binary Search ===");
        
        // CRITICAL STEP: Binary search requires data sorted by the key we are searching for!
        Arrays.sort(inventory); 
        
        Product resultBinary = binarySearch(inventory, searchTarget);
        System.out.println("Search Result: " + resultBinary);
    }
}