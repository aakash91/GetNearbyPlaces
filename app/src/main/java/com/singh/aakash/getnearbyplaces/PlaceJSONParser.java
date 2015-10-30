package com.singh.aakash.getnearbyplaces;

/**
 * Created by aakash on 13-10-2015.
 */

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class PlaceJSONParser extends GetRawData {

    private String LOG_TAG = PlaceJSONParser.class.getSimpleName();
    private List<Places> mPlaces;
    private List<String> placeIds;
    //private Uri mDestinationUri;
    private StringBuilder mDestinationUri;
    private ArrayList<String> uriList;
    private List<String> detailsData;
    private List<String> placeIdList;

    public PlaceJSONParser(double latitude, double longitude,String type) {
        super(null);
        createAndUpdateUri(latitude, longitude, type);
        mPlaces = new ArrayList<>();
        placeIds = new ArrayList<>();
        detailsData = new ArrayList<>();
        uriList = new ArrayList<>();
        placeIdList=new ArrayList<>();

    }

    private boolean createAndUpdateUri(double latitude, double longitude,String type) {
        final String location = "location=";
        final String radius = "radius";
        String loc = latitude + "," + longitude;

        //final String key = "AIzaSyDgWFzq9BU2AVAayEBLGB4YMlbvJ1mRCnQ";
        final String key = "AIzaSyDELO7UmumdlzQhGy1Nu8R-65kYF2cmg7Q";


//        mDestinationUri = Uri.parse("https://maps.googleapis.com/maps/api/place/nearbysearch/json").buildUpon()
//                .appendQueryParameter(location, loc).appendQueryParameter(radius, "2000").appendQueryParameter(key, "AIzaSyDgWFzq9BU2AVAayEBLGB4YMlbvJ1mRCnQ").build();
        mDestinationUri = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
        mDestinationUri.append("location=" + latitude + "," + longitude);
        mDestinationUri.append("&radius=2000");
        //sb.append("&types="+type);
        //mDestinationUri.append("&sensor=true");
        mDestinationUri.append("&type="+type);
        mDestinationUri.append("&key=");
        mDestinationUri.append(key);
        Log.v(LOG_TAG, "fukin uri is " + mDestinationUri.toString());
        return mDestinationUri != null;
    }

    private String createAndUpdateUri1(String place_id) {
        final String placeId = "placeid";
        Uri mDestinationUri1;
        final String key = "key";
        mDestinationUri1 = Uri.parse("https://maps.googleapis.com/maps/api/place/details/json").buildUpon()
                //.appendQueryParameter(placeId, place_id).appendQueryParameter(key, "AIzaSyDgWFzq9BU2AVAayEBLGB4YMlbvJ1mRCnQ").build();
        .appendQueryParameter(placeId, place_id).appendQueryParameter(key, "AIzaSyDELO7UmumdlzQhGy1Nu8R-65kYF2cmg7Q").build();

        return mDestinationUri1.toString();
    }

    public void runUris() {
        for (String s : placeIds) {
            uriList.add(createAndUpdateUri1(s));

        }
    }

    public void execute() {
        DownloadJsonData jsonData = new DownloadJsonData();
        //Log.v(LOG_TAG, "Built Uri" + mDestinationUri.toString());
        jsonData.execute(mDestinationUri.toString());


    }

    public List<Places> getmPlaces() {
        return mPlaces;
    }

    public List<String> getPlaceIdList() {
        return placeIdList;
    }

    public List<String> getDetailsData() {
        return detailsData;
    }

    public void processResult() {
        if (getmDownloadStatus() != DownloadStatus.OK) {
            Log.e(LOG_TAG, "error");
            return;
        }

        final String results = "results";
        final String place_id = "place_id";

        try {

            JSONObject jsonObject = new JSONObject(getmData());

            Log.v(LOG_TAG, "This is " + getmData());
            JSONArray jsonArray = jsonObject.getJSONArray(results);
            Log.v(LOG_TAG, "Did i reach her");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonPhoto = jsonArray.getJSONObject(i);
                String placeId = jsonPhoto.getString(place_id);
                placeIds.add(placeId);
            }


            runUris();



            DownloadJsonDetailsData downloadJsonDetailsData = new DownloadJsonDetailsData();

            downloadJsonDetailsData.execute(uriList);



        } catch (JSONException jsone) {
            jsone.printStackTrace();
            Log.e(LOG_TAG, "error processing JSON");
        }

    }

    public void processDetailResult() {
        final String name="name";
        final String results = "result";
        final String icon = "icon";
        final String vicinity = "vicinity";
        final String location = "location";
        final String geometry = "geometry";
        final String latitude = "lat";
        final String longitude = "lng";
        final String formatted_address = "formatted_address";
        final String formatted_phone = "formatted_phone_number";
        final String website = "website";
        final String rating = "rating";
        final String international_phone_number = "international_phone_number";
        final String url = "url";
        final String placeId="place_id";

        for (String s : detailsData) {
            try {

                JSONObject jsonObject1 = new JSONObject(s);
                Log.v(LOG_TAG, "jsonObject");

                //Log.v(LOG_TAG,"jsonArray");
                String mName;
                String mIcon;
                String mVicinity;
                String mLatitude;
                String mLongitude;
                String mAdress;
                String mPhone;
                String mWebsite;
                String mRating;
                String mNumber;
                String mUrl;
                String mPlaceId;

                Log.v(LOG_TAG, "detail string is " + s);
                JSONObject jsonObject = jsonObject1.getJSONObject(results);
                if (jsonObject.has(name)) {
                    mName = jsonObject.getString(name);
                } else {
                    mName = "n/a";
                }

                if (jsonObject.has(icon)) {
                    mIcon = jsonObject.getString(icon);
                } else {
                    mIcon = "n/a";
                }

                if (jsonObject.has(formatted_address)) {
                    mAdress = jsonObject.getString(formatted_address);
                } else {
                    mAdress = "n/a";
                }

                if (jsonObject.has(formatted_phone)) {
                    mPhone = jsonObject.getString(formatted_phone);
                } else {
                    mPhone = "n/a";
                }

                if (jsonObject.has(vicinity)) {
                    mVicinity = jsonObject.getString(vicinity);
                } else {
                    mVicinity = "n/a";
                }

                if (jsonObject.has(website)) {
                    mWebsite = jsonObject.getString(website);
                } else {
                    mWebsite = "n/a";
                }

                if (jsonObject.has(rating)) {
                    mRating = jsonObject.getString(rating);
                } else {
                    mRating = "n/a";
                }

                if (jsonObject.has(international_phone_number)) {
                    mNumber = jsonObject.getString(international_phone_number);
                } else {
                    mNumber = "n/a";
                }

                if (jsonObject.has(url)) {
                    mUrl = jsonObject.getString(url);
                } else {
                    mUrl = "n/a";
                }
                if (jsonObject.has(placeId)) {
                    mPlaceId = jsonObject.getString(placeId);
                    placeIdList.add(mPlaceId);
                } else {
                    mPlaceId = "n/a";
                }


                if (jsonObject.has(geometry)) {
                    JSONObject mGeometry = jsonObject.getJSONObject(geometry);
                    if(mGeometry.has(location)){
                        JSONObject mLocation = mGeometry.getJSONObject(location);
                        mLatitude=mLocation.getString(latitude);
                        mLongitude=mLocation.getString(longitude);
                    }else{
                        mLatitude="n/a";
                        mLongitude="n/a";
                    }
                } else {
                    mLatitude="n/a";
                    mLongitude="n/a";
                }

                Places place = new Places(mName,mIcon, mVicinity, mLatitude, mLongitude, mAdress, mPhone, mWebsite, mRating, mNumber, mUrl,mPlaceId);
                mPlaces.add(place);




            } catch (JSONException jsone) {
                jsone.printStackTrace();
                Log.e(LOG_TAG, "error processing JSON");
            }
        }
        for(Places singlePlace:mPlaces){
            Log.v(LOG_TAG, "Single Place" + singlePlace.toString());
        }

    }

    public class DownloadJsonData extends DownloadRawData {
        @Override
        protected void onPostExecute(String webData) {
            Log.v(LOG_TAG, "I am here");
            super.onPostExecute(webData);
            processResult();
        }

        @Override
        protected String doInBackground(String... params) {
            String[] par = {mDestinationUri.toString()};
            Log.v(LOG_TAG, "fuck this " + mDestinationUri.toString());
            return super.doInBackground(par);
            //return super.doInBackground("https://api.flickr.com/services/feeds/photos_public.gne?tags=android&format=json&nojsoncallback=1");
            //return super.doInBackground("https://maps.googleapis.com/maps/api/place/details/json?placeid=ChIJN1t_tDeuEmsRUsoyG83frY4&key=AIzaSyDgWFzq9BU2AVAayEBLGB4YMlbvJ1mRCnQ");
            //return super.doInBackground("https://maps.googleapis.com/maps/api/place/textsearch/json?query=restaurants+in+Sydney&key=AIzaSyDgWFzq9BU2AVAayEBLGB4YMlbvJ1mRCnQ");
        }
    }

    public class DownloadJsonDetailsData extends AsyncTask<List<String>, Void, List<String>> {
        @Override
        protected List<String> doInBackground(List<String>... params) {
            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;
            ArrayList<String> strings = new ArrayList<>();

            if (params == null) {
                return null;
            }
            for (String s : params[0]) {
                try {
                    URL url = new URL(s);
                    urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setRequestMethod("GET");
                    urlConnection.connect();
                    InputStream inputStream = urlConnection.getInputStream();
                    if (inputStream == null) {
                        return null;
                    }
                    StringBuffer buffer = new StringBuffer();
                    reader = new BufferedReader(new InputStreamReader(inputStream));

                    String line;
                    while ((line = reader.readLine()) != null) {
                        buffer.append(line + "\n");
                    }
                    strings.add(buffer.toString());
                    //return buffer.toString();
                } catch (IOException e) {
                    //  Log.e(LOG_TAG,"error",e);
                    return null;
                } finally {
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (final IOException e) {
                            //  Log.e(LOG_TAG,"error",e);
                        }
                    }
                }
            }

            return strings;
        }

        @Override
        protected void onPostExecute(List<String> strings) {
            detailsData = strings;


            processDetailResult();
        }
    }
}
