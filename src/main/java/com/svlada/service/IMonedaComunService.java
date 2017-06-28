package com.svlada.service;

import com.svlada.entity.MonedaComun;
import java.util.List;

/**
 *
 * @author mario.lope
 */
public interface IMonedaComunService {

    List<MonedaComun> getAllMonedas();
    
    List<MonedaComun> getAllMonedasByPais(String pais);

    MonedaComun getMonedaById(int idMoneda);

    boolean addMoneda(MonedaComun moneda);

    void updateMoneda(MonedaComun moneda);

    void deleteMoneda(int idMoneda);
}
