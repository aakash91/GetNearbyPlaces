package com.singh.aakash.getnearbyplaces;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by aakash on 13-10-2015.
 */
public class CategoryHolder extends RecyclerView.ViewHolder {


    protected TextView title;

    public CategoryHolder(View view) {
        super(view);

        this.title=(TextView) view.findViewById(R.id.title);
    }

}
