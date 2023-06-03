package Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.CartActivity;
import com.example.myapplication.R;

import Item.CartItem;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private List<CartItem> cartItemList;

    public CartAdapter(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_cart, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        CartItem cartItem = cartItemList.get(position);
        holder.ivFoodImg.setImageResource(cartItem.getItemImg());
        holder.tvFoodName.setText(cartItem.getItemName());
        holder.tvFoodPrice.setText("$"+String.valueOf(cartItem.getItemPrice()));
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentPosition = holder.getAdapterPosition();
                if (currentPosition != RecyclerView.NO_POSITION) {
                    // 在此執行刪除操作
                    cartItemList.remove(currentPosition);
                    notifyItemRemoved(currentPosition);

                    // 在這裡通知 CartActivity 重新計算並更新總價
                    ((CartActivity) v.getContext()).calculateTotalPrice();
                }

            }
        });
    }



    @Override
    public int getItemCount() {
        return cartItemList.size();
    }

    public void updateData(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
        notifyDataSetChanged();
    }

    public static class CartViewHolder extends RecyclerView.ViewHolder {
        ImageView ivFoodImg;
        TextView tvFoodName;
        TextView tvFoodPrice;
        TextView tvTotal;
        Button btnDelete;
        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFoodImg = itemView.findViewById(R.id.iv_item_img);
            tvFoodName = itemView.findViewById(R.id.tv_item_name);
            tvFoodPrice = itemView.findViewById(R.id.tv_item_price);
            tvTotal = itemView.findViewById(R.id.tv_total);
            btnDelete = itemView.findViewById(R.id.btn_delete);
        }
    }
}

