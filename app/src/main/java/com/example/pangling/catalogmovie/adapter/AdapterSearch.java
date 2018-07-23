package com.example.pangling.catalogmovie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pangling.catalogmovie.R;
import com.example.pangling.catalogmovie.adapter.viewholder.ViewholderSearch;
import com.example.pangling.catalogmovie.model.MSearch;

import java.util.ArrayList;

public class AdapterSearch extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    ArrayList<MSearch> data;

    public AdapterSearch(Context context, ArrayList<MSearch> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_search, parent, false);
        return new ViewholderSearch(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof ViewholderSearch){
            ((ViewholderSearch)holder).setData(data.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
