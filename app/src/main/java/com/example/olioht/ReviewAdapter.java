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

//Adapter for the movie history/reviews
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
                int ID = arrayList.get(i).getID();
                view = inflater.inflate(R.layout.list_item, null);
                TextView moviename = view.findViewById(R.id.movie_name_history);
                TextView userscore = view.findViewById(R.id.user_score_history);
                ImageView movie_image = view.findViewById(R.id.list_image);
                moviename.setText(Movies.getInstance().searchMovie(ID).getName());
                userscore.setText("Your score: "+arrayList.get(i).getRating());

                if (Movies.getInstance().searchMovie(ID).getPicURL() == null) {
                    movie_image.setImageResource(R.drawable.no_picture);
                }else {
                    Picasso.get().load(Movies.getInstance().searchMovie(ID).getPicURL()).into(movie_image);
                }



            }else if (mode == 1) {
                view = inflater.inflate(R.layout.review_item, null);
                TextView review = view.findViewById(R.id.review_text);
                TextView user = view.findViewById(R.id.user_name_review);
                TextView rating = view.findViewById(R.id.review_rating);
                if (arrayList != null) {
                    review.setText(arrayList.get(i).getReviewtext());
                    user.setText(arrayList.get(i).getUsername());
                    rating.setText(arrayList.get(i).getRating());
                }
            }

        }


        return view;
    }
}