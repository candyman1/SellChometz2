package com.example.android.sellchometz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.sellchometz.R.layout.activity_login;


public class Login extends AppCompatActivity {

    private Button go;
    private Button load;
    private ImageButton next;

    private SharedPreferences mPrefs;
    private SharedPreferences.Editor mPrefEditor;
    public String word;
    TextView pass;
    TextView first;
    TextView last;
    TextView city;
    TextView state;
    TextView add;
    TextView phone;
    TextView date;
    String homeAdd = "";
    String ePass;
    String nameFirst = "";
    String nameLast = "";
    String theCity = "";
    String theState = "";
    String thePhone = "";
    String theDate = "";
    String dataBase;
    String passW;
    int jim = 0;
    String value;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_login);


        mPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        mPrefEditor = mPrefs.edit();


        first = (TextView) findViewById(R.id.first_name);


        last = (TextView) findViewById(R.id.last_name);


        add = (TextView) findViewById(R.id.address);


        pass = (TextView) findViewById(R.id.email);
        pass.setText(mPrefs.getString("email", ""));

        city = (TextView) findViewById(R.id.city);
        city.setText(mPrefs.getString("city", ""));

        state = (TextView) findViewById(R.id.state);
        state.setText(mPrefs.getString("state", ""));

        phone = (TextView) findViewById(R.id.phone);
        phone.setText(mPrefs.getString("phone", ""));

        date = (TextView) findViewById(R.id.date);
        date.setText(mPrefs.getString("date", ""));


        next = (ImageButton) findViewById(R.id.fab);

        passW = pass.getText().toString().trim();

//fab button to go to Place2Activity
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //test if all fields are entered
                test();
                if (jim == 0) {

                    saveSettings();
                    Intent startIntent = new Intent(Login.this, Places2.class);
                    startActivity(startIntent);
                }
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        loadSettings();


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        saveSettings();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        saveSettings();
    }


    private void loadSettings() {

        first.setText(mPrefs.getString("name1", ""));
        last.setText(mPrefs.getString("name2", ""));
        add.setText(mPrefs.getString("address", ""));
        pass.setText(mPrefs.getString("email", ""));
        city.setText(mPrefs.getString("city", ""));
        state.setText(mPrefs.getString("state", ""));
        phone.setText(mPrefs.getString("phone", ""));
        date.setText(mPrefs.getString("date", ""));


    }


    private void saveSettings() {
        nameFirst = first.getText().toString().trim();
        mPrefEditor.putString("name1", nameFirst);
        nameLast = last.getText().toString().trim();
        mPrefEditor.putString("name2", nameLast);
        homeAdd = add.getText().toString().trim();
        mPrefEditor.putString("address", homeAdd);
        ePass = pass.getText().toString().trim();
        if (ePass.contains(".")) {
            int dot = ePass.indexOf(".");
            ePass = ePass.substring(0, dot);

        }

        mPrefEditor.putString("email", ePass);
        theCity = city.getText().toString().trim();
        mPrefEditor.putString("city", theCity);
        theState = state.getText().toString().trim();
        mPrefEditor.putString("state", theState);
        thePhone = phone.getText().toString().trim();
        mPrefEditor.putString("phone", thePhone);
        theDate = date.getText().toString().trim();
        mPrefEditor.putString("date", theDate);

        mPrefEditor.apply();
    }


    public void test() {
        String nameFirst = first.getText().toString().trim();
        String nameLast = last.getText().toString().trim();
        String homeAdd = add.getText().toString().trim();
        String mail = pass.getText().toString().trim();
        String cityS = city.getText().toString().trim();
        String stateS = state.getText().toString().trim();
        String phoneS = phone.getText().toString().trim();
        String dateS = date.getText().toString().trim();
        String n = ".*[0-9].*";
        String a = ".*[a-zA-Z].*";
        if (nameFirst.equals("") || nameLast.equals("") || homeAdd.equals("") || mail.equals("") || cityS.equals("") || stateS.equals("")
                || phoneS.equals("") || dateS.equals("")) {
            Toast.makeText(this, "All fields required.",
                    Toast.LENGTH_SHORT).show();
            jim = 1;
        } else if (!(homeAdd.matches(n)) || (!(homeAdd.matches(a)))) {
            Toast.makeText(this, "Invalid address",
                    Toast.LENGTH_SHORT).show();
            jim = 1;
        } else {
            jim = 0;
        }
    }


}






