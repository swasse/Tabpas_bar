package be.ehb.tabpasbar.fragments;


import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

import android.text.BoringLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import be.ehb.tabpasbar.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderFragment extends Fragment {

    private View.OnClickListener orderListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
            String locationKey = getResources().getString(R.string.pref_location);
            String selectedLocation = prefs.getString(locationKey, "Dilbeek");

            Toast.makeText(getActivity(), foodSpinner.getSelectedItem()+ " from "+selectedLocation+" confirmed", Toast.LENGTH_LONG).show();
        }
    };
    private Spinner foodSpinner;


    public OrderFragment() {
        // Required empty public constructor
    }

    public static OrderFragment newInstance(){
        return new OrderFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_order, container, false);

        //extra voor David
        foodSpinner = rootView.findViewById(R.id.sp_foods);
        String[] foods = {"patatas bravas", "patatas stoutas", "calamares"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.select_dialog_item, foods);
        foodSpinner.setAdapter(adapter);

        Button orderBtn = rootView.findViewById(R.id.btn_order);
        orderBtn.setOnClickListener(orderListener);

        return rootView;
    }

}
