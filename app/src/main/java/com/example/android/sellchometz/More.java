package com.example.android.sellchometz;

import android.content.Context;
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
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import static com.example.android.sellchometz.R.id.car;
import static com.example.android.sellchometz.R.id.cooler;
import static com.example.android.sellchometz.R.id.invest;
import static com.example.android.sellchometz.R.id.office;

public class More extends AppCompatActivity {

    private Context mContext;
    private SharedPreferences mPrefs;
    private SharedPreferences.Editor mPrefEditor;
    private EditText edittext;
    private String allStuff;
    private String carS;
    private String investS;
    private String lockerS;
    private String neighborS;
    private String officeS;
    private String coolerS;
    CheckBox oth;
    CheckBox timezone;
    CheckBox cars;
    CheckBox investments;
    CheckBox lockers;
    CheckBox neighbors;
    CheckBox offices;
    CheckBox coolers;
    EditText carE;
    EditText investE;
    EditText lockerE;
    EditText neighborE;
    EditText officeE;
    EditText coolerE;
    ImageView imageview;
    ImageView image2;
    ImageView image3;
    ImageView image4;
    ImageView image5;
    ImageView image6;
    ImageView image7;
    FrameLayout coolerF;
    FrameLayout officeF;
    FrameLayout neighborF;
    FrameLayout carF;
    FrameLayout investF;
    FrameLayout lockerF;
    FrameLayout otherF;
    Button my;
    Button place;
    boolean viter=true;
    boolean further=true;
    boolean go=true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.activity_more);


        mPrefs = PreferenceManager.getDefaultSharedPreferences(mContext);
        mPrefEditor = mPrefs.edit();

       edittext= (EditText) findViewById(R.id.moreInfo);
        timezone=(CheckBox)findViewById(R.id.zone);
        imageview = (ImageView)findViewById(R.id.imageView1);
        image2=(ImageView)findViewById(R.id.imageView2);
        image3=(ImageView)findViewById(R.id.imageView3);
        image4=(ImageView)findViewById(R.id.imageView4);
        image5=(ImageView)findViewById(R.id.imageView5);
        image6=(ImageView)findViewById(R.id.imageView6);
        image7=(ImageView)findViewById(R.id.imageView7);
        coolerF=(FrameLayout)findViewById(R.id.coolerFrame);
        cars=(CheckBox)findViewById(car);
        investments=(CheckBox)findViewById(invest);
        lockers=(CheckBox)findViewById(R.id.locker);
        neighbors=(CheckBox)findViewById(R.id.neighbor);
        oth=(CheckBox)findViewById(R.id.othe);
        offices=(CheckBox)findViewById(office);
        coolers=(CheckBox)findViewById(cooler);
        carE=(EditText)findViewById(R.id.carEd);
        carF=(FrameLayout)findViewById(R.id.carFrame);
        neighborF=(FrameLayout)findViewById(R.id.neighborFrame);
        lockerF=(FrameLayout)findViewById(R.id.lockerFrame);
        officeF=(FrameLayout)findViewById(R.id.officeFrame);
        investE=(EditText)findViewById(R.id.investEd);
        neighborE=(EditText)findViewById(R.id.neighborEd);
        lockerE=(EditText)findViewById(R.id.lockerEd);
        officeE=(EditText)findViewById(R.id.officeEd);
        coolerE=(EditText)findViewById(R.id.coolerEd);
        investF=(FrameLayout)findViewById(R.id.investFrame);
        otherF=(FrameLayout)findViewById(R.id.otherFrame);
        my=(Button)findViewById(R.id.myId);
        place=(Button)findViewById(R.id.plac);



        ImageButton hi = (ImageButton) findViewById(R.id.fab3);

