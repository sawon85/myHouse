package com.example.myhouse.House;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myhouse.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class HouseDetailActivity extends AppCompatActivity {

    private ViewGroup viewLayout;         // 레이아웃
    private LayoutInflater inflater;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ArrayList<Fragment> fList;

    private FragmentManager fm;
    boolean doesWantLoan = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_detail);

        //setContentView(R.layout.class_detail_page);

        //클래스 제목 부분을 바꿔준다
        TextView textView = findViewById(R.id.class_name);

        //이미지를 바꿔준다
        ImageView imageView = findViewById(R.id.class_main_image);

//        Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
//        imageView.setImageBitmap(bitmap);


        //지역구
        TextView textView1 = findViewById(R.id.class_area_intent);

        fm = getSupportFragmentManager();

        fList = new ArrayList<Fragment>();
        fList.add(Fragment_house_detail.newInstance());
        fList.add(Fragment_card_detail.newInstance());

        //탭

        tabLayout = findViewById(R.id.class_tabs);

        viewPager = findViewById(R.id.container_class);

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

        Button loanButton = (Button)findViewById(R.id.loan_button);

        loanButton.setOnClickListener( new Button.OnClickListener(){

            @Override
            public void onClick(View view) {

                if(doesWantLoan)
                {
                    doesWantLoan = false;
                    loanButton.setTextColor(Color.BLACK);
                    return;
                }

                doesWantLoan = true;
                loanButton.setBackgroundColor(Color.RED);

            }
        });


    }


    public void CounselingRequest(View view) {
    }
}
