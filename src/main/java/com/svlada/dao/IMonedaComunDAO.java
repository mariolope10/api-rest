package com.svlada.dao;

import com.svlada.entity.MonedaComun;
import java.util.List;

/**
 *
 * @author mario.lope
 */
public interface IMonedaComunDAO {

    List<MonedaComun> getAllMonedas();
    
    List<MonedaComun> getAllMonedasByPais(String pais);

    MonedaComun getMonedaById(int idMoneda);

    void addMoneda(MonedaComun moneda);

    void updateMoneda(MonedaComun moneda);

    void deleteMoneda(int idMoneda);

    //boolean monedaExists(String title, String category);
}
