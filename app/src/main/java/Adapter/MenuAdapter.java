package Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.DetailImformationActivity;
import com.example.myapplication.R;

import java.util.List;
import Domain.MenuDomain;
public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuHolder> {

    private Context context;
    private List<MenuDomain> menuList;

    public MenuAdapter(Context context, List<MenuDomain> menuList) {
        this.context = context;
        this.menuList = menuList;
    }

    class MenuHolder extends RecyclerView.ViewHolder {
        ImageView ivFoodImg;
        TextView tvFoodName;
        TextView tvFoodPrice;

        public MenuHolder(@NonNull View itemView) {
            super(itemView);
            ivFoodImg = itemView.findViewById(R.id.iv_food_img);
            tvFoodName = itemView.findViewById(R.id.tv_food_name);
            tvFoodPrice = itemView.findViewById(R.id.tv_food_price);
        }
    }

    @NonNull
    @Override
    public MenuHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_menu_item, parent, false);
        return new MenuHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuHolder holder, int position) {
        MenuDomain menu = menuList.get(position);
        holder.ivFoodImg.setImageResource(menu.getFood_img());
        holder.tvFoodName.setText(menu.getFood_name());
        holder.tvFoodPrice.setText(menu.getFood_price());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    MenuDomain menu = menuList.get(position);
                    // 在這裡執行項目點擊後的操作，例如跳轉到詳細資訊頁面
                    Intent intent = new Intent(context, DetailImformationActivity.class);
                    Toast.makeText(context, "查看"+menu.getFood_name(), Toast.LENGTH_SHORT).show();
                    // 傳遞相關資料到詳細資訊頁面
                    intent.putExtra("food_name", menu.getFood_name());
                    intent.putExtra("food_price", menu.getFood_price());
                    // 啟動詳細資訊頁面
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }
}