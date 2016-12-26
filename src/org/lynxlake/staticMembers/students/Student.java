package org.lynxlake.staticMembers.students;

class Student {
    private String name;
    static int numStudentInstances = 0;

    public Student(String name) {
        this.name = name;
        numStudentInstances++;
    }
}
