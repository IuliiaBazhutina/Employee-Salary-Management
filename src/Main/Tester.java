import java.util.Scanner;

public class Tester {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("==== Salary Calculation Program ====");

        // 1. Collect basic employee info
        System.out.print("Enter first name: ");
        String firstName = scan.nextLine();

        System.out.print("Enter last name: ");
        String lastName = scan.nextLine();

        System.out.print("Enter job title: ");
        String jobTitle = scan.nextLine();

        Employee employee = new Employee(firstName, lastName, jobTitle);

        // 2. Choose salary type
        System.out.println("\nSelect salary type:");
        System.out.println("1. Salaried");
        System.out.println("2. Hourly");
        System.out.println("3. Commission");
        System.out.print("Enter option (1-3): ");
        int option = scan.nextInt();
        scan.nextLine(); // consume newline

        AbstractSalary salary = null;

        switch (option) {
            case 1 -> {
                salary = new SalariedSalary(employee, 0, 0);
                salary.userInput(scan);
            }
            case 2 -> {
                salary = new HourlySalary(employee, 0, 0);
                salary.userInput(scan);
            }
            case 3 -> {
                double[][] commissionRates = {
                    {0, 0.05},
                    {10000, 0.07},
                    {20000, 0.10}
                };
                salary = new CommissionSalary(employee, commissionRates);
                salary.userInput(scan);
            }
            default -> {
                System.out.println("Invalid option selected. Program exiting.");
                System.exit(0);
            }
        }

        // 3. Display results
        System.out.println("\n===== Salary Summary =====");
        System.out.println(salary);
        System.out.println(salary.displayDeductions(salary.getBasicSalary()));

        scan.close();
    }
}
