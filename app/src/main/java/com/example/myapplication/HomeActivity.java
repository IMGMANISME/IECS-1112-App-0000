package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import Adapter.CategoryAdaptor;
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

    recyclerView = findViewById(R.id.recycle);

    LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
    recyclerView.setLayoutManager(layoutManager);

    ArrayList<CategoryDomain> category = new ArrayList<>();
    category.add(new CategoryDomain("Meal A","$ 100","meala"));
    category.add(new CategoryDomain("Meal B","$ 250","mealb"));

    CategoryAdaptor adaptor = new CategoryAdaptor(this, category);
    recyclerView.setAdapter(recyclerView.getAdapter());

  }
}