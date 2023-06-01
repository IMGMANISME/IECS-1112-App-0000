package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import Adapter.CategoryAdapter;
import Domain.CategoryDomain;

public class HomeActivity extends AppCompatActivity {
  private RecyclerView recyclerView;
  // private ImageView iv_start;
  private ImageView iv_home;
  private ImageView iv_order;
  private ImageView iv_cart;
  private ImageView iv_profile;
  private ImageView iv_start;

  private Button btn_add;

  @SuppressLint({"WrongViewCast", "MissingInflatedId"})
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home);
    if(getSupportActionBar() != null){
      getSupportActionBar().hide();
    }

    iv_start = findViewById(R.id.iv_start);
    iv_home = findViewById(R.id.iv_home);
    iv_order = findViewById(R.id.iv_order);
    iv_cart = findViewById(R.id.iv_cart);
    iv_profile = findViewById(R.id.iv_profile);
    btn_add = findViewById(R.id.btn_meal_add);

    pageTransform();

    recyclerView = findViewById(R.id.rv_meal);

    LinearLayoutManager layoutManager = new LinearLayoutManager(this);
    layoutManager.setOrientation(RecyclerView.HORIZONTAL);
    recyclerView.setOverScrollMode(View.OVER_SCROLL_NEVER);
    recyclerView.setLayoutManager(layoutManager);

    recyclerView.setHasFixedSize(true);
    List<CategoryDomain> itemlist = new ArrayList<>();
    itemlist.add(new CategoryDomain("MealA","$100",R.drawable.meala));
    itemlist.add(new CategoryDomain("MealB","$200",R.drawable.mealb));
    itemlist.add(new CategoryDomain("MealC","$300",R.drawable.meala));
    itemlist.add(new CategoryDomain("MealD","$400",R.drawable.mealb));
    recyclerView.setAdapter(new CategoryAdapter(itemlist));

  }

  public void pageTransform(){

    iv_start.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(HomeActivity.this,MenuActivity.class);
        startActivity(intent);
      }
    });

    iv_home.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(HomeActivity.this,HomeActivity.class);
        startActivity(intent);
      }
    });

    iv_order.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(HomeActivity.this,OrderActivity.class);
        startActivity(intent);
      }
    });

    iv_cart.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(HomeActivity.this,CartActivity.class);
        startActivity(intent);
      }
    });

    iv_profile.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(HomeActivity.this,PersonalProfileActivity.class);
        startActivity(intent);
      }
    });
  }

}