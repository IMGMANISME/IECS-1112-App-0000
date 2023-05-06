package Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.List;

import Domain.CategoryDomain;

public class CategoryAdaptor extends BaseAdapter {

    private Context context;
    private List<CategoryDomain> listfood;

    public CategoryAdaptor(Context context,List<CategoryDomain> listfood) {
        this.context = context;
        this.listfood = listfood;
    }

    @Override
    public int getCount() {
        return listfood.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("ResourceType")
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.id.mainLayout,parent,false);
        }

        String imageName = "image_name";
        int resourceId = context.getResources().getIdentifier(imageName, "drawable", context.getPackageName());

        ImageView imageView = view.findViewById(R.id.imageView);
        imageView.setImageResource(resourceId);

        CategoryDomain categoryDomain = listfood.get(position);
        ImageView iv = view.findViewById(R.id.categoryPic);
        iv.setImageResource(resourceId);

        TextView tvfoodName = view.findViewById(R.id.categoryName);
        tvfoodName.setText(categoryDomain.getTitle());

        TextView tvfoodPrice = view.findViewById(R.id.category_price);
        tvfoodPrice.setText(categoryDomain.getPrice());
        return view;
    }
}
