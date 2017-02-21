package org.lynxlake._05Inheritance._05OnlineRadioDatabase.models;

import org.lynxlake._05Inheritance._05OnlineRadioDatabase.exceptions.*;

public class Song {
    private String artistName;
    private String songName;
    private int seconds;
    private int minutes;

    public Song(String artistName, String songName, String duration) {
        this.setArtistName(artistName);
        this.setSongName(songName);
        this.setDuration(duration);
    }

    public int getSeconds() {
        return seconds;
    }

    public int getMinutes() {
        return minutes;
    }

    private void setArtistName(String artistName) {
        if (artistName == null || artistName.trim().length() < 3 || artistName.trim().length() > 20) {
            throw new InvalidArtistNameException();
        }
        this.artistName = artistName;
    }

    private void setSongName(String songName) {
        if (songName == null || songName.trim().length() < 3 || songName.trim().length() > 30) {
            throw new InvalidSongNameException();
        }
        this.songName = songName;
    }

    private void setSeconds(int seconds) {
        if (seconds < 0 || seconds > 59) {
            throw new InvalidSongSecondsException();
        }
        this.seconds = seconds;
    }

    private void setMinutes(int minutes) {
        if (minutes < 0 || minutes > 14) {
            throw new InvalidSongMinutesException();
        }
        this.minutes = minutes;
    }

    private void setDuration(String duration) {
        String[] durationParams = duration.split(":");
        int minutes;
        int seconds;
        try {
            minutes = Integer.parseInt(durationParams[0]);
            seconds = Integer.parseInt(durationParams[1]);
        } catch (NumberFormatException ex) {
            throw new InvalidSongLengthException();
        }
        this.setMinutes(minutes);
        this.setSeconds(seconds);
    }
}
