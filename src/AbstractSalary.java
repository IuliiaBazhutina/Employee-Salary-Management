/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author danielwang
 */
public abstract class Salary {

    private Employee employee;
    private double basicSalary;

    // Constructor
    public Salary(Employee employee, double basicSalary) {
        this.employee = employee;
        this.basicSalary = basicSalary;
    }

    // Getters
    public Employee getEmployee() {
        return employee;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    // Setters
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    // Abstract methods
    public abstract double calculateSalary();
    public abstract String toString();

    // Private method to calculate deductions from the gross salary
    protected double calculateDeductions(double grossSalary) {
        return DeductionsUtility.calculateDeductions(grossSalary);
    }

    // Optional: display deduction breakdown
    protected String displayDeductions(double grossSalary) {
        return DeductionsUtility.displayDeductions(grossSalary);
    }
}

