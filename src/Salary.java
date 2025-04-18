
import java.util.Scanner;

public interface Salary {
    void userInput(Scanner scan);
    double calculateSalary();
    @Override
    String toString();
}
