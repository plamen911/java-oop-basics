package org.lynxlake._03StaticMembers._02UniqueStudentNames;

class Student {
    private String name;

    public Student(String name) {
        this.name = name;
        StudentGroup.students.add(name);
    }
}
