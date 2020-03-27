package id.project.skripsi.manzone.controller;

import com.java.common.lib.dto.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import static com.java.common.lib.constant.ResponseConstant.*;

@RestController
@RequestMapping("/v1")
public class LogoutController {

    @PostMapping("/logout")
    public ResponseEntity logOutUser(HttpServletResponse response){
        return new ResponseEntity(new Response(false,response.getStatus(),OK.getMessage(),"Logout Success"), HttpStatus.OK);
    }

}
