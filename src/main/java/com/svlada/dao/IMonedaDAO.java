package com.svlada.dao;

import com.svlada.entity.Moneda;
import java.util.List;

/**
 *
 * @author mario.lope
 */
public interface IMonedaDAO {

    Moneda getMonedaById(int idMoneda);
    
    List<Moneda> getAllMonedas();
    
    List<Moneda> getAllMonedasConmemorativasByPais(String pais);
    
    List<Moneda> getAllMonedasConmemorativasByAno(int ano);

    void addMoneda(Moneda moneda);

    void updateMoneda(Moneda moneda);

    void deleteMoneda(int idMoneda);
}
