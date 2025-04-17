/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author danielwang
 */
import java.util.Arrays;

public class CommissionSalary extends Salary {

    private double personalSales;
    private CommissionRates[] commissionRates;

    // Constructor
    public CommissionSalary(Employee employee, double personalSales, CommissionRates[] commissionRates) {
        super(employee, 0); // baseSalary set to 0 initially; calculated later
        this.personalSales = personalSales;
        this.commissionRates = commissionRates;
    }

    // Getters and setters
    public double getPersonalSales() {
        return personalSales;
    }

    public void setPersonalSales(double personalSales) {
        this.personalSales = personalSales;
    }

    public CommissionRates[] getCommissionRates() {
        return commissionRates;
    }

    public void setCommissionRates(CommissionRates[] commissionRates) {
        this.commissionRates = commissionRates;
    }

    // Calculates gross commission salary before deductions
    @Override
    public double calculateSalary() {
        double grossSalary = 0;

        for (CommissionRates rate : commissionRates) {
            if (personalSales > rate.getSalesVolume()) {
                grossSalary = personalSales * rate.getCommissionRate(); // Apply matching rate
            }
        }

        // Save it in baseSalary field
        super.setBasicSalary(grossSalary);

        // Apply deductions
        return grossSalary - DeductionsUtility.calculateDeductions(grossSalary);
    }

    @Override
    public String toString() {
        return String.format(
            "%s\nType: Commission-based Salary\nPersonal Sales: $%.2f\nSalary: $%.2f",
            getEmployee().toString(), personalSales, calculateSalary()
        );
    }
}

