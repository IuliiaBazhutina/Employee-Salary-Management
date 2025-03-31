
public class Employee {

    private String firstName;
    private String lastName;
    private String jobTitle;

    public Employee(String firstName, String lastName, String jobTitle) {
        setFirstName(firstName);
        setLastName(lastName);
        setJobTitle(jobTitle);
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getJobTitle() {
        return this.jobTitle;
    }

    public void setFirstName(String fName) {
        if (!fName.equals("")) {
            String capitalizedName = fName.substring(0, 1).toUpperCase() + fName.substring(1).toLowerCase();
            this.firstName = capitalizedName;
        } else {
            this.firstName = "unknown";
        }
    }

    public void setLastName(String lName) {
        if (!lName.equals("")) {
            String capitalizedName = lName.substring(0, 1).toUpperCase() + lName.substring(1).toLowerCase();
            this.lastName = capitalizedName;
        } else {
            this.lastName = "unknown";
        }
    }

    public void setJobTitle(String jobTitle) {
        if (!jobTitle.equals("")) {
            this.jobTitle = jobTitle;
        } else {
            this.jobTitle = "unknown";
        }
    }

    @Override
    public String toString() {
        String message = "" + getFirstName() + " " + getLastName() + " works as " + getJobTitle() + ".";
        return message;
    }

}
