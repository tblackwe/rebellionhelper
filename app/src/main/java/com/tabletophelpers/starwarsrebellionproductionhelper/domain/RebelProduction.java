package com.tabletophelpers.starwarsrebellionproductionhelper.domain;

/**
 * Created by tblackwe on 6/21/16.
 */
public enum RebelProduction {

    XWING("X-Wing",ProductionType.LIGHT_SPACE),
    YWING("Y-Wing",ProductionType.LIGHT_SPACE),
    TRANSPORT("Rebel Transport",ProductionType.LIGHT_SPACE),
    CORVETTE("Corellian Corvette",ProductionType.MEDIUM_SPACE),
    Cruiser("Mon Calamari Cruiser",ProductionType.HEAVY_SPACE),
    TROOPER("Rebel Trooper",ProductionType.LIGHT_GROUND),
    AIRSPEEDER("Airspeeder",ProductionType.MEDIUM_GROUND),
    SHIELDGEN("Shield Generator",ProductionType.HEAVY_GROUND),
    IONCANNON("Ion Cannon",ProductionType.HEAVY_GROUND)
    ;

    String name;
    ProductionType productionType;

    RebelProduction(String name, ProductionType productionType) {
        this.name = name;
        this.productionType = productionType;
    }
}
