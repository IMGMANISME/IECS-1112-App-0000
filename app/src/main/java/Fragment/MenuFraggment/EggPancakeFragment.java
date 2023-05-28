package Fragment.MenuFraggment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myapplication.DetailImformationActivity;
import com.example.myapplication.MenuActivity;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import Adapter.MenuAdapter;
import Domain.MenuDomain;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EggPancakeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EggPancakeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView menu_RecyclerView;

    List<MenuDomain> egg_pancake_list;
    public EggPancakeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EggPancakeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EggPancakeFragment newInstance(String param1, String param2) {
        EggPancakeFragment fragment = new EggPancakeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_egg_pancake, container, false);
        menu_RecyclerView = view.findViewById(R.id.rv_egg_pancake);

        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        menu_RecyclerView.setOverScrollMode(View.OVER_SCROLL_NEVER);
        menu_RecyclerView.setLayoutManager(layoutManager);
        egg_pancake_list = new ArrayList<>();
        egg_pancake_list.add(new MenuDomain(R.drawable.chinese_omelet_1,"玉米蛋餅","$30"));
        egg_pancake_list.add(new MenuDomain(R.drawable.chinese_omelet_2,"鮪魚蛋餅","$35"));
        egg_pancake_list.add(new MenuDomain(R.drawable.chinese_omelet_3,"起司蛋餅","$35"));
        egg_pancake_list.add(new MenuDomain(R.drawable.chinese_omelet_4,"培根蛋餅","$35"));
        menu_RecyclerView.setAdapter(new MenuAdapter(requireContext(),egg_pancake_list));

        // Inflate the layout for this fragment
        return view;
    }
}