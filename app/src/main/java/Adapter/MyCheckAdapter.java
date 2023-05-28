package Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.List;

import Domain.CheckDomain;

public class MyCheckAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<CheckDomain> check_list;

    private static final int VIEW_TYPE_NORMAL = 0;
    private static final int VIEW_TYPE_LAST_ITEM = 1;

    public MyCheckAdapter(List<CheckDomain> check_list) {
        this.check_list = check_list;
    }

    class MyHolder extends RecyclerView.ViewHolder {
        TextView tv_check_name;
        TextView tv_check_num;
        TextView tv_check_prices;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            tv_check_name = itemView.findViewById(R.id.tv_check_meal_name);
            tv_check_num = itemView.findViewById(R.id.tv_check_meal_num);
            tv_check_prices = itemView.findViewById(R.id.tv_check_meal_price);
        }
    }

    class MyHolder_btom extends RecyclerView.ViewHolder {
        TextView tv_check_name_botm;
        TextView tv_check_num_botm;
        TextView tv_check_prices_botm;

        public MyHolder_btom(@NonNull View itemView) {
            super(itemView);
            tv_check_name_botm = itemView.findViewById(R.id.tv_check_meal_name_botm);
            tv_check_num_botm = itemView.findViewById(R.id.tv_check_meal_num_botm);
            tv_check_prices_botm = itemView.findViewById(R.id.tv_check_meal_price_botm);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_NORMAL) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_med_check_meal, parent, false);
            return new MyHolder(view);
        } else if (viewType == VIEW_TYPE_LAST_ITEM) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_bottom_check_meal, parent, false);
            return new MyHolder_btom(view);
        }
        throw new IllegalArgumentException("Invalid view type: " + viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyHolder) {
            MyHolder normalHolder = (MyHolder) holder;
            int sum = check_list.get(position).getMeal_num() * check_list.get(position).getMeal_prices();

            normalHolder.tv_check_name.setText(check_list.get(position).getMeal_name());
            normalHolder.tv_check_num.setText("x" + Integer.toString(check_list.get(position).getMeal_num()));
            normalHolder.tv_check_prices.setText("$" + sum);
        } else if (holder instanceof MyHolder_btom) {
            MyHolder_btom bottomHolder = (MyHolder_btom) holder;
            int sum = check_list.get(position).getMeal_num() * check_list.get(position).getMeal_prices();

            bottomHolder.tv_check_name_botm.setText(check_list.get(position).getMeal_name());
            bottomHolder.tv_check_num_botm.setText("x" + Integer.toString(check_list.get(position).getMeal_num()));
            bottomHolder.tv_check_prices_botm.setText("$" + sum);
        }
    }

    @Override
    public int getItemCount() {
        return check_list.size();
    }

    @Override
    public int getItemViewType(int position) {
        // 如果是最後一項返回 VIEW_TYPE_LAST_ITEM，否則返回 VIEW_TYPE_NORMAL
        if (position == getItemCount() - 1) {
            return VIEW_TYPE_LAST_ITEM;
        }
        return VIEW_TYPE_NORMAL;
    }
}
