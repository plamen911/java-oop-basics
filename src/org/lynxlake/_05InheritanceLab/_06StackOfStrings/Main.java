// https://judge.softuni.bg/Contests/Practice/Index/478#5
package org.lynxlake._05InheritanceLab._06StackOfStrings;

public class Main {
    public static void main(String[] args) {
        StackOfStrings sos = new StackOfStrings();
        sos.push("pesho");
        sos.push("gosho");
        sos.push("mimi");

        System.out.println(sos.pop());
        System.out.println(sos.pop());
        System.out.println(sos.pop());
    }
}
