package id.project.skripsi.manzone.controller;

import id.project.skripsi.manzone.domain.UserData;
import id.project.skripsi.manzone.dto.response.LoginResponse;
import id.project.skripsi.manzone.service.LoginService;
import id.project.skripsi.manzone.service.impl.DefaultUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/v1")
public class LoginController {

    final DefaultUserDetailsServiceImpl userDetailsService;
    final LoginService loginService;

    @Autowired
    public LoginController(DefaultUserDetailsServiceImpl userDetailsService, LoginService loginService) {
        this.userDetailsService = userDetailsService;
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity getUserInfo(@RequestBody LoginResponse loginResponse){
        return new ResponseEntity(loginService.getUserAccount(loginResponse), HttpStatus.OK);
    }

}
