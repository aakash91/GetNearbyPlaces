package com.singh.aakash.getnearbyplaces;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ShoppingCart extends AppCompatActivity {
    ArrayList<String> listData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        Intent intent=getIntent();
        listData=new ArrayList<>();
        for(int i=0;i<Counter_Class.getCount();i++){
            //listData.add(intent.getExtras().getString("product"+i));
            listData.add(Static_Buffer.getStringBuffer().get(i));
        }

        final ListView listView = (ListView) findViewById(R.id.listProducts);
        listView.setAdapter(new CustomListViewAdapter(this, listData));

        Button placeOrder=(Button) findViewById(R.id.PlaceOrder);
        placeOrder.setText("Place Order");

        placeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ShoppingCart.this,"moving",Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_shopping_cart, menu);
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
