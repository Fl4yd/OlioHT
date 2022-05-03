package com.example.olioht;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Locale;

public class Adapter extends BaseAdapter {

    Context context;
    private ArrayList<movie> arrayList;
    LayoutInflater inflater;

    public Adapter(Context context, ArrayList<movie> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (inflater == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (view == null) {

            view = inflater.inflate(R.layout.grid_item, null);
        }

            ImageView imageView = view.findViewById(R.id.grid_image);
            TextView textView = view.findViewById(R.id.item_name);
            if (arrayList.get(i).getPicURL() == null) {
                imageView.setImageResource(R.drawable.no_picture);
            }else {
                Picasso.get().load(arrayList.get(i).getPicURL()).into(imageView);
            }
            textView.setText(arrayList.get(i).getName());





        return view;
    }

}
