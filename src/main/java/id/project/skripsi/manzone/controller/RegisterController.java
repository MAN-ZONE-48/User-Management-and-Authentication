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
@RequestMapping("/v1")
public class RegisterController {

    final RegisterService registerService;

    @Autowired
    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping(value = "/createUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity registerUserFromOwnerToAllStaff(@RequestBody RegisterResponse registerResponse, HttpServletResponse response) {
        try {
            RegisterResponse currentUserData = registerService.saveUserDataForOwner(registerResponse);
            return new ResponseEntity(new Response(false, response.getStatus(), StatusConstant.OK.getMessage(), currentUserData), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(new Response(true, response.getStatus(), StatusConstant.INTERNAL_SERVER_ERROR.getMessage(), MessageConstant.INTERNAL_SERVER_ERROR.getMessage() + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
