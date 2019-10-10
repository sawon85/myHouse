package com.example.myhouse.House;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.example.myhouse.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_house_detail extends Fragment {


    public static Fragment_house_detail newInstance(){
        Fragment_house_detail fragment = new Fragment_house_detail();
        return fragment;
    }

    public Fragment_house_detail() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_house_detail, container, false);

        view.setOnTouchListener( new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if(motionEvent.getAction() == MotionEvent.ACTION_MOVE){
                    return false;
                }
                return false;
            }
        });

        return view;
    }



}
