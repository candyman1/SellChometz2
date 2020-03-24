package com.example.android.sellchometz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.sellchometz.data.Time;
import com.example.android.sellchometz.data.Utils;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class WelcomeBack extends AppCompatActivity {

    private static final String ZMAN_REQUEST_URL =
            "https://610cdd47.ngrok.io/students/";
    private SharedPreferences mPrefs;
    private SharedPreferences.Editor mPrefEditor;

    TextView password;
    ImageButton fab;
    String pass = "";

    String firstN = "";
    String lastN = "";
    String address = "";
    String city = "";
    String state = "";
    String phone = "";

    String atticS = "";

    String baseS = "";
    String bathS = "";
    String breakS = "";
    String briefS = "";
    String closetS = "";
    String crawlS = "";
    String drawerS = "";
    String freezerS = "";
    String garageS = "";
    String grillS = "";
    String kitCabS = "";
    String liquorS = "";
    String medS = "";
    String pantryS = "";
    String fridgeS = "";
    String shedS = "";
    String storageS = "";
    String otherS = "";
    String carBB = "";
    String investBB = "";
    String lockerBB = "";
    String officeBB = "";
    String neighborBB = "";
    String freezerBB = "";
    String otherBB = "";
    String zoneBB = "";
    String bakingI = "";
    String bakingProI = "";
    String barley = "";
    String beer = "";
    String cereal = "";
    String condiments = "";
    String cosmetics = "";
    String crackers = "";
    String frozen = "";
    String grocery = "";
    String liqu = "";
    String meds = "";
    String mix = "";
    String noodle = "";
    String oats = "";
    String perfume = "";
    String pets = "";
    String pickle = "";
    String playd = "";
    String toilet = "";
    String vitamin = "";
    String wheatg = "";
    String utens = "";
    String apply = "";
    String baket = "";
    String toy = "";
    String book = "";
    String sefer = "";
    String et = "";
    String also = "";
    String valu = "";
    String home = "";
    String key = "";
    String combo = "";
    String full = "";
    String exclu = "";
    String just = "";
    String keyS = "";
    String comboS = "";
    String excluS = "";
    String justS = "";
    String baketool = "";
    String carST = "";
    String investST = "";
    String lockerST = "";
    String neighborST = "";
    String officeST = "";
    String freezerST = "";
    String otherST = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_back);


        mPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        mPrefEditor = mPrefs.edit();


        password = (TextView) findViewById(R.id.with);
        pass = password.getText().toString().trim();


        fab = (ImageButton) findViewById(R.id.fab0);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pass = password.getText().toString().trim();
                if (!(pass.equals(""))) {

                    dataBase();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        loadSet();
    }





