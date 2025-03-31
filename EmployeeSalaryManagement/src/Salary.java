
import java.util.Scanner;


public interface Salary {

    public void userInput(Scanner scan);

    public double calculateSalary();

    @Override
    public String toString();
}
