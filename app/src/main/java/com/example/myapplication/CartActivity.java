package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class CartActivity extends AppCompatActivity {


    private ImageView iv_home;
    private ImageView iv_order;
    private ImageView iv_cart;
    private ImageView iv_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        iv_home = (ImageView) findViewById(R.id.iv_home);
        iv_order = (ImageView) findViewById(R.id.iv_order);
        iv_cart = (ImageView) findViewById(R.id.iv_cart);
        iv_profile = (ImageView) findViewById(R.id.iv_profile);

        pageTransform();


    }

    // 切換頁面
    public void pageTransform(){
        iv_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CartActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });

        iv_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CartActivity.this,OrderActivity.class);
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
                Intent intent = new Intent(CartActivity.this,PersonalProfileActivity.class);
                startActivity(intent);
            }
        });
    }
}