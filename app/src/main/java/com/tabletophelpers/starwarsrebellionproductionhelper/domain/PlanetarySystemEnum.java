package com.tabletophelpers.starwarsrebellionproductionhelper.domain;

/**
 * Created by tblackwe on 6/21/16.
 */
public enum PlanetarySystemEnum {

    MON_CALAMARI(1, ProductionType.LIGHT_SPACE, ProductionType.MEDIUM_SPACE),
    YAVIN(0),
    FELUCIA(1, ProductionType.LIGHT_GROUND),
    SALEUCAMI(1, ProductionType.MEDIUM_GROUND),

    KESSEL(1, ProductionType.LIGHT_GROUND),
    NAL_HUTTA(1, ProductionType.LIGHT_GROUND, ProductionType.LIGHT_SPACE),
    TOYDARIA(0),
    BOTHAWUI(1, ProductionType.MEDIUM_GROUND),

    RODIA(1, ProductionType.LIGHT_GROUND),
    TATOOINE(0),
    GEONOSIS(1, ProductionType.LIGHT_SPACE, ProductionType.HEAVY_GROUND),
    RYLOTH(1, ProductionType.LIGHT_GROUND),

    DATHOMIR(0),
    MANDALORE(1, ProductionType.LIGHT_GROUND, ProductionType.LIGHT_SPACE),
    KASHYYYK(1, ProductionType.LIGHT_GROUND, ProductionType.LIGHT_GROUND),
    MALASTARE(1, ProductionType.LIGHT_GROUND),

    NABOO(1, ProductionType.LIGHT_GROUND, ProductionType.LIGHT_SPACE),
    SULLUST(1, ProductionType.LIGHT_GROUND, ProductionType.HEAVY_GROUND),
    DAGOBAH(0),
    UTAPAU(1, ProductionType.MEDIUM_SPACE, ProductionType.MEDIUM_GROUND),

    DANTOOINE(0),
    MYGEETO(1, ProductionType.LIGHT_SPACE, ProductionType.HEAVY_GROUND),
    ILUM(0),
    ORD_MANTELL(1, ProductionType.MEDIUM_SPACE, ProductionType.MEDIUM_GROUND),

    ALDERAAN(1, ProductionType.LIGHT_GROUND),
    CATO_NEIMODIA(1, ProductionType.LIGHT_SPACE, ProductionType.MEDIUM_GROUND),
    CORUSCANT(1, ProductionType.LIGHT_GROUND),
    CORELLIA(1, ProductionType.LIGHT_SPACE, ProductionType.HEAVY_SPACE),

    BESPIN(1, ProductionType.MEDIUM_GROUND),
    ENDOR(0),
    HOTH(0),
    MUSTAFAR(1, ProductionType.LIGHT_SPACE, ProductionType.MEDIUM_SPACE);

    int buildQueue;
    ProductionType[] productionTypes;


    PlanetarySystemEnum(int buildQueue, ProductionType... productionTypes) {
        this.buildQueue = buildQueue;
        this.productionTypes = productionTypes;
    }

    public ProductionType[] getProductionTypes() {
        return this.productionTypes;
//        ProductionType[] retVal;
//        switch (this.control) {
//            case REBEL:
//            case IMPERIAL:
//                retVal = this.productionTypes;
//                break;
//            case SUPRESSED:
//
//                retVal = new ProductionType[1];
//                retVal[0] = productionTypes[0];
//                break;
//            default:
//                retVal = new ProductionType[0];
//                break;
//        }
//        return retVal;
    }
}
