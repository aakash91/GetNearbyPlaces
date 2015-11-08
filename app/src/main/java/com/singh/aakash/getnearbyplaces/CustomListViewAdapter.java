package com.singh.aakash.getnearbyplaces;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by aakash on 06-11-2015.
 */
public class CustomListViewAdapter extends BaseAdapter {
    private ArrayList listData;
    private LayoutInflater layoutInflater;
    String[] splitString;

    public CustomListViewAdapter(Context context, ArrayList listData) {
        this.listData = listData;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.checkout, null);
            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.checkName);
            holder.qty = (EditText) convertView.findViewById(R.id.checkQty);
            holder.price = (TextView) convertView.findViewById(R.id.checkPrice);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        splitString=listData.get(position).toString().split("-");

        holder.name.setText(splitString[0]);
        holder.qty.setText(splitString[1]);
        holder.price.setText(splitString[2]);

        return convertView;
    }

    static class ViewHolder {
        TextView name;
        EditText qty;
        TextView price;
    }
}