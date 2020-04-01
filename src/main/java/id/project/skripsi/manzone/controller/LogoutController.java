package id.project.skripsi.manzone.controller;

import com.java.common.lib.constant.StatusConstant;
import com.java.common.lib.dto.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/v1")
public class LogoutController {

    @PostMapping("/logout")
    public ResponseEntity logOutUser(HttpServletResponse response){
        SecurityContextHolder.clearContext();
        return new ResponseEntity(new Response(false,response.getStatus(), StatusConstant.OK.getMessage(),"Logout Success"), HttpStatus.OK);
    }

}
