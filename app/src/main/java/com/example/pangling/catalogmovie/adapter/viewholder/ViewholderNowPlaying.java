package com.example.pangling.catalogmovie.adapter.viewholder;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pangling.catalogmovie.DetailActivity;
import com.example.pangling.catalogmovie.R;
import com.example.pangling.catalogmovie.model.MNowPlaying;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ViewholderNowPlaying extends RecyclerView.ViewHolder {
    ImageView img;
    TextView judul, desc, tgl, rating, descFull, link;
    Button btnDetail;
    public ViewholderNowPlaying(View itemView) {
        super(itemView);
        img = itemView.findViewById(R.id.imgNowPlaying);
        judul = itemView.findViewById(R.id.tvJudulNowPlaying);
        desc = itemView.findViewById(R.id.tvDesNowPlaying);
        tgl = itemView.findViewById(R.id.tvTglNowPlaying);
        rating = itemView.findViewById(R.id.txtRatingNowPlaying);
        descFull = itemView.findViewById(R.id.txtDescFULLNowPlaying);
        link = itemView.findViewById(R.id.linkgambarNowPlaying);
        btnDetail = itemView.findViewById(R.id.btndetailNowPlaying);

        clickBtn();
    }

    private void clickBtn(){
        btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(itemView.getContext(), DetailActivity.class);
                i.putExtra("judul",judul.getText());
                i.putExtra("desc",descFull.getText());
                i.putExtra("date",tgl.getText());
                i.putExtra("rate",rating.getText());
                i.putExtra("gambar",link.getText());
                itemView.getContext().startActivity(i);
            }
        });
    }

    public void setData(MNowPlaying data){

        try {
            if(data.getOverview().length() > 15){
                desc.setText(data.getOverview().substring(0,17)+"...");
            }else {
                desc.setText(data.getOverview());
            }
            Picasso.with(itemView.getContext()).load("http://image.tmdb.org/t/p/w500"+data.getPosterPath()).into(img);
            judul.setText(data.getTitle());
            //desc.setText(data.getOverview());
            Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(data.getRilisDate());
            tgl.setText(new SimpleDateFormat("EEE , MMMM d, y").format(date1));
            rating.setText(data.getAverage());
            descFull.setText(data.getOverview());
            link.setText("http://image.tmdb.org/t/p/w500"+data.getPosterPath());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
