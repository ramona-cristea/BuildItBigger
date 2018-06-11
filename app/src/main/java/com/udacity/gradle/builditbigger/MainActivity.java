package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.VisibleForTesting;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.udacity.gradle.showjokelibrary.ShowJokeActivity;


public class MainActivity extends AppCompatActivity implements JokeListener {

    private RelativeLayout loadingIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadingIndicator = findViewById(R.id.loading_indicator_layout);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        return id == R.id.action_settings || super.onOptionsItemSelected(item);

    }

    public void tellJoke(View view) {
        MainActivityFragment fragment = (MainActivityFragment) getSupportFragmentManager().findFragmentByTag("main_fragment");
        if(fragment != null) {
            fragment.askForJoke(this);
        }
    }

    @VisibleForTesting
    @Override
    public void onJokeLoaded(String joke) {
        Intent showJokeIntent = new Intent(this, ShowJokeActivity.class);
        showJokeIntent.putExtra(ShowJokeActivity.EXTRA_KEY_JOKE, joke);
        startActivity(showJokeIntent);
        loadingIndicator.setVisibility(View.GONE);
    }

    @Override
    public void readyForJoke() {
        loadingIndicator.setVisibility(View.VISIBLE);
        new GetJokeAsyncTask(this).execute();
    }
}
