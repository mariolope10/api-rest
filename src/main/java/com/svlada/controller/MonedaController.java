package com.svlada.controller;

import com.svlada.entity.Moneda;
import com.svlada.entity.User;
import com.svlada.security.model.UserContext;
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
import com.svlada.service.IUserService;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author mario.lope
 */
@RestController
@RequestMapping("api")
public class MonedaController {

    @Autowired
    private IMonedaService monedaService;
    
    @Autowired
    private IUserService userService;
    
    @PostMapping("moneda")
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

    @PutMapping("moneda")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Moneda> updateMoneda(@RequestBody Moneda moneda) {
        monedaService.updateMoneda(moneda);
        return new ResponseEntity<>(moneda, HttpStatus.OK);
    }

    @DeleteMapping("moneda/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteMoneda(@PathVariable("id") Integer id) {
        monedaService.deleteMoneda(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("moneda/{id}")
    public ResponseEntity<Moneda> getMonedaById(@PathVariable("id") Integer id) {
        Moneda moneda = monedaService.getMonedaById(id);
        return new ResponseEntity<>(moneda, HttpStatus.OK);
    }
    
    @GetMapping("monedas/conmemorativa/ano/{ano}")
    public ResponseEntity<List<Moneda>> getAllMonedasConmemorativasByAno(@PathVariable("ano") Integer ano) {
        List<Moneda> list = monedaService.getAllMonedasConmemorativasByAno(ano);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @GetMapping("monedas/conmemorativa/pais/{pais}")
    public ResponseEntity<List<Moneda>> getAllMonedasConmemorativasByPais(@PathVariable("pais") String pais) {
        List<Moneda> list = monedaService.getAllMonedasConmemorativasByPais(pais);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    // USER ////////////////////////////////////////////////////////////////////
    
    @GetMapping("user/monedas/conmemorativa/ano/{ano}")
    public ResponseEntity<List<Moneda>> getAllMonedasConmemorativasByAnoUser(@PathVariable("ano") Integer ano) {
        UserContext userContext = (UserContext) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
        User user = userService.getUserByUsername(userContext.getUsername());
        
        List<Moneda> listadoMonedas = monedaService.getAllMonedasConmemorativasByAnoUser(ano, user.getId());
        
        return new ResponseEntity<>(listadoMonedas, HttpStatus.OK);
    }

    @GetMapping("user/monedas/conmemorativa/pais/{pais}")
    public ResponseEntity<List<Moneda>> getAllMonedasConmemorativasByPaisUser(@PathVariable("pais") String pais) {
        UserContext userContext = (UserContext) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
        User user = userService.getUserByUsername(userContext.getUsername());
                
        List<Moneda> listadoMonedas = monedaService.getAllMonedasConmemorativasByPaisUser(pais, user.getId());
        
        return new ResponseEntity<>(listadoMonedas, HttpStatus.OK);
    }
}
