package com.example.android.sellchometz.data;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Home on 5/9/2017.
 */

public final class AllInfoContract {

    public static final String CONTENT_AUTHORITY = "com.example.android.sellchometz";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_CRACKER = "alot";
    public static final String SHUL_PATH = "tiny";

    public AllInfoContract() {
    }

    public static final class AllEntry implements BaseColumns {

        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_CRACKER);

        public final static String TABLE_NAME = "alot";

        public final static String SHUL_TABLE = "small";

        public final static String SHUL_MAIL = "mail";

        public final static String SHUL_RABBI = "rabbi";

        public final static String PASSWORD = "password";

        public final static String _ID = BaseColumns._ID;

        public final static String FIRST_NAME = "first";

        public final static String LAST_NAME = "last";

        public final static String ADDRESS = "address";

        public final static String CITY = "city";

        public final static String STATE = "state";

        public final static String PHONE = "phone";

        public final static String DATE = "date";

        public final static String ATTIC = "attic";

        public final static String BASEMENT = "basement";

        public final static String BATHCAB = "bathcab";

        public final static String BREAKFRONT = "breakfront";

        public final static String BRIEFCASE = "briefcase";

        public final static String CLOSET = "closet";

        public final static String CRAWL = "crawl";

        public final static String DRAWER = "drawer";

        public final static String FREEZER = "freezer";

        public final static String GARAGE = "garage";

        public final static String GRILL = "grill";

        public final static String KITCAB = "kitcab";

        public final static String LIQUORCAB = "liquorcab";

        public final static String MEDCHEST = "medchest";

        public final static String PANTRY = "pantry";

        public final static String FRIDGE = "fridge";

        public final static String SHED = "shed";

        public final static String STORAGE = "storage";

        public final static String OTHERPLACE = "otherplace";

        public final static String CARBOX = "carbox";

        public final static String CAR = "car";

        public final static String INVESTBOX = "investbox";

        public final static String INVEST = "invest";

        public final static String LOCKERBOX = "lockerbox";

        public final static String LOCKER = "locker";

        public final static String NEIGHBORBOX = "neighborbox";

        public final static String NEIGHBOR = "neighbor";

        public final static String OFFICEBOX = "officebox";

        public final static String OFFICE = "office";

        public final static String FREEZEBOX = "freezebox";

        public final static String FREEZE = "freeze";

        public final static String OTHERBOX = "otherbox";

        public final static String OTTER = "otter";

        public final static String ZONEBOX = "zonebox";

        public final static String BAKINGING = "bakinging";

        public final static String BAKINGPRO = "bakingpro";

        public final static String BARLEY = "barley";

        public final static String BEER = "beer";

        public final static String CEREAL = "cereal";

        public final static String CONDIMENTS = "condiments";

        public final static String COSMETICS = "cosmetics";

        public final static String CRACKERS = "crackers";

        public final static String FROZEN = "frozen";

        public final static String GROCERIES = "groceries";

        public final static String LIQUOR = "liquor";

        public final static String MEDICINE = "medicine";

        public final static String MIXES = "mixes";

        public final static String NOODLE = "noodle";

        public final static String OATMEAL = "oatmeal";

        public final static String PERFUME = "perfume";

        public final static String PET = "pet";

        public final static String PICKLES = "pickles";

        public final static String PLAYDOUGH = "playdough";

        public final static String TOILETRIES = "toiletries";

        public final static String VITAMINS = "vitamins";

        public final static String WHEAT = "wheat";

        public final static String UTENSILS = "utensil";

        public final static String APPLIANCE = "appliance";

        public final static String BAKINGT = "bakingt";

        public final static String TOYS = "toys";

        public final static String BOOKS = "books";

        public final static String SEFORIM = "seforim";

        public final static String ETC = "etc";

        public final static String ALSOINC = "alsoinc";

        public final static String VALUE = "value";

        public final static String STAY = "stay";

        public final static String KEYB = "keyb";

        public final static String COMBB = "combb";

        public final static String KEY = "key";

        public final static String COMB = "comb";

        public final static String FULLBED = "fullbed";

        public final static String EXCLUDEB = "excludeb";

        public final static String EXCLUDE = "exclude";

        public final static String ONLYB = "onlyb";

        public final static String ONLY = "only";


    }


}