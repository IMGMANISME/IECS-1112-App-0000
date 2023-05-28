package Adapter;

import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.myapplication.R;

import Fragment.MenuFraggment.EggPancakeFragment;
import Fragment.MenuFraggment.BurgerFragment;
import Fragment.MenuFraggment.DrinkFragment;
import Fragment.MenuFraggment.ComboFragment;

public class MenuPagerAdapter extends FragmentStateAdapter {
    public MenuPagerAdapter(@NonNull FragmentActivity fa) {
        super(fa);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new EggPancakeFragment();
            case 1:
                return new BurgerFragment();
            case 2:
                return new DrinkFragment();
            case 3:
                return new ComboFragment();
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
