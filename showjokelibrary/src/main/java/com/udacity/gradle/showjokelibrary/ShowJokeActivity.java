package com.udacity.gradle.showjokelibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ShowJokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_joke);

        if(getIntent() != null && getIntent().hasExtra("joke_content")) {
            TextView textJoke = findViewById(R.id.text_joke);
            textJoke.setText(getIntent().getStringExtra("joke_content"));
        }
        else {
            Log.v("ShowJokeActivity", "No joke provided");
            finish();
        }
    }
}
