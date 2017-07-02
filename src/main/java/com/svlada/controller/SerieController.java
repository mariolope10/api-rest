package com.svlada.controller;

/**
 *
 * @author mario.lope
 */
import com.svlada.entity.Pais;
import com.svlada.entity.Serie;
import com.svlada.service.IPaisService;
import com.svlada.service.ISerieService;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("api")
public class SerieController {

    @Autowired
    private ISerieService serieService;

    @Autowired
    private IPaisService paisService;

    @GetMapping("serie/{id}")
    public ResponseEntity<Serie> getSerieById(@PathVariable("id") Integer id) {
        Serie serie = serieService.getSerieById(id);
        return new ResponseEntity<>(serie, HttpStatus.OK);
    }

    @GetMapping("serie/search")
    public ResponseEntity<List<Serie>> getAllSeriesByPais(@RequestParam("pais") String pais) {
        List<Serie> list = serieService.getAllSeriesByPais(pais);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("series")
    public ResponseEntity<List<Object>> getAllSeries() {
        List<Object> listado = new ArrayList<>();

        List<Pais> listadoPaises = paisService.getAllPaises();
        listadoPaises.forEach((pais) -> {
            List<Serie> listadoSeries = serieService.getAllSeriesByPais(pais.getCodigo());

            Map<String, Object> map = new LinkedHashMap<>();
            map.put("pais", pais.getNombre());
            map.put("series", listadoSeries);

            listado.add(map);
        });

        return new ResponseEntity<>(listado, HttpStatus.OK);
    }

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
}
