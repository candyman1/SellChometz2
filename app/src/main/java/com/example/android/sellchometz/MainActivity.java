package com.example.android.sellchometz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private SharedPreferences mPrefs;
    private SharedPreferences.Editor mPrefEditor;
    private Context mContext;
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    DrawerLayout drawer;
    ActionBarDrawerToggle toggle;
    NavigationView navigationV;
    Context mcontext=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPrefs= PreferenceManager.getDefaultSharedPreferences(this);
        mPrefEditor=mPrefs.edit();
        mPrefs.edit().clear().apply();
        Button star=(Button)findViewById(R.id.start);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer= (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationV = (NavigationView) findViewById(R.id.nav_view);
        navigationV.setNavigationItemSelectedListener(this);

        star.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                drawer.setDrawerListener(toggle);
                toggle.syncState();
                drawer.openDrawer(navigationV);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        android.app.FragmentManager fragmentManager = getFragmentManager();
        if (id == R.id.nav_first_layout) {
            Intent startIntent = new Intent(MainActivity.this,ShulSignIn.class);
            startActivity(startIntent);
        } else if (id == R.id.nav_second_layout) {
            SharedPreferences prefs = getSharedPreferences("shulemail", MODE_PRIVATE);
            if(!(prefs.getString("shulid","")).equals("")){
            Intent startIntent = new Intent(MainActivity.this,Login.class);
            saveSettings();
            startActivity(startIntent);}
        } else if (id == R.id.nav_fourth_layout) {
            SharedPreferences prefs = getSharedPreferences("shulemail", MODE_PRIVATE);
            if(!((prefs.getString("shulid", "")).equals(""))){
            saveSettings();
            Intent startIntent = new Intent(MainActivity.this,WelcomeBack.class);
            startActivity(startIntent);}

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void saveSettings(){
        //get current date
        TimeZone timeZone = TimeZone.getDefault();
        Date currentTime = Calendar.getInstance(timeZone).getTime();
        String time=currentTime.toString();
        String monthDay=time.substring(4,10);
        String year=time.substring(time.length()-4,time.length());
        String monDayYear=monthDay+", "+year;
        mPrefEditor.putString("date",monDayYear);
        mPrefEditor.apply();
    }

}
