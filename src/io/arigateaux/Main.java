package io.arigateaux;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    private static Scanner scanner;
    private static ArrayList<Album> albumList = new ArrayList<Album>();
    private static int currentSong;

    public static void main(String[] args) {

        Album album = new Album("Test", "Jack");
        album.addSong("Song 1", 168);
        album.addSong("Song 2", 154);
        album.addSong("Song 3", 164);
        album.addSong("Song 4", 178);
        album.addSong("Song 5", 102);
        albumList.add(album);

        album = new Album("Test 2", "Bob");
        album.addSong("Song 1", 156);
        album.addSong("Song 2", 784);
        album.addSong("Song 3", 605);
        album.addSong("Song 4", 111);
        album.addSong("Song 5", 852);
        albumList.add(album);

        LinkedList<Song> playlist = new LinkedList<Song>();
        albumList.get(0).addToPlaylist("Song 2", playlist);
        albumList.get(0).addToPlaylist("Song 4", playlist);
        albumList.get(0).addToPlaylist("Song 8", playlist);
        albumList.get(0).addToPlaylist("Song 3", playlist);
        albumList.get(1).addToPlaylist(2, playlist);
        albumList.get(1).addToPlaylist(4, playlist);
        albumList.get(1).addToPlaylist(8, playlist);
        albumList.get(1).addToPlaylist(3, playlist);

        play(playlist);


    }

    public static void play(LinkedList<Song> playlist) {
        scanner = new Scanner(System.in);
        boolean isRunning = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playlist.listIterator();

        if (playlist.size() == 0) {
            System.out.println("No songs in playlist");
            return;
        } else {
            System.out.println("Now playing: " + listIterator.next().toString());
        }

        while (!isRunning) {
            System.out.println(
                "Please choose an option:\n" +
                "0 - Quit\n" +
                "1 - Next Song\n" +
                "2 - Previous Song\n" +
                "3 - Replay Song\n" +
                "4 - List Songs\n");

            int input = scanner.nextInt();
            scanner.nextLine();

            switch (input) {
                case 0:
                    System.out.println("Playlist complete.");
                    isRunning = false;
                    break;
                // next song
                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing: " + listIterator.next().toString());
                    } else {
                        System.out.println("End of playlist");
                        forward = false;
                    }
                    break;
                // previous song
                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing: " + listIterator.previous().toString());
                    } else {
                        System.out.println("Beginning of playlist");
                        forward = true;
                    }
                    break;
                case 3:
//                    replaySong();
                    break;
                case 4:
//                    listSongs();
                    break;
                default:
                    break;
            }
        }

    }

}
