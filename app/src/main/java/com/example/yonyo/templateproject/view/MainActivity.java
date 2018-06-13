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
        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, mainFragment).commitAllowingStateLoss();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(tag, "on start");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(tag, "on destroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v(tag, "on restart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(tag, "on pause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(tag, "on resume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(tag, "on stop");
    }
}
