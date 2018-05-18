package com.example.android.musicplayer;

import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class NowPlayingActivity extends AppCompatActivity {

    private Toolbar appToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.now_playing);

        // Identify the view
        appToolbar = findViewById(R.id.appToolbar);

        // Display toolbar with up arrow to access parent activity.
        displayToolbar();
    }

    /* Crossfade the activity transition when switching to the parent activity.
       Reference: https://stackoverflow.com/questions/40882733/custom-activity-transition-when-up-button-is-pressed
       Date: 5/18/18
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
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

    // Crossfade the activity transition.
    public void crossfadeTransition() {
        /* Override the default activity transition.
           Reference: https://stackoverflow.com/questions/18475826/how-to-perform-a-fade-animation-on-activity-transition
           Date: 3/18/18
         */
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        // End referenced code.
    }
}
