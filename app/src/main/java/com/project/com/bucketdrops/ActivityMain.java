package com.project.com.bucketdrops;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ActivityMain extends AppCompatActivity {

    Toolbar mtoolbar ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mtoolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);
        initBackgroundImage();

    }

    private void initBackgroundImage() {

        ImageView background = (ImageView) findViewById(R.id.iv_background);
        Glide.with(this)
                .load(R.drawable.background)
                .into(background);
    }
}
