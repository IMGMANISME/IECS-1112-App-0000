package Fragment;

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

import Adapter.MyOrderAdapter;
import Domain.OrderDomain;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ConfirmFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ConfirmFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView order_RecyclerView;

    List<OrderDomain> confirm_order_list;

    public ConfirmFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ConfirmFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ConfirmFragment newInstance(String param1, String param2) {
        ConfirmFragment fragment = new ConfirmFragment();
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
        View view = inflater.inflate(R.layout.fragment_confirm, container, false);
        order_RecyclerView = view.findViewById(R.id.rv_done_order);

        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        order_RecyclerView.setOverScrollMode(View.OVER_SCROLL_NEVER);
        order_RecyclerView.setLayoutManager(layoutManager);
        confirm_order_list = new ArrayList<>();
        confirm_order_list.add(new OrderDomain(R.drawable.order_img_3,"2023/06/27","$170","已確認"));
        confirm_order_list.add(new OrderDomain(R.drawable.order_img_3,"2023/06/26","$175","已確認"));
        confirm_order_list.add(new OrderDomain(R.drawable.order_img_3,"2023/06/25","$100","已確認"));
        confirm_order_list.add(new OrderDomain(R.drawable.order_img_3,"2023/06/24","$160","已確認"));
        confirm_order_list.add(new OrderDomain(R.drawable.order_img_3,"2023/06/25","$100","已確認"));
        confirm_order_list.add(new OrderDomain(R.drawable.order_img_3,"2023/06/24","$160","已確認"));
        order_RecyclerView.setAdapter(new MyOrderAdapter(confirm_order_list));
        // Inflate the layout for this fragment
        return view;
    }
}