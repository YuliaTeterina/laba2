public class Name {
    private String lastName;
    private String firstName;
    private String middleName;

    public Name(String lastName, String firstName, String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }

    public Name(String lastName, String firstName) {
        this(lastName, firstName, null);
    }

    public Name(String firstName) {
        this(null, firstName, null);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Override
    public String toString() {
        String result = "";

        if (lastName != null && !lastName.isEmpty()) {
            result += lastName;
        }

        if (firstName != null && !firstName.isEmpty()) {
            if (!result.isEmpty()) {
                result += " ";
            }
            result += firstName;
        }

        if (middleName != null && !middleName.isEmpty()) {
            if (!result.isEmpty()) {
                result += " ";
            }
            result += middleName;
        }
        return result;
    }
}