package com.example.yonyo.templateproject.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yonyo.templateproject.R;
import com.example.yonyo.templateproject.model.OrangeLambda;

import kotlin.Unit;

public class PlaygroundFragmentJava extends Fragment {

    public static PlaygroundFragmentJava newInstance() {

        Bundle args = new Bundle();

        PlaygroundFragmentJava fragment = new PlaygroundFragmentJava();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        OrangeLambda orangeLambda = new OrangeLambda();
        orangeLambda.setName(() -> "2");
        orangeLambda.setConsumerName(v -> {

            return Unit.INSTANCE;
        });

        orangeLambda.triggerLambda();
        System.out.println("Orange lambda value : "+orangeLambda.getName().invoke());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_anchor, container, false);
    }
}
