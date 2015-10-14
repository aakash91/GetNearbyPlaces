package com.singh.aakash.getnearbyplaces;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG="MainActivity";
    private List<Places> mPlacesList= new ArrayList<Places>();
    private RecyclerView mRecyclerView;
    private PlacesRecyclerViewAdapter placesRecyclerViewAdapter;
//small change
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //GetRawData getRawData=new GetRawData("https://maps.googleapis.com/maps/api/place/textsearch/json?query=restaurants+in+Sydney&key=AIzaSyDgWFzq9BU2AVAayEBLGB4YMlbvJ1mRCnQ");
        //getRawData.execute();
        //PlaceJSONParser placeJSONParser=new PlaceJSONParser(18.5582770,73.9498070);
        //placeJSONParser.execute();
        mRecyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        ProcessPlaces processPlaces=new ProcessPlaces(18.5582770,73.9498070);
        processPlaces.execute();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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



    public class ProcessPlaces extends PlaceJSONParser{
        public ProcessPlaces(double latitude,double longitude){
            super(latitude, longitude);

        }



        @Override
        public void processDetailResult() {
            super.processDetailResult();
            placesRecyclerViewAdapter=new PlacesRecyclerViewAdapter(getmPlaces(),MainActivity.this);
            //Log.v(LOG_TAG,"item count is"+placesRecyclerViewAdapter.getItemCount());
            mRecyclerView.setAdapter(placesRecyclerViewAdapter);
            //Log.v(LOG_TAG, "item count is" + placesRecyclerViewAdapter.getItemCount());
            mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(MainActivity.this, mRecyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    //Log.v("Fuck", "fucked");
                    Toast.makeText(MainActivity.this, "Zor se daba bhosadi k", Toast.LENGTH_LONG).show();

                }

                @Override
                public void onItemLongClick(View view, int position) {
                    //Log.v("Fuck", "fuck");
                    Toast.makeText(MainActivity.this, "Long Tap", Toast.LENGTH_SHORT).show();
                   // Intent intent = new Intent(MainActivity.this, ViewPhotoActivity.class);
                    //intent.putExtra(PHOTO_TRANSFER, placesRecyclerViewAdapter.getPlace(position));
                    //startActivity(intent);
                }
            }));

        }

        public void execute(){
             super.execute();
//            ProcessData processData= new ProcessData();
//            processData.execute();
        }




//        public class ProcessData extends DownloadJsonData{
//
//            public void onPostExecute(String webData){
//                Log.v(LOG_TAG, "reached main activity");
//                super.onPostExecute(webData);
//                for(Places s:getmPlaces()){
//                    Log.v(LOG_TAG,"place is" + s.toString());
//                }
//                placesRecyclerViewAdapter=new PlacesRecyclerViewAdapter(getmPlaces(),MainActivity.this);
//                Log.v(LOG_TAG,"item count is"+placesRecyclerViewAdapter.getItemCount());
//                mRecyclerView.setAdapter(placesRecyclerViewAdapter);
//                Log.v(LOG_TAG, "item count is" + placesRecyclerViewAdapter.getItemCount());
//                for(Places s:getmPlaces()){
//                    Log.v(LOG_TAG,"place is" + s.toString());
//                }
//            }
//
//        }



    }


}
