package com.example.android.musicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ClassicRockActivity extends AppCompatActivity {

    private ArrayList<Song> songs;
    private ListView listView;
    private TextView playlistLength;
    private FloatingActionButton play;
    private Toolbar appToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);

        // Identify the views.
        initializeViews();

        // Display toolbar with up arrow to access parent activity.
        displayToolbar();

        // Get the values from the songs ArrayList.
        createSongList();

        // Set text on the TextViews.
        displayPlaylistLength();
        setSongsText();

        // Start the NowPlayingActivity
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nowPlayingIntent = new Intent(ClassicRockActivity.this, NowPlayingActivity.class);
                startActivity(nowPlayingIntent);
                crossfadeTransition();
            }
        });
    }

    /* Crossfade the activity transition when switching to the parent activity.
       Reference: https://stackoverflow.com/questions/40882733/custom-activity-transition-when-up-button-is-pressed
       Date: 5/18/18
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void finish() {
        super.finish();
        crossfadeTransition();
    }
    // End referenced code.

    // Crossfade the activity transition when the back button is pressed.
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        crossfadeTransition();
    }

    // Display toolbar with up arrow to access parent activity.
    public void displayToolbar() {
        // Set the toolbar.
        setSupportActionBar(appToolbar);

        // Get a support ActionBar corresponding to this toolbar.
        ActionBar appToolbar = getSupportActionBar();

        // Enable the Up button and make sure it's not null.
        assert appToolbar != null;
        appToolbar.setDisplayHomeAsUpEnabled(true);
    }

    // Create an ArrayList of songs for Classic Rock.
    public void createSongList() {
        songs = new ArrayList<>();
        /* Image "jewel_case"
           Source: https://pixabay.com/en/jewel-case-cd-cd-rom-disk-158216/
           Date: 4/14/18
         */
        songs.add(new Song(R.drawable.jewel_case, "Dirty Deeds Done Dirt Cheap", "AC/DC", "3:51"));
        songs.add(new Song(R.drawable.jewel_case, "T.N.T", "AC/DC", "3:34"));
        songs.add(new Song(R.drawable.jewel_case, "Here Comes The Sun", "The Beatles", "3:05"));
        songs.add(new Song(R.drawable.jewel_case, "Eleanor Rigby", "The Beatles", "2:06"));
        songs.add(new Song(R.drawable.jewel_case, "Don't Fear The Reaper", "Blue Öyster Cult", "5:08"));
        songs.add(new Song(R.drawable.jewel_case, "I Want You To Want Me", "Cheap Trick", "3:45"));
        songs.add(new Song(R.drawable.jewel_case, "I Fought The Law", "The Clash", "2:43"));
        songs.add(new Song(R.drawable.jewel_case, "Rebel Rebel", "David Bowie", "4:34"));
        songs.add(new Song(R.drawable.jewel_case, "Space Oddity", "David Bowie", "5:16"));
        songs.add(new Song(R.drawable.jewel_case, "Smoke On The Water", "Deep Purple", "5:42"));
        songs.add(new Song(R.drawable.jewel_case, "Riders On The Storm", "The Doors", "7:14"));
        songs.add(new Song(R.drawable.jewel_case, "Rocket Man", "Elton John", "4:41"));
        songs.add(new Song(R.drawable.jewel_case, "Third Time Lucky", "Foghat", "4:12"));
        songs.add(new Song(R.drawable.jewel_case, "Immigrant Song", "Led Zeppelin", "2:26"));
        songs.add(new Song(R.drawable.jewel_case, "Misty Mountain Hop", "Led Zeppelin", "4:38"));
        songs.add(new Song(R.drawable.jewel_case, "Fool In The Rain", "Led Zeppelin", "6:12"));
    }

    // Display number of songs in playlist.
    public void displayPlaylistLength() {
        int numberOfSongs = songs.size();
        playlistLength.setText(getString(R.string.numberOfSongs, String.valueOf(numberOfSongs)));
    }

    // Set the adapter to display songs in array on the TextViews.
    public void setSongsText() {
        SongAdapter adapter = new SongAdapter(this, songs);
        listView.setAdapter(adapter);
    }

    // Crossfade the activity transition.
    public void crossfadeTransition() {
        /* Override the default activity transition.
           Reference: https://stackoverflow.com/questions/18475826/how-to-perform-a-fade-animation-on-activity-transition
           Date: 3/18/18
         */
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        // End referenced code.
    }

    // Identify the views.
    public void initializeViews() {
        appToolbar = findViewById(R.id.appToolbar);
        listView = findViewById(R.id.list);
        playlistLength = findViewById(R.id.playlistLength);
        play = findViewById(R.id.play);
    }
}
