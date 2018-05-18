package com.example.android.musicplayer;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NinetiesCountryActivity extends AppCompatActivity {

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
                Intent nowPlayingIntent = new Intent(NinetiesCountryActivity.this, NowPlayingActivity.class);
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

    // Create an ArrayList of songs for 90's Country.
    public void createSongList() {
        songs = new ArrayList<>();
        /* Image "jewel_case"
           Source: https://pixabay.com/en/jewel-case-cd-cd-rom-disk-158216/
           Date: 4/14/18
         */
        songs.add(new Song(R.drawable.jewel_case, "Don't Rock the Jukebox", "Alan Jackson", "2:51"));
        songs.add(new Song(R.drawable.jewel_case, "Chattahoochee", "Alan Jackson", "2:28"));
        songs.add(new Song(R.drawable.jewel_case, "Brand New Man", "Brooks & Dunn", "2:58"));
        songs.add(new Song(R.drawable.jewel_case, "Boot Scootin' Boogie", "Brooks & Dunn", "3:17"));
        songs.add(new Song(R.drawable.jewel_case, "Two Of A Kind, Workin' On A Full House", "Garth Brooks", "2:33"));
        songs.add(new Song(R.drawable.jewel_case, "The River", "Garth Brooks", "4:29"));
        songs.add(new Song(R.drawable.jewel_case, "Easy Come, Easy Go", "George Strait", "3:04"));
        songs.add(new Song(R.drawable.jewel_case, "Should've Been A Cowboy", "Toby Keith", "3:31"));
        songs.add(new Song(R.drawable.jewel_case, "How Do You Like Me Now?!", "Toby Keith", "3:29"));
    }

    // Display number of songs in playlist..
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
