package com.example.android.sellchometz.data;

import android.net.Uri;

/**
 * Created by Tatty on 9/12/2017.
 */

public class ShulInfoContract {
    public static final String CONTENT_AUTHORITY = "com.example.android.sellchom";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String SHUL_PATH = "tiny";
    public ShulInfoContract(){

    }
    public static final class ShulEntry{
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, SHUL_PATH);


        public final static String SHUL_TABLE = "small";

        public final static String SHUL_MAIL = "mail";

        public final static String SHUL_RABBI = "rabbi";
    }
}
