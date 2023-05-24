package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class GetStartActivity extends AppCompatActivity {

    private Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_start);
        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        this.btnStart = findViewById(R.id.btn_start);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId() == R.id.btn_start){
                    Intent intent = new Intent(GetStartActivity.this, HomeActivity.class);
                    startActivity(intent);
                    Toast.makeText(GetStartActivity.this, "開始點餐", Toast.LENGTH_SHORT).show();
                }
            }
        };
        btnStart.setOnClickListener(listener);
    }
}