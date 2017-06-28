package com.svlada.dao;

import com.svlada.entity.Pais;
import java.util.List;

/**
 *
 * @author mario.lope
 */
public interface IPaisDAO {

    List<Pais> getAllPaises();
    
    Pais getPaisById(int idPais);

    void addPais(Pais pais);

    void updatePais(Pais pais);

    void deletePais(int idPais);
}
