package com.svlada.controller;

/**
 *
 * @author mario.lope
 */
import com.svlada.entity.Serie;
import com.svlada.entity.User;
import com.svlada.security.model.UserContext;
import com.svlada.service.ISerieService;
import com.svlada.service.IUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("api")
public class SerieController {

    @Autowired
    private ISerieService serieService;
    
    @Autowired
    private IUserService userService;
    
    @PostMapping("serie")
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
    public ResponseEntity<Serie> updateSerie(@RequestBody Serie serie) {
        serieService.updateSerie(serie);
        return new ResponseEntity<>(serie, HttpStatus.OK);
    }

    @DeleteMapping("serie/{id}")
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

    /*@GetMapping("series/pais/{pais}")
    public ResponseEntity<List<Serie>> getAllSeriesByPais(@PathVariable("pais") String pais) {
        List<Serie> list = serieService.getAllSeriesByPais(pais);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }*/
    
    ///////////////////////////////////////////////

    @GetMapping("series/pais/{pais}")
    public ResponseEntity<List<Serie>> getAllSeriesByPaisUser(@PathVariable("pais") String pais) {
        UserContext userContext = (UserContext) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
        User user = userService.getUserByUsername(userContext.getUsername());
        
        List<Serie> list = serieService.getAllSeriesByPaisUser(pais, user.getId());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @GetMapping("series/ano/{ano}")
    public ResponseEntity<List<Serie>> getAllSeriesByPaisUser(@PathVariable("ano") Integer ano) {
        UserContext userContext = (UserContext) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
        User user = userService.getUserByUsername(userContext.getUsername());
        
        List<Serie> list = serieService.getAllSeriesByAnoUser(ano, user.getId());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
