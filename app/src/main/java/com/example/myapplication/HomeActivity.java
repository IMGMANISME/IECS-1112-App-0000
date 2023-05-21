package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import Adapter.CategoryAdapter;
import Domain.CategoryDomain;

public class HomeActivity extends AppCompatActivity {
  private RecyclerView recyclerView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home);
    if(getSupportActionBar() != null){
      getSupportActionBar().hide();
    }

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
}