package id.project.skripsi.manzone.controller;

import id.project.skripsi.manzone.constant.AppConstant;
import id.project.skripsi.manzone.dto.response.ErrorResponse;
import id.project.skripsi.manzone.dto.response.LoginResponse;
import id.project.skripsi.manzone.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity getUserLogin() {
        try {
            return new ResponseEntity("hello world",HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(new ErrorResponse(500,"There is an error in our server: {}" + e.getMessage(), AppConstant.FAIIED.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
