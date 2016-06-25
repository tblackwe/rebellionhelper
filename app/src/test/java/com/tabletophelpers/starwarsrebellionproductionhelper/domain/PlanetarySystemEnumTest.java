package com.tabletophelpers.starwarsrebellionproductionhelper.domain;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by tblackwe on 6/21/16.
 */
public class PlanetarySystemEnumTest {


    @Test
    public void testGetProductionTypes() throws Exception {
        for (PlanetarySystemEnum planetarySystemEnum : PlanetarySystemEnum.values()) {
            System.out.println(Arrays.toString(planetarySystemEnum.getProductionTypes()));
        }
    }
}