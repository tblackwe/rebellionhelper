package com.tabletophelpers.starwarsrebellionproductionhelper.domain;

/**
 * Created by tblackwe on 6/21/16.
 */
public enum PlanetarySystemEnum {

    MON_CALAMARI(3, ProductionType.LIGHT_SPACE, ProductionType.HEAVY_SPACE),
    //    YAVIN(0),
    FELUCIA(1, ProductionType.LIGHT_GROUND),
    SALEUCAMI(1, ProductionType.MEDIUM_GROUND),

    KESSEL(1, ProductionType.LIGHT_GROUND),
    NAL_HUTTA(1, ProductionType.LIGHT_GROUND, ProductionType.LIGHT_SPACE),
    TOYDARIA(2, ProductionType.MEDIUM_SPACE),
    BOTHAWUI(1, ProductionType.MEDIUM_GROUND),

    RODIA(1, ProductionType.LIGHT_GROUND),
    //    TATOOINE(0),
    GEONOSIS(2, ProductionType.LIGHT_SPACE, ProductionType.HEAVY_GROUND),
    RYLOTH(1, ProductionType.LIGHT_GROUND),

    //    DATHOMIR(0),
    MANDALORE(1, ProductionType.LIGHT_GROUND, ProductionType.LIGHT_SPACE),
    KASHYYYK(1, ProductionType.LIGHT_GROUND, ProductionType.LIGHT_GROUND),
    MALASTARE(1, ProductionType.LIGHT_GROUND),

    NABOO(1, ProductionType.LIGHT_GROUND, ProductionType.LIGHT_SPACE),
    SULLUST(2, ProductionType.LIGHT_GROUND, ProductionType.HEAVY_GROUND),
    //    DAGOBAH(0),
    UTAPAU(3, ProductionType.MEDIUM_SPACE, ProductionType.HEAVY_SPACE),

    //    DANTOOINE(0),
    MYGEETO(2, ProductionType.LIGHT_SPACE, ProductionType.HEAVY_GROUND),
    //    ILUM(0),
    ORD_MANTELL(2, ProductionType.MEDIUM_SPACE, ProductionType.MEDIUM_GROUND),

    ALDERAAN(1, ProductionType.LIGHT_GROUND),
    CATO_NEIMODIA(2, ProductionType.LIGHT_SPACE, ProductionType.MEDIUM_GROUND),
    CORUSCANT(1, ProductionType.LIGHT_GROUND),
    CORELLIA(3, ProductionType.LIGHT_SPACE, ProductionType.HEAVY_SPACE),

    BESPIN(1, ProductionType.MEDIUM_GROUND),
    //    ENDOR(0),
//    HOTH(0),
    MUSTAFAR(2, ProductionType.LIGHT_SPACE, ProductionType.MEDIUM_SPACE);

    int buildQueue;
    ProductionType[] productionTypes;


    PlanetarySystemEnum(int buildQueue, ProductionType... productionTypes) {
        this.buildQueue = buildQueue;
        this.productionTypes = productionTypes;
    }

    public ProductionType[] getProductionTypes() {
        return this.productionTypes;
    }

    public String cleanName() {
        return this.name().replaceAll("_", " ");
    }


    @Override
    public String toString() {
        return cleanName();
    }
}
