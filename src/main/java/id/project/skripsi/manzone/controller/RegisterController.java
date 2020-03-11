package id.project.skripsi.manzone.controller;

import id.project.skripsi.manzone.domain.UserData;
import id.project.skripsi.manzone.dto.response.RegisterResponse;
import id.project.skripsi.manzone.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class RegisterController {

    final RegisterService registerService;

    @Autowired
    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getLoginUser(@RequestBody RegisterResponse registerResponse){

        UserData currentUserData = registerService.saveUserData(registerResponse);
        return new ResponseEntity(currentUserData, HttpStatus.OK);
    }
}
