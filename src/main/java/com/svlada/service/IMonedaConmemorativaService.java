package com.svlada.service;

import com.svlada.entity.MonedaConmemorativa;
import java.util.List;

/**
 *
 * @author mario.lope
 */
public interface IMonedaConmemorativaService {

    List<MonedaConmemorativa> getAllMonedas();
    
    List<MonedaConmemorativa> getAllMonedasByPais(String pais);

    MonedaConmemorativa getMonedaById(int idMoneda);

    boolean addMoneda(MonedaConmemorativa moneda);

    void updateMoneda(MonedaConmemorativa moneda);

    void deleteMoneda(int idMoneda);
}
