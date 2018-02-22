package com.example.selema.my;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.selema.my.network.ApiClient;
import com.example.selema.my.network.ApiInterface;
import com.example.selema.my.network.Image;
import com.example.selema.my.network.Myoffer;
import com.example.selema.my.network.MovieResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment implements  MovieAdapter.MovieCallbacks{
    private OnFragmentInteractionListener mListener;

    private final static String API_KEY = "a9220a624b0d589ffd74a1eab062c1c5";
    private static final String TAG = HomeFragment.class.getSimpleName();

    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view =inflater.inflate(R.layout.fragment_home, container, false);




        recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));


        if (API_KEY.isEmpty()) {

            Toast.makeText(getActivity().getApplicationContext(), "Please obtain your API KEY first from themoviedb.org", Toast.LENGTH_LONG).show();
        }

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<MovieResponse> call = apiService.getTopRatedMovies();
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse>call, Response<MovieResponse> response) {
                List<Myoffer> myoffers = response.body().getMyoffers();


//                MovieAdapter adapter = new MovieAdapter(this ,myoffers, this);
                MovieAdapter adapter = new MovieAdapter(getActivity(), myoffers,HomeFragment.this);
                recyclerView.setAdapter(adapter);

                Log.d(TAG, "Number of myoffers received: " + myoffers.size());

            }

            @Override
            public void onFailure(Call<MovieResponse>call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });



        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onMovieClick(Myoffer myoffer) {

    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
