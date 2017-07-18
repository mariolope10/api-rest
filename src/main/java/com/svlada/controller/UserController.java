package com.svlada.controller;

import com.svlada.config.APISettings;
import com.svlada.entity.User;
import com.svlada.entity.UserMoneda;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.svlada.security.auth.JwtAuthenticationToken;
import com.svlada.security.model.UserContext;
import com.svlada.service.IUserService;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import javax.activation.FileTypeMap;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("api/user")
public class UserController {
    
    @Autowired
    private IUserService userService;
    
    @Autowired 
    private APISettings apiSettings;
    
    @GetMapping("me")
    public @ResponseBody UserContext get(JwtAuthenticationToken token) {
        return (UserContext) token.getPrincipal();
    }
    
    @GetMapping("image")
    public ResponseEntity<InputStreamResource> downloadUserAvatarImage() throws IOException {
        UserContext userContext = (UserContext) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
        User user = userService.getUserByUsername(userContext.getUsername());
        
        File profileImageDirectory = new File(apiSettings.getImagesPath() + "profile\\");

        FileFilter fileFilter = new WildcardFileFilter(user.getId() + ".*");
        File profileImage = profileImageDirectory.listFiles(fileFilter)[0];
        
        InputStreamResource inputStreamResource = new InputStreamResource(new FileInputStream(profileImage));
        return ResponseEntity.ok()
                .contentLength(profileImage.length())
                .contentType(MediaType.valueOf(FileTypeMap.getDefaultFileTypeMap().getContentType(profileImage)))
                .body(inputStreamResource);
    }
    
    ////////////////////////////////////////////////////////////////////////////
    
    @GetMapping("monedas")
    public ResponseEntity<List<UserMoneda>> getAllMonedasByUser() {
        UserContext userContext = (UserContext) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
        User user = userService.getUserByUsername(userContext.getUsername());
        
        List<UserMoneda> list = userService.getAllMonedasByUser(user.getId());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @GetMapping("monedas/{id}")
    public ResponseEntity<UserMoneda> getMonedaByUser(@PathVariable("id") Integer idMoneda) {
        UserContext userContext = (UserContext) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
        User user = userService.getUserByUsername(userContext.getUsername());
        
        UserMoneda userMoneda = userService.getMonedaByUser(idMoneda, user.getId());
        
        return new ResponseEntity<>(userMoneda, HttpStatus.OK);
    }
    
    @PostMapping("monedas")
    public ResponseEntity<Void> addMoneda(@RequestBody UserMoneda userMoneda, UriComponentsBuilder builder) {
        boolean flag = userService.addUserMoneda(userMoneda);
        if (flag == false) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        //HttpHeaders headers = new HttpHeaders();
        //headers.setLocation(builder.path("/conmemorativa/{id}").buildAndExpand(moneda.getId()).toUri());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @PutMapping("monedas")
    public ResponseEntity<UserMoneda> updateMoneda(@RequestBody UserMoneda userMoneda) {
        userService.updateUserMoneda(userMoneda);
        return new ResponseEntity<>(userMoneda, HttpStatus.OK);
    }
}
