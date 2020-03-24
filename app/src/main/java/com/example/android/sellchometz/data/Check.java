package com.example.android.sellchometz.data;

/**
 * Created by Home on 5/8/2017.
 */

public class Check {
    private String rabbi;
    private String email;

    public Check(String mRabbi, String mEmail){
        rabbi=mRabbi;
        email=mEmail;
    }
    public String getRabbi(){
        return rabbi;
    }
    public String getEmail(){
        return email;

    }

}
