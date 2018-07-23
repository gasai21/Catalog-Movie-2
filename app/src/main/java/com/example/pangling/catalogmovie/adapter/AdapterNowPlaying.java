package com.example.pangling.catalogmovie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pangling.catalogmovie.R;
import com.example.pangling.catalogmovie.adapter.viewholder.ViewholderNowPlaying;
import com.example.pangling.catalogmovie.model.MNowPlaying;

import java.util.ArrayList;

public class AdapterNowPlaying extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    ArrayList<MNowPlaying> data;

    public AdapterNowPlaying(Context context, ArrayList<MNowPlaying> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_nowplaying, parent, false);
        return new ViewholderNowPlaying(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof ViewholderNowPlaying){
            ((ViewholderNowPlaying)holder).setData(data.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
