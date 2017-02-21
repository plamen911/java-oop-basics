package org.lynxlake._04Encapsulation._06FootballTeamGenerator.models;

import java.util.HashMap;

public class Team {
    private String name;
    private HashMap<String, Player> playersByName;

    public Team(String name) {
        this.setName(name);
        this.playersByName = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().length() == 0) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public double getRating() {
        if (this.playersByName.size() == 0) {
            return 0;
        }

        double rating = 0;
        for (Player player: this.playersByName.values()) {
            rating += player.getSkillLevel();
        }
        /*
        for (Map.Entry<String, Player> player: this.playersByName.entrySet()) {
            rating += player.getValue().getSkillLevel();
        }
        */
        return rating / this.playersByName.size();
    }

    public void addPlayer(Player player) {
        if (!this.playersByName.containsKey(player.getName())) {
            this.playersByName.put(player.getName(), player);
        }
    }

    public void removePlayer(String playerName) {
        if (!this.playersByName.containsKey(playerName)) {
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.", playerName, this.name));
        }
        this.playersByName.remove(playerName);
    }
}
