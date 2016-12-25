package org.lynxlake.definingClasses.opinionPoll;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());

        List<Person> people = new List<Person>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Person> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Person person) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Person> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends Person> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Person get(int index) {
                return null;
            }

            @Override
            public Person set(int index, Person element) {
                return null;
            }

            @Override
            public void add(int index, Person element) {

            }

            @Override
            public Person remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Person> listIterator() {
                return null;
            }

            @Override
            public ListIterator<Person> listIterator(int index) {
                return null;
            }

            @Override
            public List<Person> subList(int fromIndex, int toIndex) {
                return null;
            }
        };

        for (int i = 0; i < n; i++) {
            String[] params = input.nextLine().split(" ");
            String name = params[0];
            int age = Integer.parseInt(params[1]);


        }
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
