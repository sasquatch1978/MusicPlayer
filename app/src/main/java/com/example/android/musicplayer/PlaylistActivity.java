package com.example.android.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PlaylistActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playlist);

        // Initialize views and set their listeners.
        initializeViews();
    }

    // Perform action on click.
    public void onClick(View v) {
        switch (v.getId()) {
            // 90's Country playlist
            case R.id.ninetiesCountry:
                Intent ninetiesCountryIntent = new Intent(PlaylistActivity.this, NinetiesCountryActivity.class);
                startActivity(ninetiesCountryIntent);
                // Crossfade the activity transition.
                crossfadeTransition();
                break;

            // Classic Country playlist
            case R.id.classicCountry:
                Intent classicCountryIntent = new Intent(PlaylistActivity.this, ClassicCountryActivity.class);
                startActivity(classicCountryIntent);
                // Crossfade the activity transition.
                crossfadeTransition();
                break;

            // Classic Rock playlist
            case R.id.classicRock:
                Intent classicRockIntent = new Intent(PlaylistActivity.this, ClassicRockActivity.class);
                startActivity(classicRockIntent);
                // Crossfade the activity transition.
                crossfadeTransition();
                break;

            // Newer Music playlist
            case R.id.newerMusic:
                Intent newerMusicIntent = new Intent(PlaylistActivity.this, NewerMusicActivity.class);
                startActivity(newerMusicIntent);
                // Crossfade the activity transition.
                crossfadeTransition();
                break;

            // Random Newer Music playlist
            case R.id.nowPlaying:
                Intent nowPlayingIntent = new Intent(PlaylistActivity.this, NowPlayingActivity.class);
                startActivity(nowPlayingIntent);
                // Crossfade the activity transition.
                crossfadeTransition();
                break;

            default:
                break;
        }
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

    // Identify views and set their listeners.
    private void initializeViews() {
        TextView ninetiesCountry = findViewById(R.id.ninetiesCountry);
        ninetiesCountry.setOnClickListener(this);
        TextView classicCountry = findViewById(R.id.classicCountry);
        classicCountry.setOnClickListener(this);
        TextView classicRock = findViewById(R.id.classicRock);
        classicRock.setOnClickListener(this);
        TextView newerMusic = findViewById(R.id.newerMusic);
        newerMusic.setOnClickListener(this);
        TextView nowPlaying = findViewById(R.id.nowPlaying);
        nowPlaying.setOnClickListener(this);
    }
}
