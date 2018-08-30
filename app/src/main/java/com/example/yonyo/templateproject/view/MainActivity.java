package com.example.yonyo.templateproject.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.yonyo.templateproject.R;

public class MainActivity extends AppCompatActivity {

    private final String tag = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(tag, "on create");

        MainFragment mainFragment = MainFragment.newInstance();
        PlaygroundFragment playgroundFragment = PlaygroundFragment.Companion.newInstance();

        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, playgroundFragment).commitAllowingStateLoss();
    }
}
