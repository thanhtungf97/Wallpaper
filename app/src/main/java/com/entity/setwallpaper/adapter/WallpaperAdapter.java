package com.entity.setwallpaper.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.entity.setwallpaper.R;
import com.entity.setwallpaper.listener.OnItemClick;
import com.entity.setwallpaper.model.Wallpaper;

import org.w3c.dom.Text;

import java.util.List;

public class WallpaperAdapter extends RecyclerView.Adapter<WallpaperAdapter.ViewHolder> {

    private List<Wallpaper> listWallpaper;
    private Context mContext;
    private OnItemClick onItemClick;

    public WallpaperAdapter(List<Wallpaper> listWallpaper, Context mContext, OnItemClick onItemClick) {
        this.listWallpaper = listWallpaper;
        this.mContext = mContext;
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_wallpaper, parent, false);

        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        Wallpaper wallpaper = listWallpaper.get(position);
        Glide.with(mContext).load(wallpaper.getImage()).into(holder.imgWallpaper);

        holder.tvAuthor.setText(wallpaper.getAuthor());
        holder.tvName.setText(wallpaper.getName());
        holder.clItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick.onClick(position);
            }
        });

    }


    @Override
    public int getItemCount() {
        return listWallpaper.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgWallpaper;
        TextView tvName, tvAuthor;
        ConstraintLayout clItem;

        public ViewHolder(View itemView) {
            super(itemView);

            imgWallpaper = itemView.findViewById(R.id.img_wallpaper);
            tvName = itemView.findViewById(R.id.tv_image_name);
            tvAuthor = itemView.findViewById(R.id.tv_image_author);
            clItem = itemView.findViewById(R.id.cl_item);
        }
    }
}
