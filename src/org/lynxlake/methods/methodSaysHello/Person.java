package org.lynxlake.methods.methodSaysHello;

class Person {
    private String name;

    public String sayHello(String name) {
        return String.format("%s says Hello!", name);
    }
}
