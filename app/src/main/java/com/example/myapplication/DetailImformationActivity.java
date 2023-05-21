package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailImformationActivity extends AppCompatActivity {

    private ImageView imFood;
    private TextView tvTitle;
    private CheckBox cbEgg;
    private CheckBox cbIngredients;
    private CheckBox cbOnion;
    private EditText etNote;
    private Button btnsub;
    private TextView tvAmountNumber;
    private Button btnadd;
    private TextView tvTotal;
    private Button btnAddToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_imformation);
        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        imFood = findViewById(R.id.im_food);
        tvTitle = findViewById(R.id.tv_title);
        cbEgg = findViewById(R.id.cb_egg);
        cbIngredients = findViewById(R.id.cb_ingredients);
        cbOnion = findViewById(R.id.cb_onion);
        etNote = findViewById(R.id.et_note);
        btnsub = findViewById(R.id.btn_sub);
        btnadd = findViewById(R.id.btn_add);
        tvAmountNumber = findViewById(R.id.tv_amount_number);
        tvTotal = findViewById(R.id.tv_total);
        btnAddToCart = findViewById(R.id.btn_add_to_cart);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            int amount = Integer.parseInt(tvAmountNumber.getText().toString());
            int total = Integer.parseInt(tvTotal.getText().toString());
            int price = total;
            @Override
            public void onClick(View v) {

                switch (v.getId()){
                    case R.id.cb_egg:
                        if(cbEgg.isChecked()){
                            price += 10;
                        }else{
                            price -= 10;
                        }
                        break;

                    case R.id.cb_ingredients:
                        if(cbIngredients.isChecked()){
                            price += 10;
                        }else{
                            price -= 10;
                        }
                        break;

                    case R.id.cb_onion:
                        if(cbOnion.isChecked()){
                            price += 5;
                        }else{
                            price -= 5;
                        }
                        break;

                    case R.id.btn_sub:
                        if (amount <= 0){
                            Toast.makeText(DetailImformationActivity.this, "數量不可小於0", Toast.LENGTH_SHORT).show();
                        }else {
                            amount--;
                        }
                        break;

                    case R.id.btn_add:
                        amount++;
                        break;

                    case R.id.btn_add_to_cart:
                        Toast.makeText(DetailImformationActivity.this, "共"+total+"元，已加入購物車", Toast.LENGTH_SHORT).show();
                        break;
                }
                total = price * amount;
                tvAmountNumber.setText(String.valueOf(amount));
                tvTotal.setText(String.valueOf(total));
            }
        };

        cbEgg.setOnClickListener(onClickListener);
        cbIngredients.setOnClickListener(onClickListener);
        cbOnion.setOnClickListener(onClickListener);
        btnsub.setOnClickListener(onClickListener);
        btnadd.setOnClickListener(onClickListener);
        btnAddToCart.setOnClickListener(onClickListener);
    }
}