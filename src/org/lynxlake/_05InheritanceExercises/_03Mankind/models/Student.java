package org.lynxlake._05InheritanceExercises._03Mankind.models;

public class Student extends Human {
    private String facultyNumber;

    public Student(String firstName, String lastName, String facultyNumber) {
        super(firstName, lastName);
        this.setFacultyNumber(facultyNumber);
    }

    private void setFacultyNumber(String facultyNumber) {
        if (facultyNumber == null || facultyNumber.trim().length() < 5 || facultyNumber.trim().length() > 10) {
            throw new IllegalArgumentException("Invalid faculty number!");
        }
        this.facultyNumber = facultyNumber;
    }

    @Override
    public String toString() {
        return String.format("First Name: %s%nLast Name: %s%nFaculty number: %s",
                this.getFirstName(), this.getLastName(), this.facultyNumber);
    }
}
