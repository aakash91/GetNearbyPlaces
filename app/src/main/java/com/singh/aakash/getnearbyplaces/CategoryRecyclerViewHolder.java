package com.singh.aakash.getnearbyplaces;

//This is the adapter
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by aakash on 13-10-2015.
 */
public class CategoryRecyclerViewHolder extends RecyclerView.Adapter<CategoryHolder> {

    private List<String> categories;
    private Context mContext;

    @Override
    public CategoryHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.browse, null);

        CategoryHolder placesHolder= new CategoryHolder(view);
        return placesHolder;
    }

    @Override
    public void onBindViewHolder(CategoryHolder categoryHolder, int i) {
        String category=categories.get(i);

        categoryHolder.title.setText(category);
        // getItemCount();
    }

    @Override
    public int getItemCount() {
        return (null!=categories?categories.size():0);
    }

    public CategoryRecyclerViewHolder(List<String> categories, Context context) {
        this.categories = categories;
        this.mContext = context;
    }

    public String getCategoryPosition(int position){
        return (null!=categories?categories.get(position):null);
    }

}
