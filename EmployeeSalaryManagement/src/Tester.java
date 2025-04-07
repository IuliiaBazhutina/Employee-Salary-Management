
public class Tester {

    public Tester() {

        Employee employee1 = new Employee("", "smith", "sales representative");
        Employee employee2 = new Employee("KATE", "MCDONALD", "");

        System.out.println(employee1);
        System.out.println(employee2);

        System.out.println(DeductionsUtility.displayDeductions(10000));
    }

    public static void main(String[] args) {

        Tester test = new Tester();
    }

}
