package com.tabletophelpers.starwarsrebellionproductionhelper.domain;

import android.support.annotation.NonNull;

import com.tabletophelpers.starwarsrebellionproductionhelper.domain.maps.ImperialProduction;
import com.tabletophelpers.starwarsrebellionproductionhelper.domain.maps.ProductionMap;
import com.tabletophelpers.starwarsrebellionproductionhelper.domain.maps.RebelProduction;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Thomas on 6/25/2016.
 */
public class GameSession {

    private Map<PlanetarySystemEnum, PlanetarySystem> planetarySystems = new TreeMap<>();

    private RebelProduction rebelProduction = new RebelProduction();
    private ImperialProduction imperialProduction = new ImperialProduction();

    public GameSession() {
        for (PlanetarySystemEnum planetarySystemEnum : PlanetarySystemEnum.values()) {
            PlanetarySystem toAdd = new PlanetarySystem(planetarySystemEnum);

            if (PlanetarySystemEnum.CORUSCANT == planetarySystemEnum) {
                toAdd.setControlEnum(ControlEnum.IMPERIAL);
            }
            planetarySystems.put(planetarySystemEnum, toAdd);
        }
    }

    public Map<Faction, ProductionMap[]> getProduction() {
        Map<Faction, ProductionMap[]> retVal = new HashMap<>();

        retVal.put(Faction.REBEL, prepareProductionArrayMap());
        retVal.put(Faction.IMPERIAL, prepareProductionArrayMap());

        for (PlanetarySystem planetarySystem : planetarySystems.values()) {
            if (!planetarySystem.isDestroyed() && !planetarySystem.isSabotaged()) {
                PlanetarySystemEnum planetarySystemEnum = planetarySystem.planetarySystemEnum;
                final int arrayOffset = (planetarySystemEnum.buildQueue) - 1;
                switch (planetarySystem.getControlEnum()) {
                    case REBEL:
                        for (ProductionType productionType : planetarySystemEnum.getProductionTypes()) {
                            String product = rebelProduction.get(productionType);
                            retVal.get(Faction.REBEL)[arrayOffset].increment(product);
                        }
                        break;
                    case IMPERIAL:
                        for (ProductionType productionType : planetarySystemEnum.getProductionTypes()) {
                            String product = imperialProduction.get(productionType);
                            retVal.get(Faction.IMPERIAL)[arrayOffset].increment(product);
                        }
                        break;
                    case SUBJEGATED:
                        String product = imperialProduction.get(planetarySystemEnum.getProductionTypes()[0]);
                        retVal.get(Faction.IMPERIAL)[arrayOffset].increment(product);
                    default:
                        break;
                }
            }

        }
        return retVal;
    }

    @NonNull
    private ProductionMap[] prepareProductionArrayMap() {
        final ProductionMap[] productionMap = new ProductionMap[3];
        for (int i = 0; i < 3; i++) {
            productionMap[i] = new ProductionMap();
        }
        return productionMap;
    }

    public Map<PlanetarySystemEnum, PlanetarySystem> getPlanetarySystems() {
        return planetarySystems;
    }
}
