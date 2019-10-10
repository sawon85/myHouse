package com.example.myhouse;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.myhouse.Network.NetworkConstants;
import com.example.myhouse.Network.NetworkTask;
import com.naver.maps.map.MapView;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;


public class Fragment_Map extends Fragment  implements OnMapReadyCallback {

    private MapView mapView;
    private NaverMap naverMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view,
                              Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapView = view.findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);

        mapView.getMapAsync(this);


    }

    @Override
    public void onMapReady(@NonNull NaverMap naverMap) {

        this.naverMap = naverMap;

    }

    public void getHouseByDong(String dong){
        String url = "http://106.10.35.170/ImportHomeList.php";
        String dataStr = "dong=" + dong;
        NetworkTask networkTask = new NetworkTask(this.getContext(), url, dataStr, NetworkConstants.getHouseByDong);
        networkTask.execute();
    }


}
