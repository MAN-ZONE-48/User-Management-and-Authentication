package id.project.skripsi.manzone.controller;

import com.java.common.lib.dto.Response;
import id.project.skripsi.manzone.dto.response.LoginResponse;
import id.project.skripsi.manzone.service.LoginService;
import id.project.skripsi.manzone.service.impl.DefaultUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import static com.java.common.lib.constant.ResponseConstant.*;

@RestController
@RequestMapping("/auth")
public class LoginController {

    final DefaultUserDetailsServiceImpl userDetailsService;
    final LoginService loginService;

    @Autowired
    public LoginController(DefaultUserDetailsServiceImpl userDetailsService, LoginService loginService) {
        this.userDetailsService = userDetailsService;
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity userLogin(@RequestBody LoginResponse loginResponse, HttpServletResponse response) {
        try {
            loginService.getUserAccount(loginResponse);
            return new ResponseEntity(new Response(false, response.getStatus(), OK.getMessage(), "Login Success"), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(new Response(true, response.getStatus(), INTERNAL_SERVER_ERROR.getMessage(), INTERNAL_SERVER_ERROR.getMessage() + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
