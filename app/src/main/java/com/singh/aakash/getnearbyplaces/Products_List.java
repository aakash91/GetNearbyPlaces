package com.singh.aakash.getnearbyplaces;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Products_List extends AppCompatActivity {
    List<String> productList;
    private RecyclerView mRecyclerView;
    private CategoryRecyclerViewHolder productViewAdapter;
    List<String> descriptionList;
    List<String> priceList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products__list);
        descriptionList=new ArrayList<>();
        priceList=new ArrayList<>();
        Intent intent=getIntent();
        final List<String> productsList=new ArrayList<>();
        productList=intent.getStringArrayListExtra("arrayOfProducts");
        for(String s:productList){
            //s=s.replaceAll(",","\n");
            List<String> help=new ArrayList<>();
            for(String ss:s.split(",")){
                help.add(ss);
            }
            productsList.add(help.get(0));
            descriptionList.add(help.get(1));
            priceList.add(help.get(2));
        }
        //Log.v("fuck this shit",category);
        mRecyclerView=(RecyclerView)findViewById(R.id.recycler_view_product);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        productViewAdapter=new CategoryRecyclerViewHolder(productsList,this);

        mRecyclerView.setAdapter(productViewAdapter);


        mRecyclerView.addOnItemTouchListener(new CategoryRecyclerItemClickListener(this, mRecyclerView, new CategoryRecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //Log.v("Fuck", "fucked");
                //Toast.makeText(MainActivity.this, "Zor se daba bhosadi k", Toast.LENGTH_LONG).show();
//                Intent intent = new Intent(getApplicationContext(), Products_List.class);
//                intent.putExtra("category", categoryRecyclerViewHolder.getCategoryPosition(position));
//                startActivity(intent);
                //ConnectToDB connectToDB=new ConnectToDB(MainActivity.this);
                //connectToDB.execute();
//                String cat = productViewAdapter.getCategoryPosition(position);
//                DBForProducts dbForProducts = new DBForProducts(Products_List.this, cat, placeId);
//                dbForProducts.execute();
                Intent intent=new Intent(Products_List.this,Product_Details.class);
                intent.putExtra("name",productsList.get(position));
                intent.putExtra("des",descriptionList.get(position));
                intent.putExtra("price",priceList.get(position));
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(View view, int position) {
                //Log.v("Fuck", "fuck");
                //Toast.makeText(Category_intent.this, "Fuck u", Toast.LENGTH_SHORT).show();

            }
        }));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_products__list, menu);
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
