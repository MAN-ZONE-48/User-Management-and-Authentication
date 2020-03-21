package id.project.skripsi.manzone.controller;

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

@RestController
@RequestMapping("/v1")
public class UserProfileController {

    final UserService userService;

    @Autowired
    public UserProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile")
    public ResponseEntity getUserProfile(@RequestHeader(value = "Authorization") String token){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization","Bearer "+token);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserProfileDTO responseProfile = userService.getUserProfile(authentication);
        return new ResponseEntity(responseProfile, HttpStatus.OK);
    }
}