//make boxes visible if checked and if not or unchecked disappear
        investments.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if ( ((CheckBox)v).isChecked() ) {
                    investF.setVisibility(View.VISIBLE);

                }
                else {investF.setVisibility(View.GONE);}
            }
        });
        cars.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if ( ((CheckBox)v).isChecked() ) {
                    carF.setVisibility(View.VISIBLE);

                }
                else {carF.setVisibility(View.GONE);
        }}});
       lockers.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if ( ((CheckBox)v).isChecked() ) {
                    lockerF.setVisibility(View.VISIBLE);

                }
                else {lockerF.setVisibility(View.GONE);}
            }
        });
               neighbors.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if ( ((CheckBox)v).isChecked() ) {
                    neighborF.setVisibility(View.VISIBLE);

                }
                else {neighborF.setVisibility(View.GONE);}
            }
        });
        offices.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if ( ((CheckBox)v).isChecked() ) {
                    officeF.setVisibility(View.VISIBLE);

                }
                else {officeF.setVisibility(View.GONE);}
            }
        });
        coolers.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if ( ((CheckBox)v).isChecked() ) {
                    coolerF.setVisibility(View.VISIBLE);

                }
                else {coolerF.setVisibility(View.GONE);}
            }
        });

        oth.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if ( ((CheckBox)v).isChecked() ) {
                    otherF.setVisibility(View.VISIBLE);

                }
                else {otherF.setVisibility(View.GONE);}
            }
        });



//go to next page
        hi.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {

test();
                if(viter&&further&&go){
                saveSettings();
                Intent startIntent = new Intent(More.this, ChometzProducts.class);


                startActivity(startIntent);}
            }
        });
        //go to previous pages
        my.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {

                saveSettings();
                Intent startIntent = new Intent(More.this, Login.class);


                startActivity(startIntent);
            }
        });
        place.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {

                saveSettings();
                Intent startIntent = new Intent(More.this, Places2.class);


                startActivity(startIntent);
            }
        });
