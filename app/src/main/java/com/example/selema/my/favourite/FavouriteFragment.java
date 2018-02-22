package com.example.selema.my.favourite;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.selema.my.R;
import com.example.selema.my.db.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;


public class FavouriteFragment extends Fragment {
    DatabaseHelper myDb;


    DatabaseHelper database;
    RecyclerView recyclerView;
    Favourite_Adapter adapter;
    List<Fav_movie> movies;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favourite, container, false);


        movies = new ArrayList<Fav_movie>();
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewFav);


        database = new DatabaseHelper(getActivity());
        movies = database.getdata();

        adapter = new Favourite_Adapter(getActivity(), movies);

        adapter.setItems(movies);
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);


        Log.i("HIteshdata", "" + movies);
        RecyclerView.LayoutManager reLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setHasFixedSize(true);
        recyclerView.invalidate();
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));



        return  view;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}
