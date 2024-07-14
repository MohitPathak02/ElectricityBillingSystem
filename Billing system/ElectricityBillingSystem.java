import java.util.Scanner;

public class ElectricityBillingSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input customer details
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();
        
        System.out.print("Enter number of units consumed: ");
        int units = scanner.nextInt();
        
        // Calculate bill
        double billAmount = calculateBill(units);
        
        // Display bill
        System.out.println("\nElectricity Bill");
        System.out.println("------------------");
        System.out.println("Customer Name: " + customerName);
        System.out.println("Units Consumed: " + units);
        System.out.printf("Total Bill Amount: $%.2f%n", billAmount);
        
        scanner.close();
    }

    public static double calculateBill(int units) {
        double bill;
        
        // Calculate bill based on unit consumption
        if (units <= 100) {
            bill = units * 1.20; // $1.20 per unit for first 100 units
        } else if (units <= 300) {
            bill = (100 * 1.20) + ((units - 100) * 2.00); // $2.00 per unit for next 200 units
        } else {
            bill = (100 * 1.20) + (200 * 2.00) + ((units - 300) * 3.00); // $3.00 per unit for units above 300
        }
        
        // Adding fixed charges
        bill += 50; // Fixed charges
        
        // Applying a discount if applicable
        if (bill > 300) {
            bill *= 0.90; // 10% discount
        }
        
        return bill;
    }
}
