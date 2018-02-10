package io.arigateaux;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Scanner scanner;
    public static ArrayList<Album> playlist;
    public static boolean isRunning = false;

    public static void main(String[] args) {

        playlist = new ArrayList<Album>();
        scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        init();
        while (isRunning) {
            switch (input) {
                // exit
                case 0:
                    isRunning = false;
                    break;
                // forward
                case 1:
                    nextSong();
                    break;
                // backward
                case 2:
                    previousSong();
                    break;
                // replay
                case 3:
                    replaySong();
                    break;
                // list
                case 4:
                    listSongs();
                    break;
                default:
                    break;
            }
        }
    }

    public static void init() {
        System.out.println(
                "Please choose an option:\n" +
                "0 - Quit\n" +
                "1 - Next Song\n" +
                "2 - Previous Song\n" +
                "3 - Replay Song\n" +
                "4 - List Songs\n");
    }

    public static void addAlbum(String albumName) {
        Album album = new Album(albumName);
        if (!playlist.contains(album)) {
            playlist.add(album);
        }
    }

    public static void addSong(String albumName, String songName, int duration) {

    }

    public static void nextSong() {

    }

    public static void previousSong() {

    }

    public static void replaySong() {

    }

    public static void listSongs() {

    }

}
