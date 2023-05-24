package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

import Adapter.CategoryAdapter;
import Adapter.MyOrderAdapter;
import Adapter.MyViewAdapter;
import Domain.CategoryDomain;
import Domain.OrderDomain;

public class OrderActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private MyViewAdapter myViewAdapter;

    private ImageView iv_home;
    private ImageView iv_order;
    private ImageView iv_cart;
    private ImageView iv_profile;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        iv_home = findViewById(R.id.iv_home);
        iv_order = findViewById(R.id.iv_order);
        iv_cart = findViewById(R.id.iv_cart);
        iv_profile = findViewById(R.id.iv_profile);

        pageTransform();

        tabLayout = findViewById(R.id.tab_layout);
        viewPager2 = findViewById(R.id.view_pager);
        myViewAdapter = new MyViewAdapter(this);
        viewPager2.setUserInputEnabled(true);
        viewPager2.setAdapter(myViewAdapter);


        // 設置 TabLayout 跟隨 ViewPager2
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
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
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    public void pageTransform(){
        iv_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });

        iv_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderActivity.this,OrderActivity.class);
                startActivity(intent);
            }
        });

        iv_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderActivity.this,CartActivity.class);
                startActivity(intent);
            }
        });

        iv_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderActivity.this,PersonalProfileActivity.class);
                startActivity(intent);
            }
        });
    }
}