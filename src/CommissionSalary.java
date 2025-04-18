import java.util.InputMismatchException;
import java.util.Scanner;

public class CommissionSalary extends AbstractSalary {

    private double personalSales;

    // Each row is [salesThreshold, commissionRate]
    private double[][] commissionRates;

    // Constructor
    public CommissionSalary(Employee employee, double[][] commissionRates) {
        super(employee, 0);
        this.commissionRates = commissionRates;
    }

    // Input method from user (for personalSales only)
    @Override
    public void userInput(Scanner scan) {
        try {
            System.out.print("Enter personal sales amount: ");
            personalSales = scan.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a numeric sales value.");
            scan.nextLine(); // clear invalid input
            userInput(scan); // retry
        }
    }

    // Calculate gross salary based on commission tiers
    @Override
    public double calculateSalary() {
        double grossSalary = 0;

        // Apply highest applicable commission rate based on personal sales
        for (double[] rate : commissionRates) {
            double threshold = rate[0];
            double commissionRate = rate[1];

            if (personalSales > threshold) {
                grossSalary = personalSales * commissionRate;
            }
        }

        // Store gross in baseSalary
        setBasicSalary(grossSalary);

        // Return net after deductions
        return grossSalary - calculateDeductions(grossSalary);
    }

    @Override
    public String toString() {
        return String.format(
            "%s\nType: Commission Salary\nPersonal Sales: $%.2f\nNet Salary: $%.2f",
            getEmployee().toString(), personalSales, calculateSalary()
        );
    }

    // Optional: Setters and Getters
    public double getPersonalSales() {
        return personalSales;
    }

    public void setPersonalSales(double personalSales) {
        this.personalSales = personalSales;
    }

    public double[][] getCommissionRates() {
        return commissionRates;
    }

    public void setCommissionRates(double[][] commissionRates) {
        this.commissionRates = commissionRates;
    }
}
