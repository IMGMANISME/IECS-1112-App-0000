package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Adapter.MyCheckAdapter;
import Adapter.MyOrderAdapter;
import Domain.CheckDomain;
import Domain.OrderDomain;

public class CheckActivity extends AppCompatActivity {

    private MyCheckAdapter myCheckAdapter;
    private TextView disconut;
    private TextView subtotal;

    private Button check_btn;

    private RecyclerView check_RecyclerView;

    private ScrollView scrollView;

    List<CheckDomain> checkDomainList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        disconut = findViewById(R.id.tv_check_discount);
        subtotal = findViewById(R.id.tv_check_subtotal);
        check_btn = findViewById(R.id.tv_checkout_submit);
        check_RecyclerView = findViewById(R.id.rv_check_meal_detail);
        scrollView = findViewById(R.id.rv_check_scroll);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        scrollView.setOverScrollMode(View.OVER_SCROLL_NEVER);

        check_RecyclerView.setNestedScrollingEnabled(false);
        check_RecyclerView.setFocusable(false);
        check_RecyclerView.setLayoutManager(new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                return false; // 禁用垂直滚动
            }
        });

        check_RecyclerView.setLayoutManager(layoutManager);
        checkDomainList = new ArrayList<>();
        checkDomainList.add(new CheckDomain("玉米蛋餅",5,25));
        checkDomainList.add(new CheckDomain("玉米蛋餅",5,25));
        checkDomainList.add(new CheckDomain("玉米蛋餅",5,25));
        checkDomainList.add(new CheckDomain("玉米蛋餅",5,25));
        checkDomainList.add(new CheckDomain("玉米蛋餅",5,25));
        checkDomainList.add(new CheckDomain("玉米蛋餅",5,25));

        int discount = -100;

        subtotal.setText("$" + getSubtotal(checkDomainList));
        disconut.setText("$" + discount);
        check_btn.setText("送出訂單 - $" + (getSubtotal(checkDomainList) + discount));
        check_RecyclerView.setAdapter(new MyCheckAdapter(checkDomainList));


        check_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CheckActivity.this,"訂單已送出",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(CheckActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });

    }

    public int getSubtotal(List<CheckDomain> check_list) {
        int subtotal = 0;

        for (int i = 0; i < check_list.size(); i++){
            int num = check_list.get(i).getMeal_num();
            int price = check_list.get(i).getMeal_prices();
            subtotal += num * price;
        }

        return subtotal;
    }
}