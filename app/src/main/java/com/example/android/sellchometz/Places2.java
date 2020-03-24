package com.example.android.sellchometz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import static com.example.android.sellchometz.R.id.otherEdit;

public class Places2 extends AppCompatActivity {


    private ImageButton next;
    private SharedPreferences mPrefs;
    private SharedPreferences.Editor mPrefEditor;
    CheckBox attic;
    CheckBox basement;
    CheckBox BathCab;
    CheckBox breakfront;
    CheckBox briefcases;
    CheckBox closet;
    CheckBox crawl;
    CheckBox drawer;
    CheckBox freezer;
    CheckBox garage;
    CheckBox grill;
    CheckBox kitCab;
    CheckBox liquorCab;
    CheckBox medChest;
    CheckBox pantry;
    CheckBox fridge;
    CheckBox shed;
    CheckBox storage;
    EditText other;

    String theOther;
    String atticS;
    ImageView imageview;
    Button my;
    boolean viter = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places2);



        mPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        mPrefEditor = mPrefs.edit();

        attic = (CheckBox) findViewById(R.id.attic);

        basement = (CheckBox) findViewById(R.id.basement);

        BathCab = (CheckBox) findViewById(R.id.bathcab);
        breakfront = (CheckBox) findViewById(R.id.breakfront);
        briefcases = (CheckBox) findViewById(R.id.briefcase);
        closet = (CheckBox) findViewById(R.id.closet);
        crawl = (CheckBox) findViewById(R.id.crawlspace);
        drawer = (CheckBox) findViewById(R.id.desk);
        freezer = (CheckBox) findViewById(R.id.freezer);
        garage = (CheckBox) findViewById(R.id.garage);
        grill = (CheckBox) findViewById(R.id.grill);
        kitCab = (CheckBox) findViewById(R.id.kitchenCab);
        liquorCab = (CheckBox) findViewById(R.id.liquorCab);
        medChest = (CheckBox) findViewById(R.id.medicineChest);
        pantry = (CheckBox) findViewById(R.id.pantry);
        fridge = (CheckBox) findViewById(R.id.fridge);
        shed = (CheckBox) findViewById(R.id.shed);
        storage = (CheckBox) findViewById(R.id.storage);
        other = (EditText) findViewById(otherEdit);
        imageview = (ImageView) findViewById(R.id.imageView1);
        my = (Button) findViewById(R.id.myI);
        other.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub

                //Show cross button after start typing.
                imageview.setVisibility(View.VISIBLE);

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }
        });

        imageview.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                other.getText().clear();

            }
        });


        next = (ImageButton) findViewById(R.id.fab2);

        my.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {

                saveSettings();
                Intent startIntent = new Intent(Places2.this, Login.class);

                startActivity(startIntent);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                test();
                if (viter) {
                    saveSettings();
                    Intent startIntent = new Intent(Places2.this, More.class);

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
    //save all the info
    private void saveSettings() {
        mPrefEditor.putString("atticS", atticS);

        mPrefEditor.putBoolean("att_checked", attic.isChecked());

        mPrefEditor.putBoolean("base_checked", basement.isChecked());
        mPrefEditor.putBoolean("bath_checked", BathCab.isChecked());
        mPrefEditor.putBoolean("break_checked", breakfront.isChecked());
        mPrefEditor.putBoolean("brief_checked", briefcases.isChecked());
        mPrefEditor.putBoolean("closet_checked", closet.isChecked());
        mPrefEditor.putBoolean("crawl_checked", crawl.isChecked());
        mPrefEditor.putBoolean("drawer_checked", drawer.isChecked());
        mPrefEditor.putBoolean("freezer_checked", freezer.isChecked());
        mPrefEditor.putBoolean("garage_checked", garage.isChecked());
        mPrefEditor.putBoolean("grill_checked", grill.isChecked());
        mPrefEditor.putBoolean("kitCab_checked", kitCab.isChecked());
        mPrefEditor.putBoolean("liquor_checked", liquorCab.isChecked());
        mPrefEditor.putBoolean("medChest_checked", medChest.isChecked());
        mPrefEditor.putBoolean("pantry_checked", pantry.isChecked());
        mPrefEditor.putBoolean("fridge_checked", fridge.isChecked());
        mPrefEditor.putBoolean("shed_checked", shed.isChecked());
        mPrefEditor.putBoolean("storage_checked", storage.isChecked());
        theOther = other.getText().toString().trim();
        mPrefEditor.putString("other", theOther);

        mPrefEditor.apply();
    }

    private void loadSettings() {

        attic.setChecked(mPrefs.getBoolean("att_checked", false));
        basement.setChecked(mPrefs.getBoolean("base_checked", false));
        BathCab.setChecked(mPrefs.getBoolean("bath_checked", false));
        breakfront.setChecked(mPrefs.getBoolean("break_checked", false));
        briefcases.setChecked(mPrefs.getBoolean("brief_checked", false));
        closet.setChecked(mPrefs.getBoolean("closet_checked", false));
        crawl.setChecked(mPrefs.getBoolean("crawl_checked", false));
        drawer.setChecked(mPrefs.getBoolean("drawer_checked", false));
        freezer.setChecked(mPrefs.getBoolean("freezer_checked", false));
        garage.setChecked(mPrefs.getBoolean("garage_checked", false));
        grill.setChecked(mPrefs.getBoolean("grill_checked", false));
        kitCab.setChecked(mPrefs.getBoolean("kitCab_checked", false));
        liquorCab.setChecked(mPrefs.getBoolean("liquor_checked", false));
        medChest.setChecked(mPrefs.getBoolean("medChest_checked", false));
        pantry.setChecked(mPrefs.getBoolean("pantry_checked", false));
        fridge.setChecked(mPrefs.getBoolean("fridge_checked", false));
        shed.setChecked(mPrefs.getBoolean("shed_checked", false));
        storage.setChecked(mPrefs.getBoolean("storage_checked", false));
        other.setText(mPrefs.getString("other", ""));


    }
    //make sure the user put in info
    public void test() {
        if (!attic.isChecked() && !basement.isChecked() && !BathCab.isChecked() && !breakfront.isChecked() && !briefcases.isChecked()
                && !closet.isChecked() && !crawl.isChecked() && !drawer.isChecked() && !freezer.isChecked() && !garage.isChecked()
                && !grill.isChecked() && !kitCab.isChecked() && !liquorCab.isChecked() && !medChest.isChecked() && !pantry.isChecked()
                && !fridge.isChecked() && !shed.isChecked() && !storage.isChecked() && other.getText().toString().equals("")) {
            viter = false;
            Toast.makeText(this, "What are you selling?",
                    Toast.LENGTH_SHORT).show();
        } else {
            viter = true;
        }
    }

}


