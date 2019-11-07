package com.team.alwiscruise.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.team.alwiscruise.Activtiy.DestinationAllActivtiy;
import com.team.alwiscruise.Model.Region;
import com.team.alwiscruise.R;
import com.team.alwiscruise.Util.Constant;

import java.util.List;


public class RecyclerRegionGridAdapter extends RecyclerView.Adapter<RecyclerRegionGridAdapter.MyViewHolder> {

    List<Region> mRegion;

    public RecyclerRegionGridAdapter(List<Region> RegionList){
       mRegion = RegionList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate( R.layout.region_card, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.name.setText(mRegion.get(position).getName());

        Glide.with( holder.image.getContext() )
                .load( mRegion.get( position ).getImage() )
                .into( holder.image );

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = mRegion.get(position).getId();
                String name = mRegion.get(position).getName();
                int image = mRegion.get(position).getImage();

                Intent intent = new Intent(view.getContext(), DestinationAllActivtiy.class);
                intent.putExtra(Constant.KEY_ID_REGION, id);
                intent.putExtra(Constant.KEY_NAME, name);
                intent.putExtra(Constant.KEY_IMAGE, image);
                view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mRegion.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private LinearLayout item_card;
        TextView name;
        ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.name);
            image = (ImageView) itemView.findViewById(R.id.image);
        }

    }
}