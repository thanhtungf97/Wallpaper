package com.entity.setwallpaper;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.entity.setwallpaper.fragment.WallpaperFragment;

public class MainActivity extends AppCompatActivity {
    private FragmentManager manager;
    private Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = getSupportFragmentManager();
        currentFragment = manager.findFragmentById(R.id.fl_content);
        if (currentFragment == null){
            manager.beginTransaction().replace(R.id.fl_content, new WallpaperFragment()).commit();
        }
    }
}
