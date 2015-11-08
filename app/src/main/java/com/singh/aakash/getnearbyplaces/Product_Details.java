package com.singh.aakash.getnearbyplaces;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Product_Details extends AppCompatActivity {
Intent intent1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product__details);

        final Intent intent=getIntent();
        final TextView name=(TextView) findViewById(R.id.product_name);
        TextView description=(TextView) findViewById(R.id.product_description);
        final TextView price=(TextView) findViewById(R.id.product_price);
        final EditText qty=(EditText) findViewById(R.id.quantity);

        name.setText(intent.getExtras().getString("name"));
        description.setText(intent.getExtras().getString("des"));
        price.setText(intent.getExtras().getString("price"));

        Button cartButton=(Button)findViewById(R.id.addTocart);
        cartButton.setText("Add to Cart");

        cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(Product_Details.this, "Item added to your cart", Toast.LENGTH_LONG);
                toast.show();


                //intent1.putExtra("product"+Counter_Class.getCount(),name.getText().toString()+"-"+qty.getText().toString()+"-"+price.getText().toString());
                Static_Buffer.getStringBuffer().add(name.getText().toString() + "-" + qty.getText().toString() + "-" + price.getText().toString());
                Counter_Class.inc_counter();
            }
        });

        Button checkOut=(Button) findViewById(R.id.checkOut);
        checkOut.setText("Proceed to Checkout");


        checkOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent1=new Intent(Product_Details.this,ShoppingCart.class);
                Log.v("where",Counter_Class.getCount()+"");
                for(int i=0;i<Counter_Class.getCount();i++){
                    //intent.putExtra("product"+i,Static_Buffer.getStringBuffer().get(i));
                    Log.v("where",Static_Buffer.getStringBuffer().get(i) +" " );

                }
                startActivity(intent1);
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
