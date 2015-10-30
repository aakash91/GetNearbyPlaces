package com.singh.aakash.getnearbyplaces;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Product_Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product__details);

        Intent intent=getIntent();
        TextView name=(TextView) findViewById(R.id.product_name);
        TextView description=(TextView) findViewById(R.id.product_description);
        TextView price=(TextView) findViewById(R.id.product_price);

        name.setText(intent.getExtras().getString("name"));
        description.setText(intent.getExtras().getString("des"));
        price.setText(intent.getExtras().getString("price"));

        Button cartButton=(Button)findViewById(R.id.addTocart);
        cartButton.setText("Add to Cart");

        cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast=Toast.makeText(Product_Details.this, "Item added to your cart", Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_product__details, menu);
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
