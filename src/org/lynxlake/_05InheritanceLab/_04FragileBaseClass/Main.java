// https://judge.softuni.bg/Contests/Practice/Index/478#3
package org.lynxlake._05InheritanceLab._04FragileBaseClass;

public class Main {
    public static void main(String[] args) {
        Predator predator = new Predator();
        predator.feedAll(new Food[] {new Food(), new Food()});
        predator.feed(new Food());
        String debug = "";
    }
}
