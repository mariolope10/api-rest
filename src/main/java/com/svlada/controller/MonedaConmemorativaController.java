package com.svlada.controller;

/**
 *
 * @author mario.lope
 */
import com.svlada.entity.MonedaConmemorativa;
import com.svlada.entity.Pais;
import com.svlada.service.IMonedaConmemorativaService;
import com.svlada.service.IPaisService;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("api/moneda")
public class MonedaConmemorativaController {

    @Autowired
    private IMonedaConmemorativaService monedaService;

    @Autowired
    private IPaisService paisService;

    @GetMapping("conmemorativa/{id}")
    public ResponseEntity<MonedaConmemorativa> getMonedaById(@PathVariable("id") Integer id) {
        MonedaConmemorativa moneda = monedaService.getMonedaById(id);
        return new ResponseEntity<>(moneda, HttpStatus.OK);
    }

    @GetMapping("conmemorativa/search")
    public ResponseEntity<List<MonedaConmemorativa>> getAllMonedasByPais(@RequestParam("pais") String pais) {
        List<MonedaConmemorativa> list = monedaService.getAllMonedasByPais(pais);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("conmemorativas")
    public ResponseEntity<List<Object>> getAllMonedas(@RequestParam("orden") String orden) {
        List<Object> listado = new ArrayList<>();

        if (orden.equals("pais")) {
            List<Pais> listadoPaises = paisService.getAllPaises();
            listadoPaises.forEach((pais) -> {
                List<MonedaConmemorativa> listadoMonedas = monedaService.getAllMonedasByPais(pais.getCodigo());

                Map<String, Object> map = new LinkedHashMap<>();
                map.put("pais", pais.getNombre());
                map.put("monedas", listadoMonedas);

                listado.add(map);
            });
            
        } else {
            int anoSalidaEuro = 2002;
            int anoActual = Calendar.getInstance().get(Calendar.YEAR);
            
            for (int ano = anoActual; ano >= anoSalidaEuro; ano--) {
                List<MonedaConmemorativa> listadoMonedas = monedaService.getAllMonedasByAno(ano);

                Map<String, Object> map = new LinkedHashMap<>();
                map.put("ano", ano);
                map.put("monedas", listadoMonedas);

                listado.add(map);
            }
            
        }

        return new ResponseEntity<>(listado, HttpStatus.OK);
    }

    @PostMapping("conmemorativa")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> addMoneda(@RequestBody MonedaConmemorativa moneda, UriComponentsBuilder builder) {
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
    public ResponseEntity<MonedaConmemorativa> updateMoneda(@RequestBody MonedaConmemorativa moneda) {
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
