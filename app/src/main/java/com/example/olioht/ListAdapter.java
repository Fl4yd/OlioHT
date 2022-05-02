package com.example.olioht;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ListAdapter extends BaseAdapter {

    Context context;
    int id;
    String[] name;
    String[] image;
    int mode;
    LayoutInflater inflater;

    public ListAdapter(Context context, String[] name, String[] image, int mode) {
        this.context = context;
        this.name = name;
        this.image = image;
        this.mode = mode;
    }

    @Override
    public int getCount() {
        return name.length;
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

            view = inflater.inflate(R.layout.list_item, null);
        }
        if (this.mode == 0) {
            ImageView imageView = view.findViewById(R.id.list_image);
            TextView textView = view.findViewById(R.id.movie_name);

            Picasso.get().load(image[i]).into(imageView);
            textView.setText(name[i]);
        }else if (this.mode == 1) {


        }
        return view;
    }
}
