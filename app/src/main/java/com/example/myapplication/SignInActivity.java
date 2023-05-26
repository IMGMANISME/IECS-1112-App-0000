package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignInActivity extends AppCompatActivity {

    private Button btnSignIn;
    private TextView btnSignUp;

    private EditText etPhoneNum;
    private EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        btnSignIn = findViewById(R.id.btn_signin);
        btnSignUp = findViewById(R.id.tv_signup);
        etPhoneNum = findViewById(R.id.et_signin_phnum);
        etPassword = findViewById(R.id.et_signin_pw);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId() == R.id.btn_signin){
                    String username = etPhoneNum.getText().toString();
                    String password = etPassword.getText().toString();

                    if(username.isEmpty() || password.isEmpty()){
                        Toast.makeText(SignInActivity.this, "Please enter phone number and  password", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    SharedPreferences sharedPreferences = getSharedPreferences("user_info", MODE_PRIVATE);
                    String sharedUserName = sharedPreferences.getString("username","");
                    String sharedPassword = sharedPreferences.getString("password","");
                    if (username.equals(sharedUserName) && password.equals(sharedPassword)) {
                        sharedPreferences.edit().putBoolean("signed_in", true).apply();
                        Intent intent = new Intent(SignInActivity.this,HomeActivity.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(SignInActivity.this, "Invalid phone number or password", Toast.LENGTH_SHORT).show();
                    }
                } else if (view.getId() == R.id.tv_signup) {
                    Intent intent = new Intent(SignInActivity.this,RegisActivity.class);
                    startActivity(intent);
                }
            }
        };

        btnSignIn.setOnClickListener(onClickListener);
        btnSignUp.setOnClickListener(onClickListener);

    }
}