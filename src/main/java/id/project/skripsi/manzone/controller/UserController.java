package id.project.skripsi.manzone.controller;

import com.java.common.lib.dto.Response;
import id.project.skripsi.manzone.dto.UserDTO;
import id.project.skripsi.manzone.dto.response.UserRoleResponse;
import id.project.skripsi.manzone.service.UserRoleService;
import id.project.skripsi.manzone.service.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static com.java.common.lib.constant.ResponseConstant.OK;

@RestController
@RequestMapping("/v1")
public class UserController {

    final UserRoleService userRoleService;
    final UserService userService;

    public UserController(UserRoleService userRoleService, UserService userService) {
        this.userRoleService = userRoleService;
        this.userService = userService;
    }

    @GetMapping("/getAllUserRole")
    public ResponseEntity getUserRoleList(@RequestHeader(value = "Authorization") String token, HttpServletResponse response){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization",token);

        UserRoleResponse roleResponse = userRoleService.getUserRole();
        return new ResponseEntity(new Response(false,response.getStatus(),OK.getMessage(),roleResponse), HttpStatus.OK);
    }

    @GetMapping("/getAllUser")
    public ResponseEntity getAllUser(@RequestHeader(value = "Authorization") String token,HttpServletResponse response){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization",token);

        List<UserDTO> userDTOList = userService.getAllUser();
        return new ResponseEntity(new Response(false,response.getStatus(),OK.getMessage(),userDTOList), HttpStatus.OK);
    }
}
