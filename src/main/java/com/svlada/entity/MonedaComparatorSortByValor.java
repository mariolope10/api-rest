package com.svlada.entity;

import java.util.Comparator;

/**
 *
 * @author Mario
 */
public class MonedaComparatorSortByValor implements Comparator<Moneda> {

    @Override
    public int compare(Moneda o1, Moneda o2) {
        return o1.getValor().getDecimal().compareTo(o2.getValor().getDecimal());
    }
}
