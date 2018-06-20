package com.project.com.bucketdrops.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.project.com.bucketdrops.R;
import com.project.com.bucketdrops.beans.Drop;

import java.util.ArrayList;

import io.realm.RealmResults;

import static android.support.constraint.Constraints.TAG;

public class AdaptorDrops extends RecyclerView.Adapter<AdaptorDrops.DropHolder>{

    private LayoutInflater mInflator;
    private RealmResults<Drop> mResults ;
    public static final String TAG="VIVZ";
    public AdaptorDrops(Context context,RealmResults<Drop> results){
       mInflator= LayoutInflater.from(context);
        update(results);


    }

    public void update(RealmResults<Drop> results){
        mResults = results;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public DropHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= mInflator.inflate(R.layout.row_drop,parent,false);
        DropHolder holder = new DropHolder(view);
        Log.d(TAG, "onCreateViewHolder: ");
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull DropHolder holder, int position) {
       Drop drop= mResults.get(position);
        holder.mTextWhat.setText(drop.getWhat());
        Log.d(TAG, "onBindViewHolder: "+position);

    }

    @Override
    public int getItemCount() {
        return mResults.size();
    }

    public static class DropHolder extends RecyclerView.ViewHolder{

        TextView mTextWhat;

        public DropHolder(View itemView) {
            super(itemView);

            mTextWhat = (TextView) itemView.findViewById(R.id.tv_what);
        }
    }

}
