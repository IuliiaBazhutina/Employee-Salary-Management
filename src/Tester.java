public class Tester {

    public Tester() {

        // Original employees
        Employee employee1 = new Employee("", "smith", "sales representative");
        Employee employee2 = new Employee("Daniel", "Wang", "");

        System.out.println("=== Employee 1 ===");
        System.out.println(employee1);
        System.out.println("\n=== Employee 2 ===");
        System.out.println(employee2);

        System.out.println("\n=== Deductions Preview for $10,000 Gross Monthly Salary ===");
        System.out.println(DeductionsUtility.displayDeductions(10000));

        // New: Commission-based employee
        Employee employee3 = new Employee("Alice", "Brown", "Sales Representative");

        CommissionRates[] commissionRates = {
            new CommissionRates(0, 0.05),
            new CommissionRates(10000, 0.07),
            new CommissionRates(20000, 0.10)
        };

        double personalSales = 25000;

        CommissionSalary commissionSalary = new CommissionSalary(employee3, personalSales, commissionRates);

        System.out.println("\n=== Employee 3 (Commission Salary) ===");
        System.out.println(commissionSalary); // uses overridden toString()
        System.out.println(commissionSalary.displayDeductions(commissionSalary.getBasicSalary()));
    }

    public static void main(String[] args) {

        Tester test = new Tester();
    }

}
