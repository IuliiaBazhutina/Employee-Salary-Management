
public class Tester {

    public Tester() {

        // Unions from enum class
        Unions PSAC = Unions.PSAC;
        Unions PIPSC = Unions.PIPSC;
        Unions CUPE = Unions.CUPE;

        Employee employee1 = new Employee("", "smith", "sales representative", PSAC);
        Employee employee2 = new Employee("KATE", "MCDONALD", "", PIPSC);

        System.out.println(employee1);
        System.out.println(employee2);

        System.out.println(DeductionsUtility.displayDeductions(CUPE, 10000));
    }

    public static void main(String[] args) {

        Tester test = new Tester();
    }

}
