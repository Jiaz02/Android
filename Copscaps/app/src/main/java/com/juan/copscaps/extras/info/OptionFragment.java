package com.juan.copscaps.extras.info;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.juan.copscaps.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 */
public class OptionFragment extends Fragment {
    RecyclerView recyclerView;
    MyOptionRecyclerViewAdapter adapterOption;

    List<Option> opcionesList;

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public OptionFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static OptionFragment newInstance(int columnCount) {
        OptionFragment fragment = new OptionFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_option_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            opcionesList = new ArrayList<>();
            opcionesList.add(new Option(getResources().getString(R.string.cienenocho),getResources().getString(R.string.ciendescripcion)));
            opcionesList.add(new Option(getResources().getString(R.string.deadmatch),getResources().getString(R.string.deadmatchdescripcion)));

            adapterOption = new MyOptionRecyclerViewAdapter(getActivity(),opcionesList);
            recyclerView.setAdapter(adapterOption);
        }
        return view;
    }
}