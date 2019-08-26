package com.example.moviecatalogue1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.Objects;


public class DetailActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String EXTRA_FILM = "extra_film";

    private void setActionBarTitle(){
        Objects.requireNonNull(getSupportActionBar()).setTitle("Film");
    }


    TextView nama, deskripsi, review;
    ImageView poster;
    ImageButton ibFavorite, ibBookmark;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        setActionBarTitle();

        nama = findViewById(R.id.nama_film);
        deskripsi = findViewById(R.id.deskripsi_film);
        poster = findViewById(R.id.poster_film);

        ibBookmark = findViewById(R.id.ib_bookmark);
        ibBookmark.setOnClickListener(this);
        ibFavorite = findViewById(R.id.ib_favorite);
        ibFavorite.setOnClickListener(this);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);
        review = findViewById(R.id.tv_review);

        Film film = getIntent().getParcelableExtra(EXTRA_FILM);

        assert film != null;
        String namapilm = film.getName();
        nama.setText(namapilm);
        Glide.with(this)
                .load(film.getPhoto())
                .apply(new RequestOptions())
                .into(poster);
        String deskripsipilm = film.getDescription();
        deskripsi.setText(deskripsipilm);
        String reviewpilm = film.getReview();
        review.setText(reviewpilm);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.ib_bookmark:
                Toast.makeText(DetailActivity.this,"Bookmarked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ib_favorite:
                Toast.makeText(DetailActivity.this,"Favorite", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button:
                Toast.makeText(DetailActivity.this,"New Feature : Coming Soon!!", Toast.LENGTH_SHORT).show();
        }
    }

}
