package id.project.skripsi.manzone.controller;

import com.java.common.lib.constant.MessageConstant;
import com.java.common.lib.constant.StatusConstant;
import com.java.common.lib.dto.Response;
import id.project.skripsi.manzone.dto.UserProfileDTO;
import id.project.skripsi.manzone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/v1")
public class UserProfileController {

    final UserService userService;

    @Autowired
    public UserProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile")
    public ResponseEntity getUserProfile(@RequestHeader(value = "Authorization") String token, HttpServletResponse response) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token);

        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            UserProfileDTO responseProfile = userService.getUserProfile(authentication);
            return new ResponseEntity(new Response(false, response.getStatus(), StatusConstant.OK.getMessage(), responseProfile), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(new Response(true, response.getStatus(), StatusConstant.INTERNAL_SERVER_ERROR.getMessage(), MessageConstant.INTERNAL_SERVER_ERROR.getMessage() + e.getMessage()), HttpStatus.OK);

        }
    }
}
