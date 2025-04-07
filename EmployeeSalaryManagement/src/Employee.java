
public class Employee {

    private String firstName;
    private String lastName;
    private String jobTitle;
 
    // constructor
    public Employee(String firstName, String lastName, String jobTitle) {
        setFirstName(firstName);
        setLastName(lastName);
        setJobTitle(jobTitle);
    }

    // getters
    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getJobTitle() {
        return this.jobTitle;
    }

    // setters
    public void setFirstName(String fName) {
        String capitalizedName;
        try {
            // attempt to capitalize the first letter and make the rest lowercase
            capitalizedName = fName.substring(0, 1).toUpperCase() + fName.substring(1).toLowerCase();
        } catch (Exception e) {
            // if an exception occurs, set name "Unknown"
            capitalizedName = "Unknown";
        }
        // set capitalized name or "Unknown" in case of exception
        this.firstName = capitalizedName;
    }

    public void setLastName(String lName) {
        String capitalizedName;
        try {
            // attempt to capitalize the first letter and make the rest lowercase
            capitalizedName = lName.substring(0, 1).toUpperCase() + lName.substring(1).toLowerCase();
        } catch (Exception e) {
            // if an exception occurs, set name "Unknown"
            capitalizedName = "Unknown";
        }
        // set capitalized name or "Unknown" in case of exception
        this.lastName = capitalizedName;
    }

    public void setJobTitle(String jobTitle) {
        // set job title or "Unknown" in case of empty String
        this.jobTitle = (jobTitle.equals("")) ? "Unknown" : jobTitle;
    }

    // toString
    @Override
    public String toString() {
        String message = "" + getFirstName() + " " + getLastName() + " works as " + getJobTitle() + ".";
        return message;
    }
}
