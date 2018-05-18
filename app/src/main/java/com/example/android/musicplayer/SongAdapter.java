package com.example.android.musicplayer;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {
    /**
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context The current context. Used to inflate the layout file.
     * @param songs   A List of songs to display in a list
     */
    SongAdapter(Activity context, ArrayList<Song> songs) {
        super(context, 0, songs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the object located at this position in the list
        Song currentSong = getItem(position);
        assert currentSong != null;

        // Get the album cover and display the image
        ImageView albumCover = listItemView.findViewById(R.id.albumCover);
        albumCover.setImageResource(currentSong.getAlbumCover());

        // Get the song title and display the text
        TextView songTitle = listItemView.findViewById(R.id.songTitle);
        songTitle.setText(currentSong.getSongTitle());

        // Get the song artist and display the text
        TextView songArtist = listItemView.findViewById(R.id.songArtist);
        songArtist.setText(currentSong.getSongArtist());

        // Get the song length and display the text
        TextView songLength = listItemView.findViewById(R.id.songLength);
        songLength.setText(currentSong.getSongLength());

        /* Return the whole list item layout (containing 3 TextViews and an ImageView)
           so that it can be shown in the ListView
         */
        return listItemView;
    }
}
