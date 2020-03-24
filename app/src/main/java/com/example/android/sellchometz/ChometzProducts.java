package com.example.android.sellchometz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class ChometzProducts extends AppCompatActivity {

    private Context mContext;
    private SharedPreferences mPrefs;
    private SharedPreferences.Editor mPrefEditor;
    private CheckBox ing;
    private CheckBox bake;
    private CheckBox barl;
    private CheckBox beer;
    private CheckBox cerea;
    private CheckBox cond;
    private CheckBox cos;
    private CheckBox cracker;
    private CheckBox froz;
    private CheckBox groc;
    private CheckBox liq;
    private CheckBox med;
    private CheckBox mix;
    private CheckBox noodle;
    private CheckBox oat;
    private CheckBox perfume;
    private CheckBox pet;
    private CheckBox pickle;
    private CheckBox play;
    private CheckBox toil;
    private CheckBox vita;
    private CheckBox wheat;
    private CheckBox utensil;
    private CheckBox appliance;
    private CheckBox baking;
    private CheckBox toy;
    private CheckBox book;
    private CheckBox seforim;
    private CheckBox etc;
    public EditText plus;
    public String add;
    ImageView imageview;
    Button my1;
    Button place1;
    Button more1;
    boolean viter = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.activity_chometz_products);



        mPrefs = PreferenceManager.getDefaultSharedPreferences(mContext);
        mPrefEditor = mPrefs.edit();


        ing = (CheckBox) findViewById(R.id.ingredients);
        bake = (CheckBox) findViewById(R.id.baked_products);
        barl = (CheckBox) findViewById(R.id.barley);
        beer = (CheckBox) findViewById(R.id.beer);
        cerea = (CheckBox) findViewById(R.id.cereal);
        cond = (CheckBox) findViewById(R.id.condiments);
        cos = (CheckBox) findViewById(R.id.cosmetics);
        cracker = (CheckBox) findViewById(R.id.crackers);
        froz = (CheckBox) findViewById(R.id.frozen);
        groc = (CheckBox) findViewById(R.id.groceries);
        liq = (CheckBox) findViewById(R.id.liquor);
        med = (CheckBox) findViewById(R.id.medicine);
        mix = (CheckBox) findViewById(R.id.mixes);
        noodle = (CheckBox) findViewById(R.id.noodle);
        oat = (CheckBox) findViewById(R.id.oatmeal);
        perfume = (CheckBox) findViewById(R.id.perfume);
        pet = (CheckBox) findViewById(R.id.petfood);
        pickle = (CheckBox) findViewById(R.id.pickle);
        play = (CheckBox) findViewById(R.id.playdough);
        toil = (CheckBox) findViewById(R.id.toiletries);
        vita = (CheckBox) findViewById(R.id.vitamin);
        wheat = (CheckBox) findViewById(R.id.wheat);
        utensil = (CheckBox) findViewById(R.id.utensils);
        appliance = (CheckBox) findViewById(R.id.appliances);
        baking = (CheckBox) findViewById(R.id.baking);
        toy = (CheckBox) findViewById(R.id.toys);
        book = (CheckBox) findViewById(R.id.books);
        seforim = (CheckBox) findViewById(R.id.seforim);
        etc = (CheckBox) findViewById(R.id.etc);
        plus = (EditText) findViewById(R.id.also);
        my1 = (Button) findViewById(R.id.myID1);
        place1 = (Button) findViewById(R.id.plac1);
        more1 = (Button) findViewById(R.id.more1);


        ImageButton next = (ImageButton) findViewById(R.id.fab3);

        next.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                test();
                if (viter) {
                    saveSettings();

                    Intent startIntent = new Intent(ChometzProducts.this, Price.class);

                    startActivity(startIntent);
                }
            }
        });
        my1.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                saveSettings();

                Intent startIntent = new Intent(ChometzProducts.this, Login.class);

                startActivity(startIntent);
            }
        });
        place1.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                saveSettings();

                Intent startIntent = new Intent(ChometzProducts.this, Places2.class);

                startActivity(startIntent);
            }
        });
        more1.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                saveSettings();

                Intent startIntent = new Intent(ChometzProducts.this, More.class);

                startActivity(startIntent);
            }
        });
        imageview = (ImageView) findViewById(R.id.imageView1);


        imageview.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                plus.getText().clear();

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


        ing.setChecked(
                mPrefs.getBoolean("checkIng_checked", false));
        bake.setChecked(
                mPrefs.getBoolean("checkBake_checked", false));
        barl.setChecked(
                mPrefs.getBoolean("checkBarl_checked", false));
        beer.setChecked(
                mPrefs.getBoolean("checkBeer_checked", false));
        cerea.setChecked(
                mPrefs.getBoolean("checkCerea_checked", false));
        cond.setChecked(
                mPrefs.getBoolean("checkCond_checked", false));
        cos.setChecked(
                mPrefs.getBoolean("checkCos_checked", false));
        cracker.setChecked(
                mPrefs.getBoolean("checkCracker_checked", false));
        froz.setChecked(
                mPrefs.getBoolean("checkFroz_checked", false));
        groc.setChecked(
                mPrefs.getBoolean("checkGroc_checked", false));
        liq.setChecked(
                mPrefs.getBoolean("checkLiq_checked", false));
        med.setChecked(
                mPrefs.getBoolean("checkMed_checked", false));
        mix.setChecked(
                mPrefs.getBoolean("checkMix_checked", false));
        noodle.setChecked(
                mPrefs.getBoolean("checkNoodle_checked", false));
        oat.setChecked(
                mPrefs.getBoolean("checkOat_checked", false));
        perfume.setChecked(
                mPrefs.getBoolean("checkPerfume_checked", false));
        pet.setChecked(
                mPrefs.getBoolean("checkPet_checked", false));
        pickle.setChecked(
                mPrefs.getBoolean("checkPickle_checked", false));
        play.setChecked(
                mPrefs.getBoolean("checkPlay_checked", false));
        toil.setChecked(
                mPrefs.getBoolean("checkToil_checked", false));
        vita.setChecked(
                mPrefs.getBoolean("checkVita_checked", false));
        wheat.setChecked(
                mPrefs.getBoolean("checkWheat_checked", false));
        utensil.setChecked(
                mPrefs.getBoolean("checkUtensil_checked", false));
        appliance.setChecked(
                mPrefs.getBoolean("checkAppliance_checked", false));
        baking.setChecked(
                mPrefs.getBoolean("checkBaking_checked", false));
        toy.setChecked(
                mPrefs.getBoolean("checkToy_checked", false));
        book.setChecked(
                mPrefs.getBoolean("checkBook_checked", false));
        seforim.setChecked(
                mPrefs.getBoolean("checkSeforim_checked", false));
        etc.setChecked(
                mPrefs.getBoolean("checkEtc_checked", false));
        plus.setText(
                mPrefs.getString("info", ""));


    }

    private void saveSettings() {


        mPrefEditor.putBoolean("checkIng_checked",
                ing.isChecked());
        mPrefEditor.putBoolean("checkBake_checked",
                bake.isChecked());
        mPrefEditor.putBoolean("checkBarl_checked",
                barl.isChecked());
        mPrefEditor.putBoolean("checkBeer_checked",
                beer.isChecked());
        mPrefEditor.putBoolean("checkCerea_checked",
                cerea.isChecked());
        mPrefEditor.putBoolean("checkCond_checked",
                cond.isChecked());
        mPrefEditor.putBoolean("checkCos_checked",
                cos.isChecked());
        mPrefEditor.putBoolean("checkCracker_checked",
                cracker.isChecked());
        mPrefEditor.putBoolean("checkFroz_checked",
                froz.isChecked());
        mPrefEditor.putBoolean("checkGroc_checked",
                groc.isChecked());
        mPrefEditor.putBoolean("checkLiq_checked",
                liq.isChecked());
        mPrefEditor.putBoolean("checkMed_checked",
                med.isChecked());
        mPrefEditor.putBoolean("checkMix_checked",
                mix.isChecked());
        mPrefEditor.putBoolean("checkNoodle_checked",
                noodle.isChecked());
        mPrefEditor.putBoolean("checkOat_checked",
                oat.isChecked());
        mPrefEditor.putBoolean("checkPerfume_checked",
                perfume.isChecked());
        mPrefEditor.putBoolean("checkPet_checked",
                pet.isChecked());
        mPrefEditor.putBoolean("checkPickle_checked",
                pickle.isChecked());
        mPrefEditor.putBoolean("checkPlay_checked",
                play.isChecked());
        mPrefEditor.putBoolean("checkToil_checked",
                toil.isChecked());
        mPrefEditor.putBoolean("checkVita_checked",
                vita.isChecked());
        mPrefEditor.putBoolean("checkWheat_checked",
                wheat.isChecked());
        mPrefEditor.putBoolean("checkUtensil_checked",
                utensil.isChecked());
        mPrefEditor.putBoolean("checkAppliance_checked",
                appliance.isChecked());
        mPrefEditor.putBoolean("checkBaking_checked",
                baking.isChecked());
        mPrefEditor.putBoolean("checkToy_checked",
                toy.isChecked());
        mPrefEditor.putBoolean("checkBook_checked",
                book.isChecked());
        mPrefEditor.putBoolean("checkSeforim_checked",
                seforim.isChecked());
        mPrefEditor.putBoolean("checkEtc_checked",
                etc.isChecked());
        add = plus.getText().toString().trim();
        mPrefEditor.putString("info", add);


        mPrefEditor.apply();

    }

    public void test() {
        if (!ing.isChecked() && !bake.isChecked() && !barl.isChecked() && !beer.isChecked() && !cerea.isChecked()
                && !cond.isChecked() && !cos.isChecked() && !cracker.isChecked() && !froz.isChecked() && !groc.isChecked()
                && !liq.isChecked() && !med.isChecked() && !mix.isChecked() && !noodle.isChecked() && !oat.isChecked()
                && !perfume.isChecked() && !pet.isChecked() && !pickle.isChecked() && !play.isChecked() && !toil.isChecked()
                && !vita.isChecked() && !wheat.isChecked() && !utensil.isChecked() && !appliance.isChecked() && !baking.isChecked()
                && !toy.isChecked() && !book.isChecked() && !seforim.isChecked() && !etc.isChecked() && plus.getText().toString().equals("")) {
            viter = false;
            Toast.makeText(this, "What are you selling?",
                    Toast.LENGTH_SHORT).show();
        } else {
            viter = true;
        }
    }
}
