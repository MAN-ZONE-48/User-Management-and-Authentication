package id.project.skripsi.manzone.controller;

import id.project.skripsi.manzone.dto.response.RegisterResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class RegisterController {

    @GetMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getLoginUser(@RequestBody RegisterResponse registerResponse){
        return new ResponseEntity("hello world", HttpStatus.OK);
    }

}
