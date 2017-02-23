package org.lynxlake._02EncapsulationLab._04FirstAndReserveTeam;

import java.util.*;

public class Team {
    private String name;
    private List<Person> firstTeamPlayers;
    private List<Person> secondTeamPlayers;

    public Team(String name) {
        this.name = name;
        this.firstTeamPlayers = new ArrayList<>();
        this.secondTeamPlayers = new ArrayList<>();
    }

    public void addPlayer(Person person) {
        if (person.getAge() < 40) {
            this.firstTeamPlayers.add(person);
        } else {
            this.secondTeamPlayers.add(person);
        }
    }

    public List<Person> getFirstTeam() {
        return Collections.unmodifiableList(this.firstTeamPlayers);
    }

    public List<Person> getReserveTeam() {
        return Collections.unmodifiableList(this.secondTeamPlayers);
    }
}
