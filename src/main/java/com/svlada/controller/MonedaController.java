package com.svlada.controller;

/**
 *
 * @author mario.lope
 */
import com.svlada.entity.Moneda;
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
import com.svlada.service.IMonedaService;

@RestController
@RequestMapping("api/moneda")
public class MonedaController {

    @Autowired
    private IMonedaService monedaService;

    @GetMapping("conmemorativa/{id}")
    public ResponseEntity<Moneda> getMonedaById(@PathVariable("id") Integer id) {
        Moneda moneda = monedaService.getMonedaById(id);
        return new ResponseEntity<>(moneda, HttpStatus.OK);
    }
    
    @GetMapping("conmemorativa/ano/{ano}")
    public ResponseEntity<List<Moneda>> getAllMonedasConmemorativasByPais(@PathVariable("ano") Integer ano) {
        List<Moneda> list = monedaService.getAllMonedasConmemorativasByAno(ano);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @GetMapping("conmemorativa/pais/{pais}")
    public ResponseEntity<List<Moneda>> getAllMonedasConmemorativasByAno(@PathVariable("pais") String pais) {
        List<Moneda> list = monedaService.getAllMonedasConmemorativasByPais(pais);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /*@GetMapping("conmemorativa/buscar")
    public ResponseEntity<List<Moneda>> findMonedas(@RequestParam("texto") String texto) {
        List<Moneda> list = monedaService.getAllMonedasByPais(pais);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }*/

    @PostMapping("conmemorativa")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> addMoneda(@RequestBody Moneda moneda, UriComponentsBuilder builder) {
        boolean flag = monedaService.addMoneda(moneda);
        if (flag == false) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/conmemorativa/{id}").buildAndExpand(moneda.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("conmemorativa")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Moneda> updateMoneda(@RequestBody Moneda moneda) {
        monedaService.updateMoneda(moneda);
        return new ResponseEntity<>(moneda, HttpStatus.OK);
    }

    @DeleteMapping("conmemorativa/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteMoneda(@PathVariable("id") Integer id) {
        monedaService.deleteMoneda(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}