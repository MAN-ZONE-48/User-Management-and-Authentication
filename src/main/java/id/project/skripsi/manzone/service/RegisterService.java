package id.project.skripsi.manzone.service;

import id.project.skripsi.manzone.dto.response.RegisterResponse;
import org.springframework.stereotype.Service;

@Service
public interface RegisterService {

    String saveUserDataForRegisterOwner(RegisterResponse registerResponse);
    String saveUserDataForOwner(RegisterResponse registerResponse);

}
