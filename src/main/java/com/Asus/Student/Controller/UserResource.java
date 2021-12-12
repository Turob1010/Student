package com.Asus.Student.Controller;

import com.Asus.Student.Entity.User;
import com.Asus.Student.Service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/api")
public class UserResource {

    @Autowired
    AuthenticationManager authenticationManager;


    private final CustomUserDetailsService detailsService;
    public UserResource(CustomUserDetailsService detailsService) {
        this.detailsService = detailsService;
    }

    @SuppressWarnings("rawtypes")
    @PostMapping("/register")
    public ResponseEntity create(@RequestBody User user){
        if (!checkPasswordLength(user.getPassword())){
            return new ResponseEntity("password length less than four",HttpStatus.BAD_REQUEST);
        }
        if (detailsService.checkUserName(user.getUserName())){
            return new ResponseEntity("There is already a user registered with the username",HttpStatus.BAD_REQUEST);
        }
      return ResponseEntity.ok(detailsService.create(user));

    }

    private Boolean checkPasswordLength(String password){
        return password.length() > 4;
    }

}
