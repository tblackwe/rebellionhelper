package com.tabletophelpers.starwarsrebellionproductionhelper.domain;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Thomas on 6/25/2016.
 */
public class GameSessionTest {

    GameSession instance = new GameSession();

    @Test
    public void testGetProduction() throws Exception {

        for (PlanetarySystemEnum planetarySystemEnum : PlanetarySystemEnum.values()) {
            if (0 < planetarySystemEnum.buildQueue) {
                if ((planetarySystemEnum.name().length() & 1) != 0) {
                    instance.planetarySystems.get(planetarySystemEnum.name()).setControlEnum(ControlEnum.REBEL);
                } else {
                    instance.planetarySystems.get(planetarySystemEnum.name()).setControlEnum(ControlEnum.IMPERIAL);
                }
            }
            instance.planetarySystems.get(PlanetarySystemEnum.CORUSCANT.name()).setSabotaged(true);
            instance.planetarySystems.get(PlanetarySystemEnum.ALDERAAN.name()).setDestroyed(true);
            instance.planetarySystems.get(PlanetarySystemEnum.KASHYYYK.name()).setControlEnum(ControlEnum.SUBJEGATED);
        }

        System.out.println(Arrays.toString(instance.getProduction().get(Faction.REBEL)));
        System.out.println(Arrays.toString(instance.getProduction().get(Faction.IMPERIAL)));

    }
}