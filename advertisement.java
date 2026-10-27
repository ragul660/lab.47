import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Main {

    // 1. Modern Java Feature: Records (Data Containers)
    public record Product(String name, double price, String category) {}

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   🚀 RUNNING THE ULTIMATE JAVA UTILITY SUITE   ");
        System.out.println("==================================================\n");

        // Mock Dataset
        List<Product> products = Arrays.asList(
                new Product("Laptop", 1299.99, "Electronics"),
                new Product("Smartphone", 799.49, "Electronics"),
                new Product("Coffee Maker", 89.99, "Appliances"),
                new Product("Desk Chair", 150.00, "Furniture"),
                new Product("Headphones", 199.99, "Electronics")
        );

        // --- TASK 1: Functional Data Analytics via Streams ---
        System.out.println("--- 📊 Stream API Analytics ---");
        
        // Grouping products by category and calculating the average price per category
        Map<String, Double> avgPriceByCategory = products.stream()
                .collect(Collectors.groupingBy(
                        Product::category,
                        Collectors.averagingDouble(Product::price)
                ));

        // Format currency dynamically using Locale
        NumberFormat usdFormatter = NumberFormat.getCurrencyInstance(Locale.US);
        avgPriceByCategory.forEach((category, avgPrice) -> 
            System.out.printf("Category: %-12s | Avg Price: %s%n", category, usdFormatter.format(avgPrice))
        );
        System.out.println();


        // --- TASK 2: Asynchronous Multi-Threaded Benchmarking ---
        System.out.println("--- ⚡ Asynchronous Multi-Threading Benchmark ---");
        long startTime = System.currentTimeMillis();

        // Spin up an asynchronous task to simulate an intense computation
        CompletableFuture<Long> heavyTask = CompletableFuture.supplyAsync(() -> {
            long sum = 0;
            for (int i = 0; i < 50_000_000; i++) {
                sum += i;
            }
            return sum;
        });

        System.out.println("Main thread is completely unblocked and doing other work...");
        
        try {
            // Block explicitly just to get the final result for presentation
            long result = heavyTask.get();
            long endTime = System.currentTimeMillis();
            System.out.println("Calculation Result: " + result);
            System.out.println("Benchmark Execution Time: " + (endTime - startTime) + " ms\n");
        } catch (Exception e) {
            System.err.println("Thread interrupted: " + e.getMessage());
        }


        // --- TASK 3: Robust File I/O & System Sandbox ---
        System.out.println("--- 💾 Automated System Sandbox (File I/O) ---");
        Path tempFile = Path.of("java_utility_sandbox_output.txt");
        
        try {
            // Construct content using functional pipelines
            String fileContent = "Generated Report Summary:\n" +
                    "==========================\n" +
                    products.stream()
                            .map(p -> p.name() + " (" + p.category() + ") - " + usdFormatter.format(p.price()))
                            .collect(Collectors.joining("\n"));

            // Write and read instantly using nio.Files
            Files.writeString(tempFile, fileContent);
            System.out.println("Successfully created and wrote data to: " + tempFile.toAbsolutePath());
            
            String readBack = Files.readString(tempFile);
            System.out.println("\n--- Verified File Contents Re-Read: ---");
            System.out.println(readBack);

            // Clean up files automatically to leave no trace on your compiler environment
            Files.deleteIfExists(tempFile);
            System.out.println("\nTemporary sandbox file safely cleaned up.");

        } catch (IOException e) {
            System.err.println("File Operations Error: " + e.getMessage());
        }

        System.out.println("\n==================================================");
        System.out.println("      ✅ EXECUTION COMPLETED SUCCESSFULLY       ");
        System.out.println("==================================================");
    }
}
