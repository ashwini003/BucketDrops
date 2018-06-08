package com.project.com.bucketdrops;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class ActivityMain extends AppCompatActivity implements View.OnClickListener {

    Toolbar mtoolbar ;
    Button mbtn ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mtoolbar=(Toolbar) findViewById(R.id.toolbar);
        mbtn = (Button) findViewById(R.id.btn_add);
        mbtn.setOnClickListener(this);
        setSupportActionBar(mtoolbar);

        initBackgroundImage();

    }

    private void initBackgroundImage() {

        ImageView background = (ImageView) findViewById(R.id.iv_background);
        Glide.with(this)
                .load(R.drawable.background)
                .into(background);
    }

    @Override
    public void onClick(View view) {

        showDialogAdd();
        
    }

    private void showDialogAdd() {
            DialogAdd dialog = new DialogAdd();
            dialog.show(getSupportFragmentManager(),"ADD");

    }
}
