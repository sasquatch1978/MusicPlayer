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
        songs.add(new Song(R.drawable.jewel_case, getString(R.string.classicRockTitleOne), getString(R.string.classicRockArtistOne), getString(R.string.classicRockLengthOne)));
        songs.add(new Song(R.drawable.jewel_case, getString(R.string.classicRockTitleTwo), getString(R.string.classicRockArtistOne), getString(R.string.classicRockLengthTwo)));
        songs.add(new Song(R.drawable.jewel_case, getString(R.string.classicRockTitleThree), getString(R.string.classicRockArtistTwo), getString(R.string.classicRockLengthThree)));
        songs.add(new Song(R.drawable.jewel_case, getString(R.string.classicRockTitleFour), getString(R.string.classicRockArtistTwo), getString(R.string.classicRockLengthFour)));
        songs.add(new Song(R.drawable.jewel_case, getString(R.string.classicRockTitleFive), getString(R.string.classicRockArtistThree), getString(R.string.classicRockLengthFive)));
        songs.add(new Song(R.drawable.jewel_case, getString(R.string.classicRockTitleSix), getString(R.string.classicRockArtistFour), getString(R.string.classicRockLengthSix)));
        songs.add(new Song(R.drawable.jewel_case, getString(R.string.classicRockTitleSeven), getString(R.string.classicRockArtistFive), getString(R.string.classicRockLengthSeven)));
        songs.add(new Song(R.drawable.jewel_case, getString(R.string.classicRockTitleEight), getString(R.string.classicRockArtistSix), getString(R.string.classicRockLengthEight)));
        songs.add(new Song(R.drawable.jewel_case, getString(R.string.classicRockTitleNine), getString(R.string.classicRockArtistSix), getString(R.string.classicRockLengthNine)));
        songs.add(new Song(R.drawable.jewel_case, getString(R.string.classicRockTitleTen), getString(R.string.classicRockArtistSeven), getString(R.string.classicRockLengthTen)));
        songs.add(new Song(R.drawable.jewel_case, getString(R.string.classicRockTitleEleven), getString(R.string.classicRockArtistEight), getString(R.string.classicRockLengthEleven)));
        songs.add(new Song(R.drawable.jewel_case, getString(R.string.classicRockTitleTwelve), getString(R.string.classicRockArtistNine), getString(R.string.classicRockLengthTwelve)));
        songs.add(new Song(R.drawable.jewel_case, getString(R.string.classicRockTitleThirteen), getString(R.string.classicRockArtistTen), getString(R.string.classicRockLengthThirteen)));
        songs.add(new Song(R.drawable.jewel_case, getString(R.string.classicRockTitleFourteen), getString(R.string.classicRockArtistEleven), getString(R.string.classicRockLengthFourteen)));
        songs.add(new Song(R.drawable.jewel_case, getString(R.string.classicRockTitleSixteen), getString(R.string.classicRockArtistEleven), getString(R.string.classicRockLengthFifteen)));
        songs.add(new Song(R.drawable.jewel_case, getString(R.string.classicRockTitleSeventeen), getString(R.string.classicRockArtistEleven), getString(R.string.classicRockLengthSixteen)));
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
