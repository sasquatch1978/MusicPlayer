package com.example.android.musicplayer;

public class Song {

    private int cover;
    private String title;
    private String artist;
    private String length;

    /**
     * Create a new Song object.
     *
     * @param albumCover is the cover of the album
     * @param songTitle  is the title of the song
     * @param songArtist is the person or group who performs the song
     * @param songLength is the length of the song
     */
    Song(int albumCover, String songTitle, String songArtist, String songLength) {
        cover = albumCover;
        title = songTitle;
        artist = songArtist;
        length = songLength;
    }

    /**
     * Get the title of the song.
     */
    public int getAlbumCover() {
        return cover;
    }

    /**
     * Get the title of the song.
     */
    public String getSongTitle() {
        return title;
    }

    /**
     * Get the person or group who performs the song.
     */
    public String getSongArtist() {
        return artist;
    }

    /**
     * Get the length of the song.
     */
    public String getSongLength() {
        return length;
    }
}
