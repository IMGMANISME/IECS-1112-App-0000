package Fragment.MenuFraggment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import Adapter.MenuAdapter;
import Domain.MenuDomain;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ComboFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ComboFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView menu_RecyclerView;

    List<MenuDomain> combo_list;
    public ComboFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ComboFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ComboFragment newInstance(String param1, String param2) {
        ComboFragment fragment = new ComboFragment();
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
        View view = inflater.inflate(R.layout.fragment_combo, container, false);
        menu_RecyclerView = view.findViewById(R.id.rv_combo);

        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        menu_RecyclerView.setOverScrollMode(View.OVER_SCROLL_NEVER);
        menu_RecyclerView.setLayoutManager(layoutManager);
        combo_list = new ArrayList<>();
        combo_list.add(new MenuDomain(R.drawable.meal_a,"Meal A","$100"));
        combo_list.add(new MenuDomain(R.drawable.order_img_1,"Meal B","$200"));
        combo_list.add(new MenuDomain(R.drawable.order_img_2,"Meal C","$300"));
        combo_list.add(new MenuDomain(R.drawable.order_img_3,"Meal D","$400"));
        menu_RecyclerView.setAdapter(new MenuAdapter(requireContext(),combo_list));

        // Inflate the layout for this fragment
        return view;
    }
}