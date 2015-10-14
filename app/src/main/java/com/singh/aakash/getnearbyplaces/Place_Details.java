package com.singh.aakash.getnearbyplaces;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Place_Details extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place__details);
        Intent intent=getIntent();
        Places places=(Places)intent.getSerializableExtra(PLACE_TRANSFER);
        TextView placeName=(TextView) findViewById(R.id.place_name);
        placeName.setText( places.getName());

        TextView placeAddress=(TextView) findViewById(R.id.place_address);
        placeAddress.setText("Address " +"\n"+ places.getFormatted_address());

        TextView placePhone=(TextView) findViewById(R.id.place_phone);
        placePhone.setText("Phone Number "+ "\n" + places.getFormatted_phone());

        TextView placeRating=(TextView) findViewById(R.id.place_rating);
        placeRating.setText("Ratings "+  places.getRating());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_place__details, menu);
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
}
