package com.example.android.sellchometz.data;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * Created by Tatty on 2/8/2018.
 */

public final class Utils {
    public static final String LOG_TAG = Utils.class.getSimpleName();


    private static URL createUrl(String stringUrl) {
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Error with creating URL ", e);
        }
        return url;
    }

    public static Time fetchEarthquakeData(String requestUrl) {
        // Create URL object
        URL url = createUrl(requestUrl);

        // Perform HTTP request to the URL and receive a JSON response back
        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Error closing input stream", e);
        }

        // Extract relevant fields from the JSON response and create an {@link Event} object
        Time earthquake = extractFeatureFromJson(jsonResponse);

        // Return the {@link Event}
        return earthquake;
    }

    /**
     * Make an HTTP request to the given URL and return a String as the response.
     */
    private static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";

        // If the URL is null, then return early.
        if (url == null) {
            return jsonResponse;
        }

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            // If the request was successful (response code 200),
            // then read the input stream and parse the response.
            if (urlConnection.getResponseCode() == 200) {

                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);

            } else {
                Log.e(LOG_TAG, "Error response code: " + urlConnection.getResponseCode());

            }
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem retrieving the earthquake JSON results.", e);

        } finally {
            if (urlConnection != null) {

                urlConnection.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return jsonResponse;
    }


    /**
     * Convert the {@link InputStream} into a String which contains the
     * whole JSON response from the server.
     */
    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }

    /**
     * Return an {@link Time} object by parsing out information
     * about the first earthquake from the input earthquakeJSON string.
     */
    private static Time extractFeatureFromJson(String earthquakeJSON) {
        // If the JSON string is empty or null, then return early.
        if (TextUtils.isEmpty(earthquakeJSON)) {
            return null;
        }

        try {

            JSONObject jsonObj = new JSONObject(earthquakeJSON);

            String id1 = jsonObj.getString("id");
            String firstName1 = jsonObj.getString("firstName");
            String lastName1 = jsonObj.getString("lastName");
            String address1 = jsonObj.getString("address");
            String city1 = jsonObj.getString("city");
            String state1 = jsonObj.getString("state");
            String phone1 = jsonObj.getString("phone");
            String attic1 = jsonObj.getString("attic");
            String basement1 = jsonObj.getString("basement");
            String bathCab1 = jsonObj.getString("bathCab");
            String breakfront1 = jsonObj.getString("breakfront");
            String briefcase1 = jsonObj.getString("briefcase");
            String closet1 = jsonObj.getString("closet");
            String crawl1 = jsonObj.getString("crawl");
            String drawer1 = jsonObj.getString("drawer");
            String freezer1 = jsonObj.getString("freezer");
            String garage1 = jsonObj.getString("garage");
            String grill1 = jsonObj.getString("grill");
            String kitCab1 = jsonObj.getString("kitCab");
            String liqCab1 = jsonObj.getString("liqCab");
            String medChest1 = jsonObj.getString("medChest");
            String pantry1 = jsonObj.getString("pantry");
            String fridge1 = jsonObj.getString("fridge");
            String shed1 = jsonObj.getString("shed");
            String storage1 = jsonObj.getString("storage");
            String otherPlace1 = jsonObj.getString("otherPlace");
            String carBox1 = jsonObj.getString("carBox");
            String carAdd1 = jsonObj.getString("carAdd");
            String investBox1 = jsonObj.getString("investBox");
            String investAdd1 = jsonObj.getString("investAdd");
            String lockerBox1 = jsonObj.getString("lockerBox");
            String lockerAdd1 = jsonObj.getString("lockerAdd");
            String neighborBox1 = jsonObj.getString("neighborBox");
            String neighborAdd1 = jsonObj.getString("neighborAdd");
            String officeBox1 = jsonObj.getString("officeBox");
            String officeAdd1 = jsonObj.getString("officeAdd");
            String fridgeBox1 = jsonObj.getString("fridgeBox");
            String fridgeAdd1 = jsonObj.getString("fridgeAdd");
            String otherBox1 = jsonObj.getString("otherBox");
            String otherAdd1 = jsonObj.getString("otherAdd");
            String zone1 = jsonObj.getString("zone");
            String baking1 = jsonObj.getString("baking");
            String baked1 = jsonObj.getString("baked");
            String barley1 = jsonObj.getString("barley");
            String beer1 = jsonObj.getString("beer");
            String cereal1 = jsonObj.getString("cereal");
            String cond1 = jsonObj.getString("cond");
            String cos1 = jsonObj.getString("cos");
            String cracker1 = jsonObj.getString("cracker");
            String frozenItem1 = jsonObj.getString("frozenItem");
            String groceries1 = jsonObj.getString("groceries");
            String liquor1 = jsonObj.getString("liquor");
            String meds1 = jsonObj.getString("meds");
            String mix1 = jsonObj.getString("mix");
            String noodle1 = jsonObj.getString("noodle");
            String oatmeal1 = jsonObj.getString("oatmeal");
            String perfumes1 = jsonObj.getString("perfumes");
            String petFood1 = jsonObj.getString("petFood");
            String pickles1 = jsonObj.getString("pickles");
            String playdough1 = jsonObj.getString("playdough");
            String toil1 = jsonObj.getString("toil");
            String vita1 = jsonObj.getString("vita");
            String wheatG1 = jsonObj.getString("wheatG");
            String utensil1 = jsonObj.getString("utensil");
            String appliance1 = jsonObj.getString("appliance");
            String bakingTool1 = jsonObj.getString("bakingTool");
            String toys1 = jsonObj.getString("toys");
            String books1 = jsonObj.getString("books");
            String seforim1 = jsonObj.getString("seforim");
            String etc1 = jsonObj.getString("etc");
            String include1 = jsonObj.getString("include");
            String value1 = jsonObj.getString("value");
            String home1 = jsonObj.getString("home");
            String keyBox1 = jsonObj.getString("keyBox");
            String ketAdd1 = jsonObj.getString("keyAdd");
            String combBox1 = jsonObj.getString("combBox");
            String combAdd1 = jsonObj.getString("combAdd");
            String fullBedika1 = jsonObj.getString("fullBedika");
            String exculeBox1 = jsonObj.getString("excludeBox");
            String excludeAdd1 = jsonObj.getString("excludeAdd");
            String miniBox1 = jsonObj.getString("miniBox");
            String miniAdd1 = jsonObj.getString("miniAdd");


            return new Time(id1, firstName1, lastName1, address1, city1, state1, phone1, attic1, basement1, bathCab1, breakfront1,
                    briefcase1, closet1, crawl1, drawer1, freezer1, garage1, grill1, kitCab1, liqCab1, medChest1, pantry1, fridge1,
                    shed1, storage1, otherPlace1, carBox1, carAdd1, investBox1, investAdd1, lockerBox1, lockerAdd1, neighborBox1,
                    neighborAdd1, officeBox1, officeAdd1, fridgeBox1, fridgeAdd1, otherBox1, otherAdd1, zone1, baking1, baked1,
                    barley1, beer1, cereal1, cond1, cos1, cracker1, frozenItem1, groceries1, liquor1, meds1, mix1, noodle1, oatmeal1,
                    perfumes1, petFood1, pickles1, playdough1, toil1, vita1, wheatG1, utensil1, appliance1, bakingTool1, toys1, books1,
                    seforim1, etc1, include1, value1, home1, keyBox1, ketAdd1, combBox1, combAdd1, fullBedika1, exculeBox1, excludeAdd1,
                    miniBox1, miniAdd1);

        } catch (JSONException e) {
            Log.e(LOG_TAG, "Problem parsing the earthquake JSON results", e);

        }
        return null;
    }

}

