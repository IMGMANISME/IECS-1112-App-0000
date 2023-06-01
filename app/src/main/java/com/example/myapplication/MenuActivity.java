package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import Adapter.MenuPagerAdapter;

public class MenuActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPage;
    private MenuPagerAdapter menuPagerAdapter;

    //private LinearLayout foodList;

    private ImageView iv_home;
    private ImageView iv_order;
    private ImageView iv_cart;
    private ImageView iv_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        iv_home = findViewById(R.id.menu_iv_home);
        iv_order = findViewById(R.id.menu_iv_order);
        iv_cart = findViewById(R.id.menu_iv_cart);
        iv_profile = findViewById(R.id.menu_iv_profile);

        pageTransform();

        tabLayout = findViewById(R.id.tab_layout);
        viewPage = findViewById(R.id.view_pager);
        menuPagerAdapter = new MenuPagerAdapter(this);
        viewPage.setUserInputEnabled(true);
        viewPage.setAdapter(menuPagerAdapter);

        // 設置 TabLayout 跟隨 ViewPager2
        viewPage.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                // 更新 TabLayout 的標籤
                tabLayout.getTabAt(position).select();
            }
        });

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPage.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        /*
        // 加载其他布局文件
        View rootView = getLayoutInflater().inflate(R.layout.activity_menu_item, null);
        LinearLayout rvEggPancake = rootView.findViewById(R.id.food_list);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId() == R.id.food_list){
                    Intent intent = new Intent(MenuActivity.this,DetailImformationActivity.class);
                    startActivity(intent);
                }
            }
        };

        rvEggPancake.setOnClickListener(onClickListener);
        */
    }

    // 切換頁面
    public void pageTransform(){
        iv_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });

        iv_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this,OrderActivity.class);
                startActivity(intent);
            }
        });

        iv_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this,CartActivity.class);
                startActivity(intent);
            }
        });

        iv_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this,PersonalProfileActivity.class);
                startActivity(intent);
            }
        });
    }

}