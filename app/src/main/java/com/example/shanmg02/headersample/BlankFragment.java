package com.example.shanmg02.headersample;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class BlankFragment extends Fragment {


    private int position;
    private TextView textview;
    private PageListener listener;
    private AppBarLayout appBarLayout;

    public BlankFragment() {
    }

    public BlankFragment(int position) {
        this.position = position;
    }

    public static BlankFragment newInstance(int position) {
        return new BlankFragment(position);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (PageListener) getActivity();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textview = (TextView) view.findViewById(R.id.position);
        appBarLayout = (AppBarLayout) view.findViewById(R.id.applayout);
        textview.setText(String.valueOf(position));
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
             listener.onScrolled(verticalOffset);
            }
        });

    }



}
