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
        songs.add(new Song(R.drawable.jewel_case, getString(R.string.newerMusicTitleOne), getString(R.string.newerMusicArtistOne), getString(R.string.newerMusicLengthOne)));
        songs.add(new Song(R.drawable.jewel_case, getString(R.string.newerMusicTitleTwo), getString(R.string.newerMusicArtistOne), getString(R.string.newerMusicLengthTwo)));
        songs.add(new Song(R.drawable.jewel_case, getString(R.string.newerMusicTitleThree), getString(R.string.newerMusicArtistTwo), getString(R.string.newerMusicLengthThree)));
        songs.add(new Song(R.drawable.jewel_case, getString(R.string.newerMusicTitleFour), getString(R.string.newerMusicArtistTwo), getString(R.string.newerMusicLengthFour)));
        songs.add(new Song(R.drawable.jewel_case, getString(R.string.newerMusicTitleFive), getString(R.string.newerMusicArtistThree), getString(R.string.newerMusicLengthFive)));
        songs.add(new Song(R.drawable.jewel_case, getString(R.string.newerMusicTitleSix), getString(R.string.newerMusicArtistThree), getString(R.string.newerMusicLengthSix)));
        songs.add(new Song(R.drawable.jewel_case, getString(R.string.newerMusicTitleSeven), getString(R.string.newerMusicArtistThree), getString(R.string.newerMusicLengthSeven)));
        songs.add(new Song(R.drawable.jewel_case, getString(R.string.newerMusicTitleEight), getString(R.string.newerMusicArtistFour), getString(R.string.newrMusicLengthEight)));
        songs.add(new Song(R.drawable.jewel_case, getString(R.string.newerMusicTitleNine), getString(R.string.newrMusicArtistFive), getString(R.string.newerMusicLengthNine)));
        songs.add(new Song(R.drawable.jewel_case, getString(R.string.newerMusicTitleTen), getString(R.string.newerMusicArtistSix), getString(R.string.newerMusicLengthTen)));
        songs.add(new Song(R.drawable.jewel_case, getString(R.string.newerMusicTitleEleven), getString(R.string.newerMusicArtistSix), getString(R.string.newerMusicLengthEleven)));
        songs.add(new Song(R.drawable.jewel_case, getString(R.string.newerMusicTitleTwelve), getString(R.string.newerMusicArtistSeven), getString(R.string.newerMusicLengthTwelve)));
        songs.add(new Song(R.drawable.jewel_case, getString(R.string.newerMusicTitleThirteen), getString(R.string.newerMusicArtistSeven), getString(R.string.newerMusicLengthThirteen)));
        songs.add(new Song(R.drawable.jewel_case, getString(R.string.newerMusicTitleFourteen), getString(R.string.newerMusicArtistEight), getString(R.string.newerMusicLengthFourteen)));
        songs.add(new Song(R.drawable.jewel_case, getString(R.string.newerMusicTitleFifteen), getString(R.string.newerMusicArtistNine), getString(R.string.newerMusicLengthFifteen)));
        songs.add(new Song(R.drawable.jewel_case, getString(R.string.newerMusicTitleSixteen), getString(R.string.newerMusicArtistTen), getString(R.string.newerMusicLengthSixteen)));
        songs.add(new Song(R.drawable.jewel_case, getString(R.string.newerMusicTitleSeventeen), getString(R.string.newerMusicArtistEleven), getString(R.string.newerMusicLengthSeventeen)));
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