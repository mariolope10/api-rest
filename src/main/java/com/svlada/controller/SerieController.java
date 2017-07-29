package com.svlada.controller;

import com.svlada.entity.Serie;
import com.svlada.entity.User;
import com.svlada.service.ISerieService;
import com.svlada.service.IUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author mario.lope
 */
@RestController
@RequestMapping("api")
public class SerieController {

    @Autowired
    private ISerieService serieService;
    
    @Autowired
    private IUserService userService;
    
    @PostMapping("serie")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> addSerie(@RequestBody Serie serie, UriComponentsBuilder builder) {
        boolean flag = serieService.addSerie(serie);
        if (flag == false) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/serie/{id}").buildAndExpand(serie.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("serie")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Serie> updateSerie(@RequestBody Serie serie) {
        serieService.updateSerie(serie);
        return new ResponseEntity<>(serie, HttpStatus.OK);
    }

    @DeleteMapping("serie/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteSerie(@PathVariable("id") Integer id) {
        serieService.deleteSerie(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("serie/{id}")
    public ResponseEntity<Serie> getSerieById(@PathVariable("id") Integer id) {
        Serie serie = serieService.getSerieById(id);
        return new ResponseEntity<>(serie, HttpStatus.OK);
    }
    
    @GetMapping("series")
    public ResponseEntity<List<Serie>> getAllSeries() {
        List<Serie> listado = serieService.getAllSeries();
        return new ResponseEntity<>(listado, HttpStatus.OK);
    }

    @GetMapping("series/pais/{pais}")
    public ResponseEntity<List<Serie>> getAllSeriesByPais(@PathVariable("pais") String pais) {
        List<Serie> list = serieService.getAllSeriesByPais(pais);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    // USER ////////////////////////////////////////////////////////////////////

    @GetMapping("user/series/pais/{pais}")
    public ResponseEntity<List<Serie>> getAllSeriesByPaisUser(@PathVariable("pais") String pais) {
        User user = userService.getUserByUsername();
        
        List<Serie> list = serieService.getAllSeriesByPaisUser(pais, user);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @GetMapping("user/series/ano/{ano}")
    public ResponseEntity<List<Serie>> getAllSeriesByAnoUser(@PathVariable("ano") Integer ano) {
        User user = userService.getUserByUsername();
        
        List<Serie> list = serieService.getAllSeriesByAnoUser(ano, user);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
