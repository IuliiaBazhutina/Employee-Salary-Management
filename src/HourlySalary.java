public class HourlySalary extends Salary {
    private double hoursWorked;
    private double hourlyRate;

    // Overtime is 1.5x for hours worked over 40
    private static final double OVERTIME_RATE_MULTIPLIER = 1.5;
    // Standard numver of jours before overtime kicks in
    private static final double REGULAR_HOURS = 40.0;

    public HourlySalary(Employee employee, double hoursWorked, double hourlyRate) {
       super(employee, 0); // base salary will be calculate
       this.hoursWorked = hoursWorked; // total hours worked by the employee
       this.hourlyRate = hourlyRate; // Hourly wage rate
    }

    @Override
    public double calculateSalary() {
        // calculate regular hours (maximum 40)
        double regularHours = Math.min(hoursWorked, REGULAR_HOURS);
        // calculate overtime hours (any hours over 40)
        double overtimeHours = Math.max(hoursWorked - REGULAR_HOURS, 0);
        // computes gross salary including overtime pay
        double grossSalary = (regularHours * hourlyRate) + (overtimeHours * hourlyRate * OVERTIME_RATE_MULTIPLIER);

        // Store gross salary in the baseSalary field
        super.setBasicSalary(grossSalary);
        // Return net salary after deductions
        return grossSalary - calculateDeductions(grossSalary);
    }

    /** Returns a formatted string representing the hourly-based employee details, 
     * including their name, job title, hours worked, hourly rate, and net salary
     *  Uses overridden toString() from employee and dynamically calls calculatesSalary()
     * to ensure salary displayed includes deduction calculations */
    
    @Override
    public String toString() {
        return String.format(
            "%s\nType: Hourly Salary\nHours Worked: %.2f\nHourly Rate: $%.2f\nSalary: $%.2f" ,
            getEmployee(). toString(), hoursWorked, hourlyRate, calculateSalary()
        );
    }
}