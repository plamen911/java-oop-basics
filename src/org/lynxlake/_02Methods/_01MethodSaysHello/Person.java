package org.lynxlake._02Methods._01MethodSaysHello;

class Person {
    private String name;

    public String sayHello(String name) {
        this.name = name;
        return String.format("%s says \"Hello\"!", this.name);
    }
}
