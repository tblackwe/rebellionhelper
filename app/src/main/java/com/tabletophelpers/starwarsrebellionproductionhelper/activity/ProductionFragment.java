package com.tabletophelpers.starwarsrebellionproductionhelper.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.tabletophelpers.starwarsrebellionproductionhelper.R;
import com.tabletophelpers.starwarsrebellionproductionhelper.domain.Faction;
import com.tabletophelpers.starwarsrebellionproductionhelper.domain.GameSession;
import com.tabletophelpers.starwarsrebellionproductionhelper.domain.PlanetarySystemEnum;
import com.tabletophelpers.starwarsrebellionproductionhelper.domain.maps.ProductionMap;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by tblackwe on 7/5/16.
 */
public class ProductionFragment extends Fragment {


    GameSession gameSession;

    public static ProductionFragment newInstance(GameSession gameSession) {
        ProductionFragment fragment = new ProductionFragment();
        fragment.gameSession = gameSession;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.production_page, container, false);
        TextView textView = (TextView) view;
        textView.setText("");
        textView.setMovementMethod(new ScrollingMovementMethod());
        return view;
    }

    public void update() {
        View view = getView();

        TextView textView = (TextView) view;

        textView.setText("");
        for (Map.Entry<Faction, ProductionMap[]> entry : gameSession.getProduction().entrySet()) {
            textView.append(entry.getKey().name());
            textView.append(" Production:\n");
            for (int i = 0; i < 3; i++) {
                textView.append("\tQueue " + (i + 1) + ":\n");
                for (Map.Entry<String, Integer> productionEntry : entry.getValue()[i].entrySet()) {
                    textView.append("\t\t" + productionEntry.getValue() + " " + productionEntry.getKey() + "\n");
                }
            }
            textView.append("\n");
        }
    }

}
