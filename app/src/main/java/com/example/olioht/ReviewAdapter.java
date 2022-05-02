package com.example.olioht;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ReviewAdapter extends BaseAdapter {

    Context context;
    ArrayList<Review> arrayList;
    int mode;
    LayoutInflater inflater;

    public ReviewAdapter(Context context, ArrayList<Review> arrayList, int mode) {
        this.context = context;
        this.mode = mode;
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

            if (mode == 0) {
                view = inflater.inflate(R.layout.list_item, null);

            }else if (mode == 1) {
                view = inflater.inflate(R.layout.review_item, null);

            }

        }
        if (mode == 0) {
            //History

        }else if (mode == 1) {
            //Reviews
        }




        return view;
    }
}