package com.svlada.service;

import com.svlada.entity.Moneda;
import java.util.List;

/**
 *
 * @author mario.lope
 */
public interface IMonedaService {

    Moneda getMonedaById(int idMoneda);
    
    List<Moneda> getAllMonedas();
    
    List<Moneda> getAllMonedasConmemorativasByPais(String pais);
    
    List<Moneda> getAllMonedasConmemorativasByAno(int ano);
    
    List<Object[]> getAllMonedasConmemorativasByPais_IsInCollection(String pais);

    boolean addMoneda(Moneda moneda);

    void updateMoneda(Moneda moneda);

    void deleteMoneda(int idMoneda);
}
