package com.tabletophelpers.starwarsrebellionproductionhelper.domain.maps;

import com.tabletophelpers.starwarsrebellionproductionhelper.domain.ProductionType;

import java.util.HashMap;

/**
 * Created by Thomas on 6/25/2016.
 */
public class ImperialProduction extends HashMap<ProductionType, String> {

    public ImperialProduction() {

        this.put(ProductionType.LIGHT_SPACE, "TIE Fighter");
        this.put(ProductionType.MEDIUM_SPACE, "Assault Carrier");
        this.put(ProductionType.HEAVY_SPACE, "Star Destroyer");
        this.put(ProductionType.LIGHT_GROUND, "Stormtrooper");
        this.put(ProductionType.MEDIUM_GROUND, "AT-ST");
        this.put(ProductionType.HEAVY_GROUND, "AT-AT");

    }
}
