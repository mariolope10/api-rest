package com.svlada.dao;

import com.svlada.entity.MonedaConmemorativa;
import java.util.List;

/**
 *
 * @author mario.lope
 */
public interface IMonedaConmemorativaDAO {

    List<MonedaConmemorativa> getAllMonedas();
    
    List<MonedaConmemorativa> getAllMonedasByPais(String pais);
    
    List<MonedaConmemorativa> getAllMonedasByAno(int ano);

    MonedaConmemorativa getMonedaById(int idMoneda);

    void addMoneda(MonedaConmemorativa moneda);

    void updateMoneda(MonedaConmemorativa moneda);

    void deleteMoneda(int idMoneda);
}
