package com.example.selema.my;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.selema.my.db.DatabaseHelper;
import com.example.selema.my.favourite.Fav_movie;
import com.example.selema.my.network.Image;
import com.example.selema.my.network.Myoffer;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by selema on 1/30/18.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.modelViewHolder> {

    public static final String TAG = MovieAdapter.class.getSimpleName();


    private Context context;
    private List<Myoffer> myoffers;
    private List<Fav_movie> fav_movies;
    private MovieCallbacks listner;
    private List<Image> images;


    DatabaseHelper myDb;

    public MovieAdapter(Context context, List<Myoffer> myoffers, MovieCallbacks listner) {
        this.context = context;
        this.myoffers = myoffers;
        this.listner = listner;

    }

    @Override
    public modelViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_item, null);
        myDb = new DatabaseHelper(this.context);

        final modelViewHolder holder = new modelViewHolder(view, context, myoffers);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Myoffer myoffer = holder.myoffers.get(position);

                Intent i = new Intent(context, DetailsActivity.class);



                Toast.makeText(view.getContext(), "position = " + myoffer.getPhoneNumber(), Toast.LENGTH_SHORT).show();

                i.putExtra("title", myoffer.getOfferName());
                i.putExtra("poster", String.valueOf(myoffer.getImage()));
                i.putExtra("id", myoffer.getOfferNumber().toString());
                i.putExtra("overview", myoffer.getDescription());
                i.putExtra("votecount", myoffer.getViews());
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
               // listner.onMovieClick(myoffers.get(holder.getAdapterPosition()));
            }
        });


        return holder;
    }

    @Override
    public void onBindViewHolder(modelViewHolder holder, int position) {

        YoYo.with(Techniques.BounceInRight).playOn(holder.cardView);
        final Myoffer myoffer = myoffers.get(position);
        holder.textViewTitle.setText(myoffer.getOfferName());
        holder.textViewRating.setText(String.valueOf(myoffer.getViews()));
        holder.textViewPrice.setText(String.valueOf(myoffer.getStoreType()));

        Picasso.with(context).load("http://test-rest-api.1d35.starter-us-east-1.openshiftapps.com/api/images/"
                + myoffer.getImage()).into(holder.imageView);

        Log.e("myoffer.getImage()","" );
    }


    public interface MovieCallbacks {
        void onMovieClick(Myoffer myoffer);
    }

    @Override
    public int getItemCount() {
        return myoffers.size();
    }

    class modelViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView cardView;
        TextView textViewTitle, textViewShortDesc, textViewRating, textViewPrice;
        ImageView imageView;
        Context context;
        List<Myoffer> myoffers;
        Button favoriteButton;

        public modelViewHolder(View itemView, Context context, List<Myoffer> myoffers) {

            super(itemView);

            itemView.setOnClickListener(this);
            this.myoffers = myoffers;
            this.context = context;

            cardView = itemView.findViewById(R.id.cardview);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewRating = itemView.findViewById(R.id.textViewRating);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            imageView = itemView.findViewById(R.id.imageView);
        }

        @Override
        public void onClick(View view) {
            int position = this.getAdapterPosition();
            Myoffer myoffer = this.myoffers.get(position);
            Toast.makeText(view.getContext(), "position = " + position, Toast.LENGTH_SHORT).show();

        }

    }
}
