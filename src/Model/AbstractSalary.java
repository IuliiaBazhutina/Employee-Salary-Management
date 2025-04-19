
import java.util.Scanner;

public abstract class AbstractSalary implements Salary {

    private Employee employee;
    private double basicSalary;

    public AbstractSalary(Employee employee, double basicSalary) {
        this.employee = employee;
        this.basicSalary = basicSalary;
    }

    public Employee getEmployee() {
        return employee;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    @Override
    public abstract double calculateSalary();

    @Override
    public abstract String toString();

    protected double calculateDeductions(double grossSalary) {
        return DeductionsUtility.calculateDeductions(grossSalary);
    }

    protected String displayDeductions(double grossSalary) {
        return DeductionsUtility.displayDeductions(grossSalary);
    }

    @Override
    public abstract void userInput(Scanner scan);
}
