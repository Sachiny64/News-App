package com.example.newsapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SportsFragment extends Fragment {
    String api = "bc9bb53ea38b49a3b8348d921299988a";
    Adapter adapter;
    String country= "in";
    ArrayList<ModelClass> modelClassArrayList;
    RecyclerView recyclerViewSports;
    String category= "sports";







    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_sports, null);

        recyclerViewSports = v.findViewById(R.id.rvSports);


        modelClassArrayList= new ArrayList<>();
        recyclerViewSports.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Adapter(getContext(), modelClassArrayList);
        recyclerViewSports.setAdapter(adapter);
        findNews();

        return v;



    }

    private void findNews(){
        ApiUtilities.getApiInterface().getCategoryNews(country,category, 100, api).enqueue(new Callback<NewsList>() {
            @Override
            public void onResponse(Call<NewsList> call, Response<NewsList> response) {
                if (response.isSuccessful()){
                    modelClassArrayList.addAll(response.body().getArticles());

                    adapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onFailure(Call<NewsList> call, Throwable throwable) {

            }
        });

    }



}