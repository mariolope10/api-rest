package com.svlada.dao;

import com.svlada.entity.Pais;
import java.util.List;

/**
 *
 * @author mario.lope
 */
public interface IPaisDAO {

    void addPais(Pais pais);

    void updatePais(Pais pais);

    void deletePais(String codigo);
    
    List<Pais> getAllPaises();
    
    Pais getPaisByCodigo(String codigo);
}
