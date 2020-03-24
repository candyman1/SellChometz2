package com.example.android.sellchometz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Restart extends AppCompatActivity {

    private Context mContext;
    private SharedPreferences mPrefs;
    private SharedPreferences.Editor mPrefEditor;
    private Button user;
    private Button review;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.activity_restart);

        mPrefs = PreferenceManager.getDefaultSharedPreferences(mContext);
        mPrefEditor = mPrefs.edit();

        user = (Button) findViewById(R.id.user);
        review = (Button) findViewById(R.id.review);
        //delete info and start again
        user.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                mPrefs.edit().clear().apply();
                Intent startIntent = new Intent(Restart.this, MainActivity.class);
                startActivity(startIntent);
            }
        });
        //check over info
        review.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Intent startIntent = new Intent(Restart.this, Login.class);
                startActivity(startIntent);
            }
        });
    }
}
