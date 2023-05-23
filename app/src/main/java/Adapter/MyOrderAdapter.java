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

import Domain.OrderDomain;

public class MyOrderAdapter extends RecyclerView.Adapter<MyOrderAdapter.MyHolder> {

    List<OrderDomain> order_list;

    public MyOrderAdapter(List<OrderDomain> confirm_order_list) {
        this.order_list = confirm_order_list;
    }

    class MyHolder extends RecyclerView.ViewHolder{
        ImageView iv_order;
        TextView tv_date;
        TextView tv_price;
        TextView tv_status;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            tv_date = itemView.findViewById(R.id.tv_order_date);
            tv_price = itemView.findViewById(R.id.tv_order_price);
            tv_status = itemView.findViewById(R.id.tv_order_status);
            iv_order = itemView.findViewById(R.id.iv_order_img);
        }
    }

    @NonNull
    @Override
    public MyOrderAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_order_item,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyOrderAdapter.MyHolder holder, int position) {
        holder.tv_date.setText(order_list.get(position).getOrder_date());
        holder.tv_price.setText(order_list.get(position).getOrder_price());
        holder.tv_status.setText(order_list.get(position).getOrder_status());
        holder.iv_order.setImageResource(order_list.get(position).getOrder_pic());
    }

    @Override
    public int getItemCount() {
        return order_list.size();
    }
}
