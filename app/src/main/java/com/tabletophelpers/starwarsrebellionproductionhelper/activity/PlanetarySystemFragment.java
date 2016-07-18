package com.tabletophelpers.starwarsrebellionproductionhelper.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.tabletophelpers.starwarsrebellionproductionhelper.R;
import com.tabletophelpers.starwarsrebellionproductionhelper.domain.ControlEnum;
import com.tabletophelpers.starwarsrebellionproductionhelper.domain.GameSession;
import com.tabletophelpers.starwarsrebellionproductionhelper.domain.PlanetarySystem;
import com.tabletophelpers.starwarsrebellionproductionhelper.domain.PlanetarySystemEnum;

import java.util.ArrayList;

/**
 * Created by tblackwe on 7/5/16.
 */
public class PlanetarySystemFragment extends Fragment {

    GameSession gameSession;
    private ListView listView;

    public static PlanetarySystemFragment newInstance(GameSession gameSession) {
        PlanetarySystemFragment fragment = new PlanetarySystemFragment();
        fragment.gameSession = gameSession;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.planetary_system_page, container, false);
        listView = (ListView) view;

        ArrayList<PlanetarySystemEnum> items = new ArrayList<>();

        for (PlanetarySystemEnum pse : gameSession.getPlanetarySystems().keySet()) {
            items.add(pse);
        }

        listView.setCacheColorHint(Color.TRANSPARENT);
        final ArrayAdapter<PlanetarySystemEnum> adapter = new PlanetarySystemAdapter(getActivity(), items, gameSession);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final Adapter adapterViewAdapter = adapterView.getAdapter();
                Object item = adapterViewAdapter.getItem(i);
                PlanetarySystemEnum planetarySystemEnum = (PlanetarySystemEnum) item;

                PlanetarySystem planetarySystem = gameSession.getPlanetarySystems().get(planetarySystemEnum);

                switch (planetarySystem.getControlEnum()) {
                    case NONE:
                        planetarySystem.setControlEnum(ControlEnum.REBEL);
                        break;
                    case REBEL:
                        planetarySystem.setControlEnum(ControlEnum.IMPERIAL);
                        break;
                    case IMPERIAL:
                        planetarySystem.setControlEnum(ControlEnum.SUBJEGATED);
                        break;
                    case SUBJEGATED:
                        planetarySystem.setControlEnum(ControlEnum.SABOTAGED);
                        break;
                    default:
                        planetarySystem.setControlEnum(ControlEnum.NONE);
                        break;
                }
                adapter.notifyDataSetChanged();
            }

        });

        return view;
    }
}
