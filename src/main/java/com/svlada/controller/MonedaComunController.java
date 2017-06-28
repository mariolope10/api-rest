package com.svlada.controller;

/**
 *
 * @author mario.lope
 */
import com.svlada.entity.MonedaComun;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.svlada.service.IMonedaComunService;

@RestController
@RequestMapping("api/moneda")
public class MonedaComunController {

    @Autowired
    private IMonedaComunService monedaService;

    @GetMapping("comun/{id}")
    public ResponseEntity<MonedaComun> getMonedaById(@PathVariable("id") Integer id) {
        MonedaComun moneda = monedaService.getMonedaById(id);
        return new ResponseEntity<>(moneda, HttpStatus.OK);
    }
    
    @GetMapping("comun/search")
    public ResponseEntity<List<MonedaComun>> getAllMonedasByPais(@RequestParam("pais") String pais) {
        List<MonedaComun> list = monedaService.getAllMonedasByPais(pais);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("comunes")
    public ResponseEntity<List<MonedaComun>> getAllMonedas() {
        List<MonedaComun> list = monedaService.getAllMonedas();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("comun")
    public ResponseEntity<Void> addMoneda(@RequestBody MonedaComun moneda, UriComponentsBuilder builder) {
        boolean flag = monedaService.addMoneda(moneda);
        if (flag == false) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/moneda/{id}").buildAndExpand(moneda.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("comun")
    public ResponseEntity<MonedaComun> updateMoneda(@RequestBody MonedaComun moneda) {
        monedaService.updateMoneda(moneda);
        return new ResponseEntity<>(moneda, HttpStatus.OK);
    }

    @DeleteMapping("comun/{id}")
    public ResponseEntity<Void> deleteMoneda(@PathVariable("id") Integer id) {
        monedaService.deleteMoneda(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
