package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

  private TextView ArrowRight;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home);
    if(getSupportActionBar() != null){
      getSupportActionBar().hide();
    }

    ArrowRight = findViewById(R.id.btn_arrowright);
    ArrowRight.bringToFront();
  }
}