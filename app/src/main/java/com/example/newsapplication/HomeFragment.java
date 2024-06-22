package com.example.newsapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapplication.databinding.FragmentHomeBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {


    FragmentHomeBinding binding;
    String api = "bc9bb53ea38b49a3b8348d921299988a";
    Adapter adapter;
    String country= "in";
    ArrayList<ModelClass> modelClassArrayList;
    private RecyclerView recyclerViewHome;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_home, null);
        recyclerViewHome = v.findViewById(R.id.rvHome);
        modelClassArrayList= new ArrayList<>();
        recyclerViewHome.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Adapter(getContext(), modelClassArrayList);
        recyclerViewHome.setAdapter(adapter);
        findNews();

        return v;



    }

    private void findNews(){
        ApiUtilities.getApiInterface().getHeadlineNews(country, 100, api).enqueue(new Callback<NewsList>() {
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

