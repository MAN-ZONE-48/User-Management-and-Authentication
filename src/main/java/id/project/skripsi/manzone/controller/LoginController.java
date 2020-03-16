package id.project.skripsi.manzone.controller;

import id.project.skripsi.manzone.domain.UserData;
import id.project.skripsi.manzone.dto.response.LoginResponse;
import id.project.skripsi.manzone.service.LoginService;
import id.project.skripsi.manzone.service.impl.DefaultUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    public ResponseEntity userLogin(@RequestBody LoginResponse loginResponse){
        loginService.getUserAccount(loginResponse);
        return new ResponseEntity("Login Success!", HttpStatus.OK);
    }


}
