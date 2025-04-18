import java.util.InputMismatchException;
import java.util.Scanner;

public class SalariedSalary extends AbstractSalary {

    private double annualSalary;
    private double bonus;

    public SalariedSalary(Employee employee, double annualSalary, double bonus) {
        super(employee, 0);
        this.annualSalary = annualSalary;
        this.bonus = bonus;
    }

    @Override
    public void userInput(Scanner scan) {
        try {
            System.out.print("Enter annual base salary: ");
            annualSalary = scan.nextDouble();

            System.out.print("Enter bonus amount: ");
            bonus = scan.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter numeric values.");
            scan.nextLine(); // Clear bad input
            userInput(scan); // Retry
        }
    }

    @Override
    public double calculateSalary() {
        // Convert to monthly gross income
        double grossSalary = (annualSalary + bonus) / 12;

        // Store in basicSalary
        setBasicSalary(grossSalary);

        // Return net salary after deductions
        return grossSalary - calculateDeductions(grossSalary);
    }

    @Override
    public String toString() {
        return String.format(
            "%s\nType: Salaried Employee\nAnnual Salary: $%.2f\nBonus: $%.2f\nNet Monthly Salary: $%.2f",
            getEmployee().toString(), annualSalary, bonus, calculateSalary()
        );
    }

    // Optional getters/setters
    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
