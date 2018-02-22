package com.example.selema.my;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.selema.my.db.DatabaseHelper;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import ss.com.bannerslider.banners.Banner;
import ss.com.bannerslider.banners.DrawableBanner;
import ss.com.bannerslider.banners.RemoteBanner;
import ss.com.bannerslider.views.BannerSlider;


public class DetailsActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    ToggleButton toggleButton;
    Button callbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_layout);

        myDb = new DatabaseHelper(this.getBaseContext());


        final Bundle extras = getIntent().getExtras();
        final String ids = extras.getString("id");
        //final int id = Integer.parseInt(ids);
        final String overview = extras.getString("overview");
        // String video= extras.getString("video");
        final String votecount = extras.getString("votecount");
        final String title = extras.getString("title");
        final String poster = extras.getString("poster");

      /*  TextView overviewTXT = (TextView) findViewById(R.id.overviewTXT);
        TextView titleTXT = (TextView) findViewById(R.id.overview);
*//*
        overviewTXT.setText(overview);
        titleTXT.setText(title);*/
//        Toast.makeText(getBaseContext(), "position  " + myDb.CheckIsDataAlreadyInDBorNot(ids) + " = " + ids, Toast.LENGTH_SHORT).show();
        Toast.makeText(getBaseContext(), "position  " + myDb.CheckIsDataAlreadyInDBorNot(ids) + " = " + ids, Toast.LENGTH_SHORT).show();

       // final ImageView image = (ImageView) findViewById(R.id.image);
       // Picasso.with(getBaseContext()).load("http://image.tmdb.org/t/p/w185/" + poster).into(image);

        boolean isCheckeded = myDb.CheckIsDataAlreadyInDBorNot(ids);
        toggleButton = (ToggleButton) findViewById(R.id.button_favorite);

        toggleButton.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_border));



        if (isCheckeded) {
            toggleButton.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_favourite));
        } else {
            toggleButton.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_border));
        }

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    toggleButton.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_favourite));
                    AddData(ids,title,overview,votecount,poster);
                } else {
                    toggleButton.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_border));
                    DeleteData(ids);
                }
            }
        });
        callbtn = (Button)findViewById(R.id.call_button);
        callbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + "01212260464"));
                startActivity(intent);
            }
        });
        BannerSlider bannerSlider = (BannerSlider) findViewById(R.id.banner_slider1);
        List<Banner> banners=new ArrayList<>();
        //add banner using image url
        banners.add(new RemoteBanner("http://test-rest-api.1d35.starter-us-east-1.openshiftapps.com/api/images/download.jpg"));
        banners.add(new RemoteBanner("http://test-rest-api.1d35.starter-us-east-1.openshiftapps.com/api/images/download.jpg"));
        banners.add(new RemoteBanner("http://test-rest-api.1d35.starter-us-east-1.openshiftapps.com/api/images/download.jpg"));

        bannerSlider.setBanners(banners);

    }



    public void AddData(String id,String movie_name,String movie_overview,String movierate,String movieImage ) {
        boolean isInserted = myDb.insertData(id,movie_name,movie_overview,movierate,movieImage);
        if (isInserted == true)
            Toast.makeText(this, "Data Inserted", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this, "Data not Inserted", Toast.LENGTH_LONG).show();
    }

    public void DeleteData(String id) {
        Integer deletedRows = myDb.deleteData(id.toString());
        if (deletedRows > 0)
            Toast.makeText(this, "Data Deleted", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this, "Data not Deleted", Toast.LENGTH_LONG).show();
    }

}
