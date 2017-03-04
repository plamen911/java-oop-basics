package org.lynxlake._05InheritanceExercises._05OnlineRadioDatabase.models;

public class SongDatabase {
    private int songCount;
    private long durationInSeconds;

    public SongDatabase() {

    }

    public void addSong(Song song) {
        this.songCount++;
        long duration = song.getSeconds() + song.getMinutes() * 60;
        this.durationInSeconds += duration;
    }

    @Override
    public String toString() {
        long totalTime = this.durationInSeconds;
        long hours = totalTime / 3600;
        totalTime %= 3600;
        long minutes = totalTime / 60;
        totalTime %= 60;
        long seconds = totalTime;

        String timeStr = String.format("%dh %dm %ds", hours, minutes, seconds);
        String output = String.format("Songs added: %d%nPlaylist length: %s", this.songCount, timeStr);

        return output;
    }
}
