package com.singh.aakash.getnearbyplaces;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
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

        final String place_id=places.getPlace_id();

        final String latitude=places.getLatitude();
        final String longitude=places.getLongitude();
        final String name=places.getName();

        final Button button = (Button) findViewById(R.id.map_details);
        button.setText("GET DIRECTIONS ON MAPS");
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click

                Intent intent = new Intent(Place_Details.this, MapsActivity.class);

                intent.putExtra("latitude",latitude);
                intent.putExtra("longitude",longitude);
                intent.putExtra("name",name);

                startActivity(intent);
            }
        });

        final Button button1 = (Button) findViewById(R.id.shop_details);
        button1.setText("What does this shop sell");
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                ConnectToDB connectToDB=new ConnectToDB(Place_Details.this,place_id);
                connectToDB.execute();
//                Intent intent = new Intent(Place_Details.this, MapsActivity.class);
//
//                intent.putExtra("placeId",place_id);
//
//                startActivity(intent);
           }
       });
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
