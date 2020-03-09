package id.project.skripsi.manzone.controller;

import id.project.skripsi.manzone.dto.response.LoginResponse;
import id.project.skripsi.manzone.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class HelloController {

    private final LoginService loginService;

    @Autowired
    public HelloController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity getUserLogin(@RequestBody LoginResponse loginResponse){
        return ResponseEntity.ok(loginResponse);
    }
}
