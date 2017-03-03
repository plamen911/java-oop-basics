// https://judge.softuni.bg/Contests/Practice/Index/478#4
package org.lynxlake._05InheritanceLab._05RandomArrayList;

public class Main {
    public static void main(String[] args) {
        RandomArrayList randomArrayList = new RandomArrayList();
        randomArrayList.add(1);
        randomArrayList.add("gosho");
        randomArrayList.add(2);

        System.out.println(randomArrayList.getRandomElement());
        System.out.println(randomArrayList.getRandomElement());
        System.out.println(randomArrayList.getRandomElement());
    }
}
