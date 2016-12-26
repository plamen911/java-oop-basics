package org.lynxlake.staticMembers.uniqueStudentNames;

class Student {
    private String name;

    public Student(String name) {
        this.name = name;
        StudentGroup.students.add(name);
    }
}
