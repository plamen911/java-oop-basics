package org.lynxlake._03StaticMembers._01Students;

class Student {
    private String name;
    static int numStudentInstances = 0;

    public Student(String name) {
        this.name = name;
        numStudentInstances++;
    }
}
