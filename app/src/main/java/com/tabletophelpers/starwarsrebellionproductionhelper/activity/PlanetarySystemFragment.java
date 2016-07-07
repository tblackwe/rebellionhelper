package com.tabletophelpers.starwarsrebellionproductionhelper.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.tabletophelpers.starwarsrebellionproductionhelper.R;
import com.tabletophelpers.starwarsrebellionproductionhelper.domain.ControlEnum;
import com.tabletophelpers.starwarsrebellionproductionhelper.domain.Faction;
import com.tabletophelpers.starwarsrebellionproductionhelper.domain.GameSession;
import com.tabletophelpers.starwarsrebellionproductionhelper.domain.PlanetarySystem;
import com.tabletophelpers.starwarsrebellionproductionhelper.domain.PlanetarySystemEnum;
import com.tabletophelpers.starwarsrebellionproductionhelper.domain.maps.ProductionMap;

import java.util.ArrayList;
import java.util.Map;

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

        ArrayAdapter<PlanetarySystemEnum> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Object item = adapterView.getAdapter().getItem(i);
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
                Log.i("THOMAS","Updated color for " + planetarySystemEnum + ". ");
                setBackGroundColor(view, planetarySystem.getControlEnum());


            }
        });
        return view;
    }

    private void setBackGroundColor(View view, ControlEnum controlEnum) {
        switch (controlEnum) {
            case REBEL:
                Log.i("THOMAS","New color is RED");
                view.setBackgroundColor(Color.RED);
                break;
            case IMPERIAL:
                Log.i("THOMAS","New color is BLUE");
                view.setBackgroundColor(Color.BLUE);
                break;
            case SUBJEGATED:
                Log.i("THOMAS","New color is CYAN");
                view.setBackgroundColor(Color.CYAN);
                break;
            case NONE:
            default:
                Log.i("THOMAS","New color is WHITE");
                view.setBackgroundColor(Color.WHITE);
                break;
        }
    }

    public void update() {
        ListAdapter adapter = listView.getAdapter();
        int planetCount = adapter.getCount();
        for (int i = 0; i < planetCount; i++) {
            Object item = adapter.getItem(i);
            PlanetarySystemEnum planetarySystemEnum = (PlanetarySystemEnum) item;
            setBackGroundColor(adapter.getView(i, null, listView), gameSession.getPlanetarySystems().get(planetarySystemEnum).getControlEnum());
        }
    }
}
