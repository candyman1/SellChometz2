package com.example.android.sellchometz;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.android.sellchometz.data.Check;
import com.example.android.sellchometz.data.ShulInfoContract;

import java.util.ArrayList;

public class Display extends AppCompatActivity {


    private SharedPreferences mPrefs;
    private SharedPreferences.Editor mPrefEditor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_thing);

        mPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        mPrefEditor = mPrefs.edit();


        displayDatabaseInfo();

    }


    private void displayDatabaseInfo() {

        String[] projection = {
                ShulInfoContract.ShulEntry.SHUL_MAIL,
                ShulInfoContract.ShulEntry.SHUL_RABBI
        };
        Cursor cursor = getContentResolver().query(ShulInfoContract.ShulEntry.CONTENT_URI, projection, null, null, null);


        try {
            //  displayView.setText("The data table contains " + cursor.getCount() + " shuls.\n\n");

            int nameColumnIndex = cursor.getColumnIndex(ShulInfoContract.ShulEntry.SHUL_RABBI);
            int passColumnIndex = cursor.getColumnIndex(ShulInfoContract.ShulEntry.SHUL_MAIL);
            ArrayList<Check> places = new ArrayList<>();
            while (cursor.moveToNext()) {

                String currentName = cursor.getString(nameColumnIndex);
                String currentPass = cursor.getString(passColumnIndex);
                places.add(new Check(currentName, currentPass));
                //  rabbiView.setText(currentName);
                //emailView.setText(currentPass);
                //    displayView.append(currentName + "\n");
                //    displayView.append(currentPass + "\n"+"\n");

                PlaceAdapter all = new PlaceAdapter(this, places);
                ListView stuff = (ListView) findViewById(R.id.things);

                stuff.setAdapter(all);

            }
        } finally {
            cursor.close();
        }
    }


}
