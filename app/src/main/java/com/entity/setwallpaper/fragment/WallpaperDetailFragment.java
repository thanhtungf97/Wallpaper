package com.entity.setwallpaper.fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.WallpaperManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.entity.setwallpaper.R;
import com.entity.setwallpaper.model.Wallpaper;

import java.io.IOException;

@SuppressLint("ValidFragment")
public class WallpaperDetailFragment extends Fragment {
    private Wallpaper wallpaper;

    public WallpaperDetailFragment() {

    }

    public WallpaperDetailFragment(Wallpaper wallpaper) {
        this.wallpaper = wallpaper;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_detail, container, false);
        ImageView imgWallpaper = view.findViewById(R.id.img_wallpaper);
        TextView tvName = view.findViewById(R.id.tv_image_name);
        TextView tvAuthor = view.findViewById(R.id.tv_image_author);

        final Button btnSetWallpaper = view.findViewById(R.id.btn_set_as_wallpaper);
        if (wallpaper != null) {
            Glide.with(getContext()).load(wallpaper.getImage()).into(imgWallpaper);
            tvAuthor.setText(wallpaper.getAuthor());
            tvName.setText(wallpaper.getName());
        }
        btnSetWallpaper.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                WallpaperManager wallpaperManager = (WallpaperManager) getContext().getSystemService(Context.WALLPAPER_SERVICE);
                try {
                    wallpaperManager.setResource(wallpaper.getImage());
                    Snackbar.make(view, "Success!!", Snackbar.LENGTH_LONG).show();
                    btnSetWallpaper.setVisibility(View.INVISIBLE);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return false;
            }
        });
        return view;
    }
}

