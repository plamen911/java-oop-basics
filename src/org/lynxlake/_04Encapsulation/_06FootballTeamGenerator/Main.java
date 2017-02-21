// https://judge.softuni.bg/Contests/Practice/Index/221#5
package org.lynxlake._04Encapsulation._06FootballTeamGenerator;

import org.lynxlake._04Encapsulation._06FootballTeamGenerator.models.Player;
import org.lynxlake._04Encapsulation._06FootballTeamGenerator.models.Team;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    private static HashMap<String, Team> teams;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        teams = new HashMap<>();

        while (true) {
            String[] input = reader.readLine().trim().split(";");
            if (input[0].equalsIgnoreCase("END")) {
                break;
            }

            try {
                switch (input[0]) {
                    case "Team":
                        Team team = tryMakeTeam(input);
                        teams.put(team.getName(), team);
                        break;

                    case "Add":
                        tryMakePlayer(input);
                        break;

                    case "Remove":
                        tryRemovePlayer(input);
                        break;

                    case "Rating":
                        double result = getTeamRating(input);
                        System.out.println(String.format("%s - %.0f", input[1], result));
                        break;
                }

            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }

        }

    }

    private static double getTeamRating(String[] input) {
        String teamName = input[1];
        if (!teams.containsKey(teamName)) {
            throw new IllegalArgumentException(String.format("Team %s does not exist.", teamName));
        }

        return teams.get(teamName).getRating();
    }

    private static void tryRemovePlayer(String[] input) {
        String teamName = input[1];
        if (!teams.containsKey(teamName)) {
            throw new IllegalArgumentException(String.format("Team %s does not exist.", teamName));
        }

        String playerName = input[2];
        teams.get(teamName).removePlayer(playerName);
    }

    private static void tryMakePlayer(String[] input) {
        // String name, double endurance, double sprint, double dribble, double passing, double shooting
        String teamName = input[1];
        if (!teams.containsKey(teamName)) {
            throw new IllegalArgumentException(String.format("Team %s does not exist.", teamName));
        }

        String playerName = input[2];
        double endurance = Double.parseDouble(input[3]);
        double sprint = Double.parseDouble(input[4]);
        double dribble = Double.parseDouble(input[5]);
        double passing = Double.parseDouble(input[6]);
        double shooting = Double.parseDouble(input[7]);
        Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
        teams.get(teamName).addPlayer(player);
    }

    private static Team tryMakeTeam(String[] input) {
        String name = input[1];
        return new Team(name);
    }
}
