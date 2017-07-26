package com.svlada.controller;

import com.svlada.config.APISettings;
import com.svlada.entity.User;
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
import javax.activation.FileTypeMap;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author mario.lope
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
}
