package com.tabletophelpers.starwarsrebellionproductionhelper;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.tabletophelpers.starwarsrebellionproductionhelper.domain.ControlEnum;
import com.tabletophelpers.starwarsrebellionproductionhelper.domain.PlanetarySystem;
import com.tabletophelpers.starwarsrebellionproductionhelper.domain.PlanetarySystemEnum;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.planetList);

        List<PlanetarySystem> planets = loadPlanets();


        ArrayAdapter<PlanetarySystem> itemsAdapter = new ArrayAdapter<PlanetarySystem>(this, android.R.layout.simple_list_item_1, planets);

        listView.setAdapter(itemsAdapter);

    }

    @NonNull
    private ArrayList<PlanetarySystem> loadPlanets() {
        ArrayList<PlanetarySystem> planetarySystems = new ArrayList<>();

        return planetarySystems;
    }
}
