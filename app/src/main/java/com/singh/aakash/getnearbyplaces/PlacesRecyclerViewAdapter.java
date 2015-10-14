package com.singh.aakash.getnearbyplaces;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by aakash on 13-10-2015.
 */
public class PlacesRecyclerViewAdapter extends RecyclerView.Adapter<PlacesHolder> {

    private List<Places> mPlaceList;
    private Context mContext;

    @Override
    public PlacesHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.browse, null);

        PlacesHolder placesHolder= new PlacesHolder(view);
        return placesHolder;
    }

    @Override
    public void onBindViewHolder(PlacesHolder placesHolder, int i) {
        Places places=mPlaceList.get(i);

        placesHolder.title.setText(places.getName());
       // getItemCount();
    }

    @Override
    public int getItemCount() {
        return (null!=mPlaceList?mPlaceList.size():0);
    }

    public PlacesRecyclerViewAdapter(List<Places> placesList, Context context) {
        this.mPlaceList = placesList;
        this.mContext = context;
    }

    public Places getPlace(int position){
        return (null!=mPlaceList?mPlaceList.get(position):null);
    }

}
