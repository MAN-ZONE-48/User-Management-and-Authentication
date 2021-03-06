package id.project.skripsi.manzone.controller;

import com.java.common.lib.constant.MessageConstant;
import com.java.common.lib.constant.StatusConstant;
import com.java.common.lib.dto.Response;
import id.project.skripsi.manzone.dto.response.RegisterResponse;
import id.project.skripsi.manzone.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/auth")
public class RegisterOwnerController {

    final RegisterService registerService;

    @Autowired
    public RegisterOwnerController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity registerUserForOwner(@RequestBody RegisterResponse registerResponse, HttpServletResponse response) {
        String currentUserData = registerService.saveUserDataForRegisterOwner(registerResponse);
        try {
            return new ResponseEntity(new Response(false, response.getStatus(), StatusConstant.OK.getMessage(), currentUserData), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(new Response(true, response.getStatus(),StatusConstant.INTERNAL_SERVER_ERROR.getMessage(), MessageConstant.INTERNAL_SERVER_ERROR.getMessage() + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
