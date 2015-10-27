package com.singh.aakash.getnearbyplaces;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class shops_category extends AppCompatActivity {

    List<String> shopCat;
    private ListView listShop;
    private double lat;
    private double lng;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shops_category);

        Intent intent=getIntent();
        lat=intent.getDoubleExtra("lat", 78);
        lng=intent.getDoubleExtra("lng",78);

        //
        listShop= (ListView) findViewById(R.id.listShops);
        shopCat=new ArrayList<>();

        shopCat.add("bakery");
        shopCat.add("bar");
        shopCat.add("beauty_salon");
        shopCat.add("cafe");
        shopCat.add("car_rental");
        shopCat.add("car_repair");
        shopCat.add("clothing_store");
        shopCat.add("convenience_store");
        shopCat.add("doctor");
        shopCat.add("electrician");
        shopCat.add("electronic_store");
        shopCat.add("florist");
        shopCat.add("furniture_store");
        shopCat.add("grocery_or_supermarket");
        shopCat.add("gym");
        shopCat.add("hardware_store");
        shopCat.add("home_goods_store");
        shopCat.add("laundry");
        shopCat.add("liquor_store");
        shopCat.add("lodging");
        shopCat.add("night_club");
        shopCat.add("painter");
        shopCat.add("pharmacy");
        shopCat.add("restaurant");
        shopCat.add("shoe_store");
        shopCat.add("spa");
        shopCat.add("storage");


        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(shops_category.this,R.layout.list_shop,shopCat);
        listShop.setAdapter(arrayAdapter);

        listShop.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String shopType=(String)listShop.getItemAtPosition(position);
                Toast.makeText(shops_category.this, "You have chosen : " + " " + shopType, Toast.LENGTH_LONG).show();
                Intent intent=new Intent(shops_category.this,MainActivity.class);
                intent.putExtra("type",shopType);
                intent.putExtra("lat",lat);
                intent.putExtra("lng",lng);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_shops_category, menu);
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
