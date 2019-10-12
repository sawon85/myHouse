package com.example.myhouse.House;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.myhouse.AppManager;
import com.example.myhouse.R;
import com.example.myhouse.WebViewActivity;

import static android.view.View.*;


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

        view.setOnTouchListener( new OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if(motionEvent.getAction() == MotionEvent.ACTION_MOVE){
                    return false;
                }
                return false;
            }
        });

        LoanProductAdapter loanProductAdapter = new LoanProductAdapter(((HouseDetailActivity)getActivity()).house);
        ListView listView = view.findViewById(R.id.listView);
        Log.d("ㅁ이라ㅓ", loanProductAdapter.getCount()+"");
        listView.setAdapter(loanProductAdapter);
        Log.d("ㄱㄱㄱㄱssㄱㄱ", loanProductAdapter.getCount()+"");

        Log.d("ㄱㄱㄱㄱㄱㄱㄱ", loanProductAdapter.houseVO.description);
        Log.d("ㄱㄱㄱㄱㄱㄱㄱ", AppManager.getInstance().sortedAvailableLoans.get(0).getProductName());

        LinearLayout newlybtn = view.findViewById(R.id.newlyMarry);
        newlybtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra("URLString", "https://spot.wooribank.com/pot/Dream?withyou=POLON0055");
                startActivity(intent);
            }
        });

        LinearLayout youthbtn = view.findViewById(R.id.youth);
        youthbtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra("URLString", "https://bank.shinhan.com/index.jsp#020308100000");
                startActivity(intent);
            }
        });

        return view;
    }



}
