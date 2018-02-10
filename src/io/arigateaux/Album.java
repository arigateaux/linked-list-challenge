package io.arigateaux;

import java.util.LinkedList;

public class Album {

    private LinkedList<Song> songList;
    private String albumName;
    private String songTitle;
    private int duration;

    public Album(String albumName) {
        songList = new LinkedList<Song>();
        this.albumName = albumName;
    }

    public boolean addSongToAlbum(String albumName, String songTitle, int duration) {
        if (findSong(albumName, songTitle) != null) {
            songList.add(new Song(songTitle, duration));
            return true;
        }
        return false;
    }

    private Song findSong(String albumName, String songTitle) {
        for (int i = 0; i <= songList.size(); i++) {
            Song currentSong = songList.get(i);
            if (currentSong.getTitle().equals(songTitle))
                return currentSong;
        }
        return null;
    }

    public String getAlbumName() {
        return albumName;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public int getDuration() {
        return duration;
    }
}