//receive info from database
    private void dataBase() {
        pass = password.getText().toString().trim();

        ZmanAsyncTask newTask = new ZmanAsyncTask();

        try {
            newTask.execute(ZMAN_REQUEST_URL + pass).get(1000, TimeUnit.MILLISECONDS);
            mPrefEditor.putString("name1", firstN);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }


    }


    private void saveSet() {
        //remove .com from email address
        if (pass.contains(".")) {
            int dot = pass.indexOf(".");
            pass = pass.substring(0, dot);
        }

        mPrefEditor.putString("email", pass);
        mPrefEditor.putString("address", address);
        mPrefEditor.putString("name1", firstN);
        mPrefEditor.putString("name2", lastN);
        mPrefEditor.putString("city", city);
        mPrefEditor.putString("state", state);
        mPrefEditor.putString("phone", phone);

        mPrefEditor.putString("other", otherS);
        mPrefEditor.putString("carList", carST);
        mPrefEditor.putString("investList", investST);
        mPrefEditor.putString("lockerList", lockerST);
        mPrefEditor.putString("neighborList", neighborST);
        mPrefEditor.putString("coolerList", freezerST);
        mPrefEditor.putString("officeList", officeST);
        mPrefEditor.putString("longList", otherST);
        mPrefEditor.putString("info", also);
        mPrefEditor.putString("total", valu);
        mPrefEditor.putString("lookKey", keyS);
        mPrefEditor.putString("code", comboS);
        mPrefEditor.putString("least", justS);
        mPrefEditor.putString("lazy", excluS);
        if (exclu.equals("1")) {
            mPrefEditor.putBoolean("checkEx_checked", true);
        } else {
            mPrefEditor.putBoolean("checkEx_checked", false);
        }
        if (just.equals("1")) {
            mPrefEditor.putBoolean("checkMin_checked", true);
        } else {
            mPrefEditor.putBoolean("checkMin_checked", false);
        }
        if (combo.equals("1")) {
            mPrefEditor.putBoolean("comb_checked", true);
        } else {
            mPrefEditor.putBoolean("comb_checked", false);
        }
        if (full.equals("1")) {
            mPrefEditor.putBoolean("checkAll_checked", true);
        } else {
            mPrefEditor.putBoolean("checkAll_checked", false);
        }
        if (home.equals("1")) {
            mPrefEditor.putBoolean("checkHome_checked", true);
        } else {
            mPrefEditor.putBoolean("checkHome_checked", false);
        }
        if (key.equals("1")) {
            mPrefEditor.putBoolean("checkKey_checked", true);
        } else {
            mPrefEditor.putBoolean("checkKey_checked", false);
        }
        if (sefer.equals("1")) {
            mPrefEditor.putBoolean("checkSeforim_checked", true);
        } else {
            mPrefEditor.putBoolean("checkSeforim_checked", false);
        }
        if (et.equals("1")) {
            mPrefEditor.putBoolean("checkEtc_checked", true);
        } else {
            mPrefEditor.putBoolean("checkEtc_checked", false);
        }
        if (toy.equals("1")) {
            mPrefEditor.putBoolean("checkToy_checked", true);
        } else {
            mPrefEditor.putBoolean("checkToy_checked", false);
        }
        if (book.equals("1")) {
            mPrefEditor.putBoolean("checkBook_checked", true);
        } else {
            mPrefEditor.putBoolean("checkBook_checked", false);
        }
        if (apply.equals("1")) {
            mPrefEditor.putBoolean("checkAppliance_checked", true);
        } else {
            mPrefEditor.putBoolean("checkAppliance_checked", false);
        }
        if (baket.equals("1")) {
            mPrefEditor.putBoolean("checkBaking_checked", true);
        } else {
            mPrefEditor.putBoolean("checkBaking_checked", false);
        }
        if (wheatg.equals("1")) {
            mPrefEditor.putBoolean("checkWheat_checked", true);
        } else {
            mPrefEditor.putBoolean("checkWheat_checked", false);
        }
        if (utens.equals("1")) {
            mPrefEditor.putBoolean("checkUtensil_checked", true);
        } else {
            mPrefEditor.putBoolean("checkUtensil_checked", false);
        }
        if (toilet.equals("1")) {
            mPrefEditor.putBoolean("checkToil_checked", true);
        } else {
            mPrefEditor.putBoolean("checkToil_checked", false);
        }
        if (vitamin.equals("1")) {
            mPrefEditor.putBoolean("checkVita_checked", true);
        } else {
            mPrefEditor.putBoolean("checkVita_checked", false);
        }
        if (pickle.equals("1")) {
            mPrefEditor.putBoolean("checkPickle_checked", true);
        } else {
            mPrefEditor.putBoolean("checkPickle_checked", false);
        }
        if (playd.equals("1")) {
            mPrefEditor.putBoolean("checkPlay_checked", true);
        } else {
            mPrefEditor.putBoolean("checkPlay_checked", false);
        }
        if (perfume.equals("1")) {
            mPrefEditor.putBoolean("checkPerfume_checked", true);
        } else {
            mPrefEditor.putBoolean("checkPerfume_checked", false);
        }
        if (pets.equals("1")) {
            mPrefEditor.putBoolean("checkPet_checked", true);
        } else {
            mPrefEditor.putBoolean("checkPet_checked", false);
        }
        if (noodle.equals("1")) {
            mPrefEditor.putBoolean("checkNoodle_checked", true);
        } else {
            mPrefEditor.putBoolean("checkNoodle_checked", false);
        }
        if (oats.equals("1")) {
            mPrefEditor.putBoolean("checkOat_checked", true);
        } else {
            mPrefEditor.putBoolean("checkOat_checked", false);
        }
        if (meds.equals("1")) {
            mPrefEditor.putBoolean("checkMed_checked", true);
        } else {
            mPrefEditor.putBoolean("checkMed_checked", false);
        }
        if (mix.equals("1")) {
            mPrefEditor.putBoolean("checkMix_checked", true);
        } else {
            mPrefEditor.putBoolean("checkMix_checked", false);
        }
        if (grocery.equals("1")) {
            mPrefEditor.putBoolean("checkGroc_checked", true);
        } else {
            mPrefEditor.putBoolean("checkGroc_checked", false);
        }
        if (liqu.equals("1")) {
            mPrefEditor.putBoolean("checkLiq_checked", true);
        } else {
            mPrefEditor.putBoolean("checkLiq_checked", false);
        }
        if (crackers.equals("1")) {
            mPrefEditor.putBoolean("checkCracker_checked", true);
        } else {
            mPrefEditor.putBoolean("checkCracker_checked", false);
        }
        if (frozen.equals("1")) {
            mPrefEditor.putBoolean("checkFroz_checked", true);
        } else {
            mPrefEditor.putBoolean("checkFroz_checked", false);
        }
        if (condiments.equals("1")) {
            mPrefEditor.putBoolean("checkCond_checked", true);
        } else {
            mPrefEditor.putBoolean("checkCond_checked", false);
        }
        if (cosmetics.equals("1")) {
            mPrefEditor.putBoolean("checkCos_checked", true);
        } else {
            mPrefEditor.putBoolean("checkCos_checked", false);
        }
        if (beer.equals("1")) {
            mPrefEditor.putBoolean("checkBeer_checked", true);
        } else {
            mPrefEditor.putBoolean("checkBeer_checked", false);
        }
        if (cereal.equals("1")) {
            mPrefEditor.putBoolean("checkCerea_checked", true);
        } else {
            mPrefEditor.putBoolean("checkCerea_checked", false);
        }
        if (barley.equals("1")) {
            mPrefEditor.putBoolean("checkBarl_checked", true);
        } else {
            mPrefEditor.putBoolean("checkBarl_checked", false);
        }
        if (bakingI.equals("1")) {
            mPrefEditor.putBoolean("checkIng_checked", true);
        } else {
            mPrefEditor.putBoolean("checkIng_checked", false);
        }

        if (bakingProI.equals("1")) {
            mPrefEditor.putBoolean("checkBake_checked", true);
        } else {
            mPrefEditor.putBoolean("checkBake_checked", false);
        }
        if (carBB.equals("1")) {
            mPrefEditor.putBoolean("car_checked", true);
        } else {
            mPrefEditor.putBoolean("car_checked", false);
        }
        if (investBB.equals("1")) {
            mPrefEditor.putBoolean("investment_checked", true);
        } else {
            mPrefEditor.putBoolean("investment_checked", false);
        }
        if (lockerBB.equals("1")) {
            mPrefEditor.putBoolean("locker_checked", true);
        } else {
            mPrefEditor.putBoolean("locker_checked", false);
        }
        if (neighborBB.equals("1")) {
            mPrefEditor.putBoolean("neighbor_checked", true);
        } else {
            mPrefEditor.putBoolean("neighbor_checked", false);
        }
        if (officeBB.equals("1")) {
            mPrefEditor.putBoolean("office_checked", true);
        } else {
            mPrefEditor.putBoolean("office_checked", false);
        }
        if (freezerBB.equals("1")) {
            mPrefEditor.putBoolean("cooler_checked", true);
        } else {
            mPrefEditor.putBoolean("cooler_checked", false);
        }
        if (otherBB.equals("1")) {
            mPrefEditor.putBoolean("other_checked", true);
        } else {
            mPrefEditor.putBoolean("other_checked", false);
        }
        if (zoneBB.equals("1")) {
            mPrefEditor.putBoolean("checkZone_checked", true);
        } else {
            mPrefEditor.putBoolean("checkZone_checked", false);
        }
        if (atticS.equals("1")) {
            mPrefEditor.putBoolean("att_checked", true);
        } else {
            mPrefEditor.putBoolean("att_checked", false);
        }
        if (baseS.equals("1")) {
            mPrefEditor.putBoolean("base_checked", true);
        } else {
            mPrefEditor.putBoolean("base_checked", false);
        }
        if (breakS.equals("1")) {
            mPrefEditor.putBoolean("break_checked", true);
        } else {
            mPrefEditor.putBoolean("break_checked", false);
        }
        if (bathS.equals("1")) {
            mPrefEditor.putBoolean("bath_checked", true);
        } else {
            mPrefEditor.putBoolean("bath_checked", false);
        }
        if (briefS.equals("1")) {
            mPrefEditor.putBoolean("brief_checked", true);
        } else {
            mPrefEditor.putBoolean("brief_checked", false);
        }
        if (closetS.equals("1")) {
            mPrefEditor.putBoolean("closet_checked", true);
        } else {
            mPrefEditor.putBoolean("closet_checked", false);
        }
        if (crawlS.equals("1")) {
            mPrefEditor.putBoolean("crawl_checked", true);
        } else {
            mPrefEditor.putBoolean("crawl_checked", false);
        }
        if (drawerS.equals("1")) {
            mPrefEditor.putBoolean("drawer_checked", true);
        } else {
            mPrefEditor.putBoolean("drawer_checked", false);
        }
        if (freezerS.equals("1")) {
            mPrefEditor.putBoolean("freezer_checked", true);
        } else {
            mPrefEditor.putBoolean("freezer_checked", false);
        }
        if (garageS.equals("1")) {
            mPrefEditor.putBoolean("garage_checked", true);
        } else {
            mPrefEditor.putBoolean("garage_checked", false);
        }
        if (grillS.equals("1")) {
            mPrefEditor.putBoolean("grill_checked", true);
        } else {
            mPrefEditor.putBoolean("grill_checked", false);
        }
        if (kitCabS.equals("1")) {
            mPrefEditor.putBoolean("kitCab_checked", true);
        } else {
            mPrefEditor.putBoolean("kitCab_checked", false);
        }
        if (liquorS.equals("1")) {
            mPrefEditor.putBoolean("liquor_checked", true);
        } else {
            mPrefEditor.putBoolean("liquor_checked", false);
        }
        if (medS.equals("1")) {
            mPrefEditor.putBoolean("medChest_checked", true);
        } else {
            mPrefEditor.putBoolean("medChest_checked", false);
        }
        if (pantryS.equals("1")) {
            mPrefEditor.putBoolean("pantry_checked", true);
        } else {
            mPrefEditor.putBoolean("pantry_checked", false);
        }
        if (fridgeS.equals("1")) {
            mPrefEditor.putBoolean("fridge_checked", true);
        } else {
            mPrefEditor.putBoolean("fridge_checked", false);
        }
        if (shedS.equals("1")) {
            mPrefEditor.putBoolean("shed_checked", true);
        } else {
            mPrefEditor.putBoolean("shed_checked", false);
        }
        if (storageS.equals("1")) {
            mPrefEditor.putBoolean("storage_checked", true);
        } else {
            mPrefEditor.putBoolean("storage_checked", false);
        }
        if (baketool.equals("1")) {
            mPrefEditor.putBoolean("checkBaking_checked", true);
        } else {
            mPrefEditor.putBoolean("checkBaking_checked", false);
        }


        mPrefEditor.apply();
    }

    private void loadSet() {

        password.setText(mPrefs.getString("pasword", ""));
    }


    private class ZmanAsyncTask extends AsyncTask<String, Void, Time> {

        @Override
        protected Time doInBackground(String... urls) {
            // Don't perform the request if there are no URLs, or the first URL is null.


            if (urls.length < 1 || urls[0] == null) {

                return null;
            }


            // Perform the HTTP request for earthquake data and process the response.
            Time result = Utils.fetchEarthquakeData(urls[0]);

            return result;
        }

        @Override
        protected void onPostExecute(Time result) {


            // If there is no result, do nothing.
            if (result == null) {
                Toast.makeText(getApplicationContext(), "Not found", Toast.LENGTH_SHORT).show();
                return;
            }

            // Update the information displayed to the user.

            updateUi(result);
            if (!(firstN.equals(""))) {
                Toast.makeText(getApplicationContext(), "Welcome back " + firstN, Toast.LENGTH_SHORT).show();
                Intent newIntent = new Intent(WelcomeBack.this, Login.class);
                startActivity(newIntent);
            }


        }


        private void updateUi(Time earthquake) {

            pass = earthquake.id;
            firstN = earthquake.firstName;
            lastN = earthquake.lastName;
            address = earthquake.address;
            city = earthquake.city;
            state = earthquake.state;
            phone = earthquake.phone;
            atticS = earthquake.attic;
            baseS = earthquake.basement;
            breakS = earthquake.breakfront;
            bathS = earthquake.bathCab;
            briefS = earthquake.briefcase;
            closetS = earthquake.closet;
            crawlS = earthquake.crawl;
            drawerS = earthquake.drawer;
            freezerS = earthquake.freezer;
            garageS = earthquake.garage;
            grillS = earthquake.grill;
            kitCabS = earthquake.kitCab;
            liquorS = earthquake.liqCab;
            medS = earthquake.medChest;
            pantryS = earthquake.pantry;
            fridgeS = earthquake.fridge;
            shedS = earthquake.shed;
            storageS = earthquake.storage;
            otherS = earthquake.otherPlace;
            zoneBB = earthquake.zone;
            otherBB = earthquake.otherBox;
            freezerBB = earthquake.fridgeBox;
            officeBB = earthquake.officeBox;
            neighborBB = earthquake.neighborBox;
            lockerBB = earthquake.lockerBox;
            investBB = earthquake.investBox;
            carBB = earthquake.carBox;
            bakingI = earthquake.baking;
            baketool = earthquake.bakingTool;
            carST = earthquake.carAdd;
            investST = earthquake.investAdd;
            lockerST = earthquake.lockerAdd;
            neighborST = earthquake.neighborAdd;
            officeST = earthquake.officeAdd;
            freezerST = earthquake.fridgeAdd;
            otherST = earthquake.otherAdd;
            bakingProI = earthquake.baked;
            barley = earthquake.barley;
            cereal = earthquake.cereal;
            beer = earthquake.beer;
            cosmetics = earthquake.cos;
            condiments = earthquake.cond;
            frozen = earthquake.frozenItem;
            crackers = earthquake.cracker;
            liqu = earthquake.liquor;
            grocery = earthquake.groceries;
            mix = earthquake.mix;
            meds = earthquake.meds;
            oats = earthquake.oatmeal;
            noodle = earthquake.noodle;
            pets = earthquake.petFood;
            perfume = earthquake.perfumes;
            playd = earthquake.playdough;
            pickle = earthquake.pickles;
            vitamin = earthquake.vita;
            toilet = earthquake.toil;
            utens = earthquake.utensil;
            wheatg = earthquake.wheatG;
            baket = earthquake.baked;
            apply = earthquake.appliance;
            book = earthquake.books;
            toy = earthquake.toys;
            et = earthquake.etc;
            sefer = earthquake.seforim;
            key = earthquake.keyBox;
            home = earthquake.home;
            full = earthquake.fullBedika;
            combo = earthquake.combBox;
            just = earthquake.miniBox;
            exclu = earthquake.excludeBox;
            valu = earthquake.value;
            keyS = earthquake.keyAdd;
            excluS = earthquake.excludeAdd;
            comboS = earthquake.combAdd;
            justS = earthquake.miniAdd;
            also = earthquake.include;


            saveSet();

        }


    }
}
