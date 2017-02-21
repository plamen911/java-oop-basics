// https://judge.softuni.bg/Contests/Practice/Index/226#4
package org.lynxlake._05Inheritance._05OnlineRadioDatabase;

import org.lynxlake._05Inheritance._05OnlineRadioDatabase.exceptions.InvalidSongException;
import org.lynxlake._05Inheritance._05OnlineRadioDatabase.models.Song;
import org.lynxlake._05Inheritance._05OnlineRadioDatabase.models.SongDatabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int inputCount = Integer.parseInt(reader.readLine());
        SongDatabase songDatabase = new SongDatabase();

        for (int i = 0; i < inputCount; i++) {
            String[] inputParams = reader.readLine().trim().split(";");
            String artistName = inputParams[0];
            String songName = inputParams[1];
            String duration = inputParams[2];
            try {
                Song song = new Song(artistName, songName, duration);
                songDatabase.addSong(song);
                System.out.println("Song added.");
            } catch (InvalidSongException ex) {
                System.out.println(ex.getMessage());
            }
        }

        System.out.println(songDatabase);

    }
}
