package com.singh.aakash.getnearbyplaces;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class Advertisements extends AppCompatActivity {
    List<String> AdsList;
    private RecyclerView mRecyclerView;
    private CategoryRecyclerViewHolder AdsViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advertisements);

        Intent intent=getIntent();
        List<String> AdverList=new ArrayList<>();
        AdsList=intent.getStringArrayListExtra("ads");
        for(String s:AdsList){
            s=s.replaceAll(",","\n");
            AdverList.add(s);
        }
        //Log.v("fuck this shit",category);
        mRecyclerView=(RecyclerView)findViewById(R.id.recycler_view_Ads);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        AdsViewAdapter=new CategoryRecyclerViewHolder(AdverList,this);

        mRecyclerView.setAdapter(AdsViewAdapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_advertisements, menu);
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
