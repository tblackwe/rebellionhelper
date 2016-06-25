package com.tabletophelpers.starwarsrebellionproductionhelper.domain;

/**
 * Created by tblackwe on 6/21/16.
 */
public enum ImperialProduction {

    TIE("TIE Fighter", ProductionType.LIGHT_SPACE),
    CARRIER("Assault Carrier", ProductionType.MEDIUM_SPACE),
    ISD("Star Destroyer", ProductionType.HEAVY_SPACE),
    STORMTROOPER("Stormtrooper", ProductionType.LIGHT_GROUND),
    ATST("AT-ST", ProductionType.MEDIUM_GROUND),
    ATAT("AT-AT", ProductionType.HEAVY_GROUND),;

    String name;
    ProductionType productionType;

    ImperialProduction(String name, ProductionType productionType) {
        this.name = name;
        this.productionType = productionType;
    }
}
