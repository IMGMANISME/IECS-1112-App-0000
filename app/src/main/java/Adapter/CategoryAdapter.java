package Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_price = itemView.findViewById(R.id.tv_price);
            iv_meal = itemView.findViewById(R.id.iv_meal);
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
    }

    @Override
    public int getItemCount() {
        return itemlist.size();
    }

}
