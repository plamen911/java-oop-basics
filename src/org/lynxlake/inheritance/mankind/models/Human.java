package org.lynxlake.inheritance.mankind.models;

public class Human {
    private String firstName;
    private String lastName;

    public Human(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    private void setFirstName(String firstName) {
        if (firstName != null && firstName.trim().length() < 4) {
            throw new IllegalArgumentException("Expected length at least 4 symbols!Argument: firstName");
        }
        if (firstName != null && !firstName.matches("^[A-Z].*$")) {
            throw new IllegalArgumentException("Expected upper case letter!Argument: firstName");
        }
        this.firstName = firstName;
    }

    protected void setLastName(String lastName) {
        if (lastName != null && lastName.trim().length() < 3) {
            throw new IllegalArgumentException("Expected length at least 3 symbols!Argument: lastName");
        }
        if (lastName != null && !lastName.matches("^[A-Z].*$")) {
            throw new IllegalArgumentException("Expected upper case letter!Argument: lastName");
        }
        this.lastName = lastName;
    }
}
