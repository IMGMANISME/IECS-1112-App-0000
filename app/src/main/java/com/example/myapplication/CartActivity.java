package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


import Adapter.CartAdapter;

import Item.CartItem;
import Manager.CartManager;

public class CartActivity extends AppCompatActivity {

    private ImageView iv_home;
    private ImageView iv_order;
    private ImageView iv_cart;
    private ImageView iv_profile;
    private Button btnGoToCheck;
    private RecyclerView recyclerViewList;
    private CartAdapter cartAdapter;
    private TextView total;
    private ScrollView scrollView;
    private List<CartItem> cartItemList;
    private int totalPrice = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        Intent intent = getIntent();
        int foodImg = intent.getIntExtra("food_img", 0);
        String foodName = intent.getStringExtra("food_name");
        int price = intent.getIntExtra("food_total", 0);


        iv_home = (ImageView) findViewById(R.id.iv_home);
        iv_order = (ImageView) findViewById(R.id.iv_order);
        iv_cart = (ImageView) findViewById(R.id.iv_cart);
        iv_profile = (ImageView) findViewById(R.id.iv_profile);
        btnGoToCheck = findViewById(R.id.btn_go_to_check);

        pageTransform();

        total = findViewById(R.id.tv_total);

        recyclerViewList = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);

        recyclerViewList.setLayoutManager(layoutManager);
        // 取得 CartManager 的實例並取得 cartItemList
        CartManager cartManager = CartManager.getInstance();
        cartItemList = cartManager.getCartItemList();

        cartAdapter = new CartAdapter(cartItemList);
        recyclerViewList.setAdapter(cartAdapter);

        // 計算總價
        calculateTotalPrice();

    }

    // 計算總價
    public void calculateTotalPrice() {
        int totalPrice = 0;
        for (CartItem item : cartItemList) {
            totalPrice += item.getItemPrice();
        }
        total.setText(String.valueOf("$"+totalPrice));
    }

    // 切換頁面
    public void pageTransform() {

        iv_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CartActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        iv_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CartActivity.this, OrderActivity.class);
                startActivity(intent);
            }
        });

        iv_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CartActivity.this, "已經在購物車界面", Toast.LENGTH_SHORT).show();
            }
        });

        iv_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CartActivity.this, PersonalProfileActivity.class);
                startActivity(intent);
            }
        });

        btnGoToCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CartActivity.this, CheckActivity.class);
                startActivity(intent);
            }
        });

    }

}

