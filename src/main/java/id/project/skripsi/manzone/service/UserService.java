package id.project.skripsi.manzone.service;

import id.project.skripsi.manzone.dto.UserDTO;
import id.project.skripsi.manzone.dto.UserProfileDTO;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    UserProfileDTO getUserProfile(Authentication authentication);
    List<UserDTO> getAllUser();

}
