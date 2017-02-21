package org.lynxlake._04Encapsulation._06FootballTeamGenerator.models;

public class Player {
    private String name;
    private double endurance;
    private double sprint;
    private double dribble;
    private double passing;
    private double shooting;

    public Player(String name, double endurance, double sprint, double dribble, double passing, double shooting) {
        this.setName(name);
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);
    }

    public String getName() {
        return name;
    }

    public double getSkillLevel() {
        return (this.endurance + this.sprint + this.dribble + this.passing + shooting) / 5;
    }

    public void setName(String name) {
        if (name == null || name.trim().length() == 0) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    private void setEndurance(double endurance) {
        if (!this.isStatValid(endurance)) {
            throw new IllegalArgumentException("Endurance should be between 0 and 100.");
        }
        this.endurance = endurance;
    }

    private void setSprint(double sprint) {
        if (!this.isStatValid(sprint)) {
            throw new IllegalArgumentException("Spirit should be between 0 and 100.");
        }
        this.sprint = sprint;
    }

    private void setDribble(double dribble) {
        if (!this.isStatValid(dribble)) {
            throw new IllegalArgumentException("Dribble should be between 0 and 100.");
        }
        this.dribble = dribble;
    }

    private void setPassing(double passing) {
        if (!this.isStatValid(passing)) {
            throw new IllegalArgumentException("Passing should be between 0 and 100.");
        }
        this.passing = passing;
    }

    private void setShooting(double shooting) {
        if (!this.isStatValid(shooting)) {
            throw new IllegalArgumentException("Shooting should be between 0 and 100.");
        }
        this.shooting = shooting;
    }

    private boolean isStatValid(double stat) {
        return stat >= 0 && stat <= 100;
    }
}
