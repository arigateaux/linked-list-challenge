package io.arigateaux;

import java.util.LinkedList;

public class Album {

    private String albumName;
    private String artistName;
    private LinkedList<Song> songList;

    public Album(String albumName, String artistName) {
        this.songList = new LinkedList<Song>();
        this.albumName = albumName;
        this.artistName = artistName;
    }

    public boolean addSong(String songTitle, int duration) {
        if (findSong(songTitle) == null) {
            this.songList.add(new Song(songTitle, duration));
            return true;
        }
        return false;
    }

    private Song findSong(String songTitle) {
        for (Song getSong : this.songList) {
            if (getSong.getTitle().equals(songTitle)) {
                return getSong;
            }
        }
        return null;
    }

    public boolean addToPlaylist(int trackNumber, LinkedList<Song> playlist) {
        int index = trackNumber - 1;
        if ((index >= 0) && (index <= this.songList.size())) {
            playlist.add(this.songList.get(index));
            return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlaylist(String title, LinkedList<Song> playlist) {
        Song getSong = findSong(title);
        if (getSong != null) {
            playlist.add(getSong);
            return true;
        }
        System.out.println("The song " + title + " is not in this album");
        return false;
    }

}
