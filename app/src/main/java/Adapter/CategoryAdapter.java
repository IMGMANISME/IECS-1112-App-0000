package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.HomeActivity;
import com.example.myapplication.R;

import java.util.List;

import Domain.CategoryDomain;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyHolder>{

    List<CategoryDomain> itemlist;

    public CategoryAdapter(List<CategoryDomain> itemlist) {
        this.itemlist = itemlist;
    }

    class MyHolder extends RecyclerView.ViewHolder{
        TextView tv_name;
        TextView tv_price;
        ImageView iv_meal;

        Button btn_meal_add;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_price = itemView.findViewById(R.id.tv_price);
            iv_meal = itemView.findViewById(R.id.iv_meal);
            btn_meal_add = itemView.findViewById(R.id.btn_meal_add);
        }
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_horizontal_scroll_view,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.tv_name.setText(itemlist.get(position).getTitle());
        holder.tv_price.setText(itemlist.get(position).getPrice());
        holder.iv_meal.setImageResource(itemlist.get(position).getPic());
        holder.btn_meal_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 有成功但是沒辦法Toast出來
                int itemPosition = holder.getAdapterPosition();
                System.out.println("//////////////////");
                System.out.println(itemPosition);
                // Toast.makeText(CategoryAdapter,String.valueOf(itemPosition),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemlist.size();
    }

}
