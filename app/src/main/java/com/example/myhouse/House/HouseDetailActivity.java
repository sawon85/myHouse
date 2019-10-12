package com.example.myhouse.House;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myhouse.AppManager;
import com.example.myhouse.R;
import com.example.myhouse.WebViewActivity;
import com.example.myhouse.graphActivity;
import com.example.myhouse.user.UserVO;
import com.google.android.material.tabs.TabLayout;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class HouseDetailActivity extends AppCompatActivity {

    private ViewGroup viewLayout;         // 레이아웃
    private LayoutInflater inflater;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ArrayList<Fragment> fList;

    private FragmentManager fm;
    boolean doesWantLoan = false;

    public HouseVO house;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_detail);

        Intent intent = getIntent();
        int index = Integer.parseInt(intent.getStringExtra("index"));
        house = AppManager.getInstance().houseAdapter.houseVOs.get(index);

        //대출해야 할 보증금
        int loanDeposit = house.deposit - UserVO.getInstance().deposit;
        float list[] = {1.0f, 1.0f,1.0f,1.0f,1.0f,1.0f,1.0f,1.0f};
        ArrayList<Float> interests = new ArrayList<>();
        for(int i=0; i<AppManager.getInstance().loanProducts.size(); i++){
            AppManager.getInstance().loanProducts.get(i).setUserData(UserVO.getInstance());
            if(AppManager.getInstance().loanProducts.get(i).isEnable()){
                AppManager.getInstance().availableLoans.add(AppManager.getInstance().loanProducts.get(i));
                interests.add(AppManager.getInstance().loanProducts.get(i).getInterestRate());
                list[i] = AppManager.getInstance().loanProducts.get(i).getInterestRate();
            }
        }

        Arrays.sort(list);

        for(int i=0; i<AppManager.getInstance().availableLoans.size(); i++){
            for(int j=0; j<AppManager.getInstance().availableLoans.size(); j++) {
                if (list[i] == AppManager.getInstance().availableLoans.get(j).getInterestRate()) {
                    if(AppManager.getInstance().sortedAvailableLoans.contains(AppManager.getInstance().availableLoans.get(j)))
                        continue;
                    AppManager.getInstance().sortedAvailableLoans.add(AppManager.getInstance().availableLoans.get(j));
                    break;
                }
            }
        }

        for(int i=0; i<AppManager.getInstance().sortedAvailableLoans.size(); i++){
            if(loanDeposit > 0){
                loanDeposit -= AppManager.getInstance().sortedAvailableLoans.get(i).getLimit();
                AppManager.getInstance().sortedAvailableLoans.get(i).setRecommand(true);
            }
        }


        //setContentView(R.layout.class_detail_page);

        //클래스 제목 부분을 바꿔준다
        ((TextView)findViewById(R.id.class_name)).setText(house.name + " " + house.block+"동 " + house.unit + "호" );

        //이미지를 바꿔준다
        ImageView imageView = findViewById(R.id.class_main_image);


        //지역구
        ((TextView)findViewById(R.id.dong)).setText(house.administrationArea );

        fm = getSupportFragmentManager();

        fList = new ArrayList<Fragment>();
        fList.add(Fragment_house_detail.newInstance());
        fList.add(Fragment_card_detail.newInstance());

        //탭
        tabLayout = findViewById(R.id.class_tabs);

        viewPager = findViewById(R.id.container_class);
        viewPager.setOnTouchListener(new ViewPager.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        });

        TabPagerAdapter tabPagerAdapter = new TabPagerAdapter(getSupportFragmentManager(), fList);
        viewPager.setAdapter(tabPagerAdapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

//        Button loanButton = (Button)findViewById(R.id.loan_button);
//
//        loanButton.setOnClickListener( new Button.OnClickListener(){
//
//            @Override
//            public void onClick(View view) {
//
//                if(doesWantLoan)
//                {
//                    doesWantLoan = false;
//                    loanButton.setTextColor(Color.BLACK);
//                    return;
//                }
//
//                doesWantLoan = true;
//                loanButton.setBackgroundColor(Color.RED);
//            }
//        });


    }


//    public void CounselingRequest(View view) {
//
//        Intent intent = new Intent(getApplication(), WebViewActivity.class);
//        intent.putExtra("URLString", "http://naver.com");
//        startActivity(intent);
//    }
}
