package com.tabletophelpers.starwarsrebellionproductionhelper.domain;

/**
 * Created by tblackwe on 6/21/16.
 */
public class PlanetarySystem {

    PlanetarySystemEnum planetarySystemEnum;
    ControlEnum controlEnum = ControlEnum.NONE;
    boolean destroyed = false;
    boolean probed = false;
    boolean rebelBase = false;
    boolean landed = false;

    public PlanetarySystem(PlanetarySystemEnum planetarySystemEnum) {
        this.planetarySystemEnum = planetarySystemEnum;
    }

    public void setControlEnum(ControlEnum controlEnum) {
        this.controlEnum = controlEnum;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }

    public ControlEnum getControlEnum() {
        return controlEnum;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public boolean isProbed() {
        return probed;
    }

    public void setProbed(boolean probed) {
        this.probed = probed;
    }

    public boolean isRebelBase() {
        return rebelBase;
    }

    public void setRebelBase(boolean rebelBase) {
        this.rebelBase = rebelBase;
    }

    public boolean isLanded() {
        return landed;
    }

    public void setLanded(boolean landed) {
        this.landed = landed;
    }

    public ProductionType[] getProductionType() {
        ProductionType[] retVal;
        switch (this.controlEnum) {
            case REBEL:
            case IMPERIAL:
                retVal = this.planetarySystemEnum.getProductionTypes();
                break;
            case SUPRESSED:

                retVal = new ProductionType[1];
                retVal[0] = this.planetarySystemEnum.getProductionTypes()[0];
                break;
            default:
                retVal = new ProductionType[0];
                break;
        }
        return retVal;
    }
}
