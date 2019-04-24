package com.entity.setwallpaper.fragment;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.entity.setwallpaper.R;
import com.entity.setwallpaper.adapter.WallpaperAdapter;
import com.entity.setwallpaper.listener.OnItemClick;
import com.entity.setwallpaper.model.Wallpaper;

import java.util.ArrayList;
import java.util.List;

public class WallpaperFragment extends Fragment implements OnItemClick {

    private List<Wallpaper> wallpaperList;
    private WallpaperAdapter adapter;
    private ConstraintLayout actionBar;
    private View view;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_list, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.rc_wallpaper);
        wallpaperList = new ArrayList<>();
        wallpaperList.add(new Wallpaper(R.drawable.january, "January", "Material Design"));
        wallpaperList.add(new Wallpaper(R.drawable.february, "February", "Material Design"));
        wallpaperList.add(new Wallpaper(R.drawable.march, "March", "Material Design"));
        wallpaperList.add(new Wallpaper(R.drawable.april, "April", "Material Design"));
        wallpaperList.add(new Wallpaper(R.drawable.may, "May", "Material Design"));
        wallpaperList.add(new Wallpaper(R.drawable.june, "June", "Material Design"));
        wallpaperList.add(new Wallpaper(R.drawable.july, "July", "Material Design"));
        wallpaperList.add(new Wallpaper(R.drawable.august, "August", "Material Design"));
        wallpaperList.add(new Wallpaper(R.drawable.september, "September", "Material Design"));
        wallpaperList.add(new Wallpaper(R.drawable.october, "October", "Material Design"));
        wallpaperList.add(new Wallpaper(R.drawable.november, "November", "Material Design"));
        wallpaperList.add(new Wallpaper(R.drawable.december, "December", "Material Design"));

        adapter = new WallpaperAdapter(wallpaperList, getContext(), this);
        GridLayoutManager manager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);


        actionBar = view.findViewById(R.id.actionbar);
        return view;

    }

    @TargetApi(Build.VERSION_CODES.M)
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)

    @Override
    public void onClick(int position) {
        WallpaperDetailFragment detailFragment = new WallpaperDetailFragment(wallpaperList.get(position));
        this.setExitTransition(TransitionInflater.from(getContext()).inflateTransition(android.R.transition.explode).removeTarget(actionBar));
        detailFragment.setEnterTransition(TransitionInflater.from(getContext()).inflateTransition(android.R.transition.fade));
        getActivity().getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fl_content, detailFragment).commit();
    }
}
