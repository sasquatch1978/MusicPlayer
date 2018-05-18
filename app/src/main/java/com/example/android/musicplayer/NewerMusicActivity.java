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

public class NewerMusicActivity extends AppCompatActivity {

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
                Intent nowPlayingIntent = new Intent(NewerMusicActivity.this, NowPlayingActivity.class);
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

    // Create an ArrayList of songs for Newer Music.
    public void createSongList() {
        songs = new ArrayList<>();
        /* Image "jewel_case"
           Source: https://pixabay.com/en/jewel-case-cd-cd-rom-disk-158216/
           Date: 4/14/18
         */
        songs.add(new Song(R.drawable.jewel_case, "Fluorescent Adolescent", "Arctic Monkeys", "2:53"));
        songs.add(new Song(R.drawable.jewel_case, "Leave Before The Lights Come On", "Arctic Monkeys", "3:53"));
        songs.add(new Song(R.drawable.jewel_case, "Weapon Of Choice", "Black Rebel Motorcycle Club", "2:49"));
        songs.add(new Song(R.drawable.jewel_case, "Beat the Devil's Tattoo", "Black Rebel Motorcycle Club", "3:45"));
        songs.add(new Song(R.drawable.jewel_case, "Photograph", "Ed Sheeran", "4:19"));
        songs.add(new Song(R.drawable.jewel_case, "Castle on the Hill", "Ed Sheeran", "4:21"));
        songs.add(new Song(R.drawable.jewel_case, "Shape of You", "Ed Sheeran", "4:53"));
        songs.add(new Song(R.drawable.jewel_case, "HandClap", "Fitz and The Tantrums", "3:13"));
        songs.add(new Song(R.drawable.jewel_case, "Decent Days And Nights", "The Futureheads", "2:32"));
        songs.add(new Song(R.drawable.jewel_case, "Downtown", "Macklemore & Ryan Lewis", "4:52"));
        songs.add(new Song(R.drawable.jewel_case, "Can't Hold Us", "Macklemore & Ryan Lewis", "4:18"));
        songs.add(new Song(R.drawable.jewel_case, "Girls Who Play Guitar", "Maximo Park", "3:12"));
        songs.add(new Song(R.drawable.jewel_case, "Our Velocity", "Maximo Park", "3:20"));
        songs.add(new Song(R.drawable.jewel_case, "Time to Pretend", "MGMT", "4:21"));
        songs.add(new Song(R.drawable.jewel_case, "Say Hey (I Love You)", "Michael Franti & Spearhead", "3:55"));
        songs.add(new Song(R.drawable.jewel_case, "Little Lion Man", "Mumford & Sons", "4:07"));
        songs.add(new Song(R.drawable.jewel_case, "Resistance", "Muse", "5:46"));
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