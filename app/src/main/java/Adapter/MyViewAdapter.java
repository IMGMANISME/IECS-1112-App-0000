package Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import Fragment.ConfirmFragment;
import Fragment.ProcessFragment;
import Fragment.WaitFragment;
import Fragment.DoneFragment;

public class MyViewAdapter extends FragmentStateAdapter {
    public MyViewAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position){
            case 0:
                return new ConfirmFragment();
            case 1:
                return new ProcessFragment();
            case 2:
                return new WaitFragment();
            case 3:
                return new DoneFragment();
            default:
                return new ConfirmFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
