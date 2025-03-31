
public class Tester {

    public Tester() {

//        Employee employee1 = new Employee("john", "smith", "sales representative");
//        Employee employee2 = new Employee("KATE", "MCDONALD", "");
//
//        System.out.println(employee1);
//        System.out.println(employee2);
        
        System.out.println(DeductionsUtility.calculateIncTaxFed(10000));
        System.out.println(DeductionsUtility.calculateIncTaxProv(10000));
    }

    public static void main(String[] args) {

        Tester test = new Tester();
    }

}
