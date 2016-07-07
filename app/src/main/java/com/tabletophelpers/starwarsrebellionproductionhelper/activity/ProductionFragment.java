package com.tabletophelpers.starwarsrebellionproductionhelper.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.tabletophelpers.starwarsrebellionproductionhelper.R;
import com.tabletophelpers.starwarsrebellionproductionhelper.domain.GameSession;
import com.tabletophelpers.starwarsrebellionproductionhelper.domain.PlanetarySystemEnum;

import java.util.ArrayList;

/**
 * Created by tblackwe on 7/5/16.
 */
public class ProductionFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;

    GameSession gameSession = new GameSession();

    public static ProductionFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        ProductionFragment fragment = new ProductionFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, container, false);
        ListView listView = (ListView) view;

        ArrayList<String> items = new ArrayList<>();

        for (PlanetarySystemEnum pse : gameSession.getPlanetarySystems().keySet()) {
            items.add(pse.cleanName());
        }


        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);
        return view;
    }
}
