package com.project.com.bucketdrops;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.project.com.bucketdrops.adapters.AdaptorDrops;
import com.project.com.bucketdrops.beans.Drop;

import io.realm.Realm;
import io.realm.RealmResults;

public class ActivityMain extends AppCompatActivity implements View.OnClickListener {

    Toolbar mtoolbar ;
    Button mbtn ;
    RecyclerView mRecycler ;
    Realm mRealm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Realm mRealm = Realm.getDefaultInstance();
        RealmResults<Drop> results = mRealm.where(Drop.class).findAllAsync();
        mtoolbar=(Toolbar) findViewById(R.id.toolbar);
        mbtn = (Button) findViewById(R.id.btn_add);
        mRecycler=(RecyclerView) findViewById(R.id.rv_drops);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRecycler.setLayoutManager(manager);

        mRecycler.setAdapter(new AdaptorDrops(this,results));
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
