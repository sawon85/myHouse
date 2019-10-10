package com.example.myhouse.House;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.myhouse.R;
import com.google.android.material.tabs.TabLayout;

public class HouseDetailActivity extends AppCompatActivity {

    private ViewGroup viewLayout;         // 레이아웃
    private LayoutInflater inflater;

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_detail);

        setContentView(viewLayout);
        //setContentView(R.layout.class_detail_page);

        //클래스 제목 부분을 바꿔준다
        TextView textView = findViewById(R.id.class_name);
        textView.setText(getIntent().getStringExtra("param"));

        //이미지를 바꿔준다
        byte[] byteArray = getIntent().getByteArrayExtra("image");
        ImageView imageView = findViewById(R.id.class_main_image);




        //지역구
        TextView textView1 = findViewById(R.id.class_area_intent);
        textView1.setText(getIntent().getStringExtra("area"));

        //탭

        tabLayout = findViewById(R.id.class_tabs);

        viewPager = findViewById(R.id.container_class);

        TabPagerAdapter tabPagerAdapter = new TabPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
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

    }

    public void RentButtonClicked(View view) {
    }

    public void CounselingRequest(View view) {
    }
}
