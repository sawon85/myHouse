package com.example.myhouse;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.myhouse.House.HouseDetailActivity;
import com.example.myhouse.House.HouseVO;
import com.example.myhouse.Network.NetworkConstants;
import com.example.myhouse.Network.NetworkTask;
import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.CameraPosition;

import com.naver.maps.map.MapView;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.overlay.InfoWindow;
import com.naver.maps.map.overlay.Marker;
import com.naver.maps.map.overlay.Overlay;


public class Fragment_Map extends Fragment  implements OnMapReadyCallback {

    private MapView mapView;
    private NaverMap naverMap;
    private InfoWindow infoWindow;

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
        infoWindow = getInfoWindow("매물 정보 보기");
        getHouseByDong("관설동");

    }

    public void setDongMarker()
    {
        HouseVO house;
        for(int i=0; i<AppManager.getInstance().houseAdapter.houseVOs.size(); i++)
        {
            house = AppManager.getInstance().houseAdapter.houseVOs.get(i);
            getInfowindowMarker(house.x,house.y,house.houseNumber,80,140, String.valueOf(i));
            naverMap.setCameraPosition(new CameraPosition(new LatLng(house.x, house.y), 14.3));
        }
    }

    private InfoWindow getInfoWindow(final String describe)  // infowindow
    {
        InfoWindow infoWindow = new InfoWindow();
        renameInfoWindow(infoWindow, describe);
        infoWindow.setOnClickListener(new InfowindowClick());

        return infoWindow;
    }

    private void renameInfoWindow(InfoWindow infoWindow, String describe) {
        infoWindow.setAdapter(new InfoWindow.DefaultTextAdapter(getContext()) {
            @NonNull
            @Override
            public CharSequence getText(@NonNull InfoWindow infoWindow) {
                return describe;
            }

        });
    }
    private Marker getInfowindowMarker(double latitude, double longitude, String caption, int width, int height, String information) {

        Marker marker = getNormalMarker(latitude, longitude, caption, width, height);
        marker.setTag(information);
        marker.setOnClickListener(new MarkerClick());
        marker.setHideCollidedMarkers(false);
        marker.setHideCollidedCaptions(true);
        marker.setZIndex(300);
        return marker;
    }


    private Marker getNormalMarker(double latitude, double longitude, String caption, int width, int height) {
        Marker marker = new Marker();
        marker.setWidth(width);
        marker.setHeight(height);
        marker.setHideCollidedSymbols(true);
        marker.setHideCollidedMarkers(true);
        marker.setPosition(new LatLng(latitude, longitude));
        marker.setMap(naverMap);
        marker.setCaptionText(caption);

        marker.setOnClickListener(overlay -> {
            Marker mark = (Marker) overlay;
            naverMap.setCameraPosition(new CameraPosition(mark.getPosition(), 16));
            if (infoWindow.getMarker() != null) infoWindow.close();
            return true;
        });

        marker.setSubCaptionColor(Color.BLUE);
        marker.setSubCaptionTextSize(10);

        return marker;
    }


    class MarkerClick implements Overlay.OnClickListener { // 마커 클릭을 위한 리스너

        @Override
        public boolean onClick(@NonNull Overlay overlay) {
            Marker marker = (Marker) overlay;

            if (marker.getInfoWindow() == null) {
                infoWindow.open(marker);
                naverMap.setCameraPosition(new CameraPosition(marker.getPosition(), 16));

            } else {

                infoWindow.close();
            }

            return true;
        }
    }

    public void getHouseByDong(String dong){
        String url = "http://106.10.35.170/Hackaton/ImportHomeList.php";
        String dataStr = "dong=" + dong;
        NetworkTask networkTask = new NetworkTask(this.getContext(), url, dataStr, NetworkConstants.getHouseByDong);
        networkTask.execute();
    }

    class InfowindowClick implements Overlay.OnClickListener { // 정보창 클릭을 위한 리스너

        @Override
        public boolean onClick(@NonNull Overlay overlay) {
            InfoWindow infoWindow = (InfoWindow) overlay;
            Marker marker = infoWindow.getMarker();
            String information = (String) marker.getTag();


            Intent intent = new Intent(getActivity(), HouseDetailActivity.class);
            intent.putExtra("index", information);
            startActivity(intent);


            return true;
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

}
