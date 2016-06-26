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

        instance.getPlanetarySystems().get(PlanetarySystemEnum.MON_CALAMARI).setControlEnum(ControlEnum.REBEL);
        System.out.println(Arrays.toString(instance.getProduction().get(Faction.REBEL)));
        System.out.println(Arrays.toString(instance.getProduction().get(Faction.IMPERIAL)));

        instance.getPlanetarySystems().get(PlanetarySystemEnum.MON_CALAMARI).setControlEnum(ControlEnum.IMPERIAL);
        System.out.println(Arrays.toString(instance.getProduction().get(Faction.IMPERIAL)));

        instance.getPlanetarySystems().get(PlanetarySystemEnum.MON_CALAMARI).setControlEnum(ControlEnum.SUBJEGATED);
        System.out.println(Arrays.toString(instance.getProduction().get(Faction.IMPERIAL)));

        instance.getPlanetarySystems().get(PlanetarySystemEnum.MON_CALAMARI).setSabotaged(true);
        System.out.println(Arrays.toString(instance.getProduction().get(Faction.IMPERIAL)));

        instance.getPlanetarySystems().get(PlanetarySystemEnum.MON_CALAMARI).setSabotaged(false);
        System.out.println(Arrays.toString(instance.getProduction().get(Faction.IMPERIAL)));
        instance.getPlanetarySystems().get(PlanetarySystemEnum.MON_CALAMARI).setDestroyed(true);
        System.out.println(Arrays.toString(instance.getProduction().get(Faction.IMPERIAL)));
    }
}