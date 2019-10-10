package com.example.myhouse.House;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myhouse.R;


public class Fragment_card_detail extends Fragment {

    public static Fragment_card_detail newInstance(){
        Fragment_card_detail fragment = new Fragment_card_detail();
        return fragment;
    }

    public Fragment_card_detail ()
    {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_card_detail, container, false);
    }
}
