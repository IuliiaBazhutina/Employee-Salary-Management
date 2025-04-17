/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author danielwang
 */
public class CommissionRates {

    private double salesVolume;
    private double commissionRate;

    // Constructor
    public CommissionRates(double salesVolume, double commissionRate) {
        this.salesVolume = salesVolume;
        this.commissionRate = commissionRate;
    }

    // Getters
    public double getSalesVolume() {
        return salesVolume;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    // Setters
    public void setSalesVolume(double salesVolume) {
        this.salesVolume = salesVolume;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    @Override
    public String toString() {
        return String.format("Sales Volume: $%.2f, Commission Rate: %.2f%%", salesVolume, commissionRate * 100);
    }
}

