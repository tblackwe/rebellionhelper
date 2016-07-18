package com.tabletophelpers.starwarsrebellionproductionhelper.activity;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.tabletophelpers.starwarsrebellionproductionhelper.R;
import com.tabletophelpers.starwarsrebellionproductionhelper.domain.ControlEnum;
import com.tabletophelpers.starwarsrebellionproductionhelper.domain.GameSession;
import com.tabletophelpers.starwarsrebellionproductionhelper.domain.PlanetarySystemEnum;

import java.util.ArrayList;

/**
 * Created by Thomas on 7/7/2016.
 */
public class PlanetarySystemAdapter extends ArrayAdapter<PlanetarySystemEnum> {

    GameSession gameSession;


    public PlanetarySystemAdapter(Context context, ArrayList<PlanetarySystemEnum> planets, GameSession gameSession) {
        super(context, android.R.layout.simple_list_item_1, planets);
        this.gameSession = gameSession;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PlanetarySystemEnum planetarySystemEnum = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.planetary_system, parent, false);
        }
        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
        TextView tvControl = (TextView) convertView.findViewById(R.id.tvControl);
        // Populate the data into the template view using the data object
        tvName.setText(planetarySystemEnum.cleanName());
        final ControlEnum controlEnum = gameSession.getPlanetarySystems().get(planetarySystemEnum).getControlEnum();
        tvControl.setText(controlEnum.name());
        switch (controlEnum){
            case NONE:
                tvControl.setText("");
                tvControl.setTextColor(Color.BLACK);
                break;
            case REBEL:
                tvControl.setTextColor(Color.RED);
                break;
            case SABOTAGED:
                tvControl.setTextColor(Color.GRAY);
                break;
            default:
                tvControl.setTextColor(Color.BLUE);
        }
        // Return the completed view to render on screen
        return convertView;
    }
}
