package com.svlada.controller;

/**
 *
 * @author mario.lope
 */
import com.svlada.entity.Pais;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.svlada.service.IPaisService;

@RestController
@RequestMapping("api")
public class PaisController {

    @Autowired
    private IPaisService paisService;

    @GetMapping("pais/{id}")
    public ResponseEntity<Pais> getPaisById(@PathVariable("id") Integer id) {
        Pais pais = paisService.getPaisById(id);
        return new ResponseEntity<>(pais, HttpStatus.OK);
    }

    @GetMapping("paises")
    public ResponseEntity<List<Pais>> getAllPaises() {
        List<Pais> list = paisService.getAllPaises();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("pais")
    public ResponseEntity<Void> addMoneda(@RequestBody Pais pais, UriComponentsBuilder builder) {
        boolean flag = paisService.addPais(pais);
        if (flag == false) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/pais/{id}").buildAndExpand(pais.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("pais")
    public ResponseEntity<Pais> updateMoneda(@RequestBody Pais pais) {
        paisService.updatePais(pais);
        return new ResponseEntity<>(pais, HttpStatus.OK);
    }

    @DeleteMapping("pais/{id}")
    public ResponseEntity<Void> deleteMoneda(@PathVariable("id") Integer id) {
        paisService.deletePais(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
