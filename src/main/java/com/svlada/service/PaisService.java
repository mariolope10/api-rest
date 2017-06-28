package com.svlada.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.svlada.dao.IPaisDAO;
import com.svlada.entity.Pais;

/**
 *
 * @author mario.lope
 */

@Service
public class PaisService implements IPaisService {

    @Autowired
    private IPaisDAO paisDAO;

    @Override
    public List<Pais> getAllPaises() {
        return paisDAO.getAllPaises();
    }

    @Override
    public Pais getPaisById(int idPais) {
        return paisDAO.getPaisById(idPais);
    }

    @Override
    public boolean addPais(Pais pais) {
        paisDAO.addPais(pais);
    	return true;
    }

    @Override
    public void updatePais(Pais pais) {
        paisDAO.updatePais(pais);
    }

    @Override
    public void deletePais(int idPais) {
        paisDAO.deletePais(idPais);
    }

}