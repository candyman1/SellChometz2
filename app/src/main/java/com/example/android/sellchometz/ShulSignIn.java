package com.example.android.sellchometz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.sellchometz.data.ShulInfoContract;

public class ShulSignIn extends AppCompatActivity {

    ImageButton fab;
    TextView address;
    private Context mContext;
    private SharedPreferences qPrefs;
    private SharedPreferences.Editor qPrefEditor;
    String pass;
   int bob=1;
    String shulmail;
    String rabbiname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.activity_shul_sign_in);
        qPrefs = PreferenceManager.getDefaultSharedPreferences(mContext);
        qPrefEditor = qPrefs.edit();

        address=(TextView)findViewById(R.id.shulSig);
        pass=address.getText().toString();
        fab=(ImageButton)findViewById(R.id.fabShul);
        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                pass=address.getText().toString();
                //type password (7323646571) to be able to add shul and rov
                if(pass.equals("7323646571")){
                    Intent startIntent = new Intent(ShulSignIn.this,AddShuls.class);

                    startActivity(startIntent);}
         // check if current shul is found in database
                else

            {
                displayDatabaseInfo();
            }
        }


    });}

    @Override
    protected void onStart() {
        super.onStart();
        load();
    }


    private void displayDatabaseInfo() {
        Cursor cursor = getContentResolver().query(ShulInfoContract.ShulEntry.CONTENT_URI,null,null,null,null);

        int shulMailColumnIndex = cursor.getColumnIndex(ShulInfoContract.ShulEntry.SHUL_MAIL);
        int rabbiColumnIndex=cursor.getColumnIndex(ShulInfoContract.ShulEntry.SHUL_RABBI);

        try {
            while (cursor.moveToNext()) {


                 shulmail = cursor.getString(shulMailColumnIndex);
                 rabbiname = cursor.getString(rabbiColumnIndex);

                if (shulmail.equals(pass)) {
                    bob=2;
                    Toast.makeText(this, "found",
                            Toast.LENGTH_SHORT).show();
                   save();
                    Intent startIntent = new Intent(ShulSignIn.this,MainActivity.class);

                    startActivity(startIntent);
                }
                }
            if(bob==1){
                Toast.makeText(this, "not found",
                        Toast.LENGTH_SHORT).show();

            }
        }

        finally {
            cursor.close();

        }
    }
    public void save(){
        SharedPreferences.Editor editor = getSharedPreferences("shulemail", MODE_PRIVATE).edit();
        editor.putString("shulid",shulmail);
        editor.putString("rabbiid",rabbiname);

        editor.apply();
    }
    public void load(){

        SharedPreferences prefs = getSharedPreferences("shulemail", MODE_PRIVATE);
        String bill=prefs.getString("shulid","");
        String joe=prefs.getString("rabbiid","");
        address.setText(bill);
    }

    }

