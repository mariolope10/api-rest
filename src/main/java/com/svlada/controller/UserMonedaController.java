package com.svlada.controller;

import com.svlada.entity.UserMoneda;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.svlada.service.IUserMonedaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * End-point for retrieving logged-in user details.
 * 
 * @author vladimir.stankovic
 *
 * Aug 4, 2016
 */
@RestController
@RequestMapping("api/user/moneda")
public class UserMonedaController {
    
    @Autowired
    private IUserMonedaService userMonedaService;
    
    @PostMapping()
    public ResponseEntity<UserMoneda> addUserMoneda(@RequestBody UserMoneda userMoneda, UriComponentsBuilder builder) {
        
        System.out.println(userMoneda.toString());
        
        boolean flag = userMonedaService.addUserMoneda(userMoneda);
        if (flag == false) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        //HttpHeaders headers = new HttpHeaders();
        //headers.setLocation(builder.path("/conmemorativa/{id}").buildAndExpand(moneda.getId()).toUri());
        return new ResponseEntity<>(userMoneda, HttpStatus.CREATED);
    }
    
    @PutMapping()
    public ResponseEntity<UserMoneda> updateUserMoneda(@RequestBody UserMoneda userMoneda) {
        userMonedaService.updateUserMoneda(userMoneda);
        return new ResponseEntity<>(userMoneda, HttpStatus.OK);
    }
    
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteUserMoneda(@PathVariable("id") Integer id) {
        userMonedaService.deleteUserMoneda(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
