package org.lynxlake.methods.oldestFamilyMember;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Family {
    private List<Person> people;

    public Family(List<Person> people) {
        this.people = people;
    }

    public Family() {
        this(new ArrayList<>());
    }

    public void addFamilyMember(Person member) {
        this.people.add(member);
    }

    public Person getOldestMember() {
        Collections.sort(people);
        return people.get(0);
    }
}