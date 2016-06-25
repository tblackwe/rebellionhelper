package com.tabletophelpers.starwarsrebellionproductionhelper.domain.maps;

import java.util.HashMap;

/**
 * Created by Thomas on 6/25/2016.
 */
public class ProductionMap extends HashMap<String, Integer> {

    public int increment(String key) {
        if (!this.containsKey(key)) {
            this.put(key, 0);
        }
        Integer integer = this.get(key);
        integer++;
        this.put(key,integer);
        return integer;
    }
}