//to delete info with x
        edittext.addTextChangedListener(new TextWatcher() {

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

                edittext.getText().clear();

            }
        });
        investE.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub

                //Show cross button after start typing.
                image3.setVisibility(View.VISIBLE);

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

        image3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                investE.getText().clear();

            }
        });
        investE.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub

                //Show cross button after start typing.
                image3.setVisibility(View.VISIBLE);

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

        image2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                carE.getText().clear();

            }
        });
        lockerE.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub

                //Show cross button after start typing.
                image4.setVisibility(View.VISIBLE);

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

        image4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                lockerE.getText().clear();

            }
        });
        lockerE.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub

                //Show cross button after start typing.
                image4.setVisibility(View.VISIBLE);

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
        neighborE.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub

                //Show cross button after start typing.
                image5.setVisibility(View.VISIBLE);

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

        image5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                neighborE.getText().clear();

            }
        });
        officeE.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub

                //Show cross button after start typing.
                image6.setVisibility(View.VISIBLE);

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

        image6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                officeE.getText().clear();

            }
        });
        coolerE.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub

                //Show cross button after start typing.
                image7.setVisibility(View.VISIBLE);

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

        image7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                coolerE.getText().clear();

            }
        });
    }



    @Override
    protected void onStart() {
        super.onStart();
        loadSettings();
        if(cars.isChecked()){
            carF.setVisibility(View.VISIBLE);
        }else{carF.setVisibility(View.GONE);}
        if(investments.isChecked()){
            investF.setVisibility(View.VISIBLE);
        }else{investF.setVisibility(View.GONE);}
        if(lockers.isChecked()){
            lockerF.setVisibility(View.VISIBLE);
        }else{lockerF.setVisibility(View.GONE);}
        if(neighbors.isChecked()){
            neighborF.setVisibility(View.VISIBLE);
        }else{neighborF.setVisibility(View.GONE);}
        if(offices.isChecked()){
            officeF.setVisibility(View.VISIBLE);
        }else{officeF.setVisibility(View.GONE);}
        if(coolers.isChecked()){
            coolerF.setVisibility(View.VISIBLE);
        }else{coolerF.setVisibility(View.GONE);}
        if(oth.isChecked()){
            otherF.setVisibility(View.VISIBLE);
        }else{otherF.setVisibility(View.GONE);}
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

    private void saveSettings() {
        mPrefEditor.putBoolean("checkZone_checked",
                timezone.isChecked());
        mPrefEditor.putBoolean("car_checked",
                cars.isChecked());
        mPrefEditor.putBoolean("investment_checked",
                investments.isChecked());
        mPrefEditor.putBoolean("locker_checked",
                lockers.isChecked());
        mPrefEditor.putBoolean("neighbor_checked",
                neighbors.isChecked());
        mPrefEditor.putBoolean("office_checked",
                offices.isChecked());
        mPrefEditor.putBoolean("cooler_checked",
               coolers.isChecked());
        mPrefEditor.putBoolean("other_checked",
                oth.isChecked());

        carS=carE.getText().toString().trim();
        mPrefEditor.putString("carList",carS);
       investS=investE.getText().toString().trim();
        mPrefEditor.putString("investList",investS);
        lockerS=lockerE.getText().toString().trim();
        mPrefEditor.putString("lockerList",lockerS);
        neighborS=neighborE.getText().toString().trim();
        mPrefEditor.putString("neighborList",neighborS);
        coolerS=coolerE.getText().toString().trim();
        mPrefEditor.putString("coolerList",coolerS);
        officeS=officeE.getText().toString().trim();
        mPrefEditor.putString("officeList",officeS);
        allStuff = edittext.getText().toString().trim();
        mPrefEditor.putString("longList", allStuff);
        mPrefEditor.apply();
    }
    private void loadSettings() {
        timezone.setChecked(mPrefs.getBoolean("checkZone_checked",false));
        cars.setChecked(mPrefs.getBoolean("car_checked",false));
        investments.setChecked(mPrefs.getBoolean("investment_checked",false));
        lockers.setChecked(mPrefs.getBoolean("locker_checked",false));
        neighbors.setChecked(mPrefs.getBoolean("neighbor_checked",false));
        offices.setChecked(mPrefs.getBoolean("office_checked",false));
        coolers.setChecked(mPrefs.getBoolean("cooler_checked",false));
        oth.setChecked(mPrefs.getBoolean("other_checked",false));

        edittext.setText(mPrefs.getString("longList", ""));
        carE.setText(mPrefs.getString("carList", ""));
        investE.setText(mPrefs.getString("investList", ""));
        lockerE.setText(mPrefs.getString("lockerList", ""));
        neighborE.setText(mPrefs.getString("neighborList", ""));
        coolerE.setText(mPrefs.getString("coolerList", ""));
        officeE.setText(mPrefs.getString("officeList", ""));
    }
    public void test(){
        String carss=carE.getText().toString();
        if(cars.isChecked()&&carss.equals("")||investments.isChecked()&&investE.getText().toString().equals("")
                ||lockers.isChecked()&&lockerE.getText().toString().equals("")||neighbors.isChecked()&&neighborE.getText().toString().equals("")
                ||offices.isChecked()&&officeE.getText().toString().equals("")||coolers.isChecked()&&coolerE.getText().toString().equals("")){
            Toast.makeText(this,"Missing address",
                    Toast.LENGTH_SHORT).show();
            viter=false;
        }else{viter=true;}

        if(oth.isChecked()&&edittext.getText().toString().equals("")){
            Toast.makeText(this,"Incomplete",
                    Toast.LENGTH_SHORT).show();
            further=false;
        }else{further=true;}
        if(timezone.isChecked()&&!cars.isChecked()&&!investments.isChecked()&&!lockers.isChecked()&&!neighbors.isChecked()
                &&!offices.isChecked()&&!coolers.isChecked()&&!oth.isChecked()){
            Toast.makeText(this,"Please write what you are selling.",
                    Toast.LENGTH_SHORT).show();
            go=false;
        }else{go=true;}
    }
}