package com.udacity.gradle.showjokelibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ShowJokeActivity extends AppCompatActivity {

    public static final String EXTRA_KEY_JOKE ="joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_joke);

        if(getIntent() != null && getIntent().hasExtra(EXTRA_KEY_JOKE)) {
            TextView textJoke = findViewById(R.id.text_joke);
            textJoke.setText(getIntent().getStringExtra(EXTRA_KEY_JOKE));
        }
        else {
            Log.v("ShowJokeActivity", "No joke provided");
            finish();
        }
    }
}
