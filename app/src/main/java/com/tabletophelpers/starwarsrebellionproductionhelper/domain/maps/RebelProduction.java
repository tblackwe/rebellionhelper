package com.tabletophelpers.starwarsrebellionproductionhelper.domain.maps;

import com.tabletophelpers.starwarsrebellionproductionhelper.domain.ProductionType;

import java.util.HashMap;

/**
 * Created by Thomas on 6/25/2016.
 */
public class RebelProduction extends HashMap<ProductionType, String> {

    public RebelProduction() {

        this.put(ProductionType.LIGHT_SPACE, "X-Wing/Y-Wing/Rebel Transport");
        this.put(ProductionType.MEDIUM_SPACE, "Corellian Corvetter");
        this.put(ProductionType.HEAVY_SPACE, "Mon Calamari Cruiser");
        this.put(ProductionType.LIGHT_GROUND, "Rebel Trooper");
        this.put(ProductionType.MEDIUM_GROUND, "Airspeeder");
        this.put(ProductionType.HEAVY_GROUND, "Shield Generator/Ion Cannon");

    }
}
