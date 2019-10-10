package com.example.myhouse.House;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class HouseAdapter extends BaseAdapter {
    public ArrayList<HouseVO> houseVOs;

    public HouseAdapter(){
        houseVOs = new ArrayList<>();
    }

    public HouseAdapter(ArrayList<HouseVO> houseVOs){
        this.houseVOs = houseVOs;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return houseVOs.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }

    public ArrayList<HouseVO> getDongHouses(String dong){
        ArrayList<HouseVO> dongHouseVOs = new ArrayList<>();
        for(int i=0; i<houseVOs.size(); i++){
            if (houseVOs.get(i).administrationArea.equals("dong")){
                dongHouseVOs.add(houseVOs.get(i));
            }
        }
        return dongHouseVOs;
    }
}
