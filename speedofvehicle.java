import java.util.Scanner;

public class VehicleSpeedCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input distance and time
        System.out.print("Enter the distance travelled (in km): ");
        double distance = scanner.nextDouble();

        System.out.print("Enter the time taken (in hours): ");
        double time = scanner.nextDouble();

        // Check for zero or negative time to avoid division by zero
        if (time <= 0) {
            System.out.println("Time must be greater than zero.");
        } else {
            // Calculate speed
            double speed = distance / time;
            System.out.println("The speed of the vehicle is: " + speed + " km/h");
        }

        scanner.close();
    }
}
