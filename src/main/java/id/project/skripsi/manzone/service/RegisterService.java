package id.project.skripsi.manzone.service;

import id.project.skripsi.manzone.domain.UserData;
import id.project.skripsi.manzone.dto.response.RegisterResponse;
import org.springframework.stereotype.Service;

@Service
public interface RegisterService {

    UserData saveUserDataForRegisterOwner(RegisterResponse registerResponse);
    UserData saveUserDataForOwner(RegisterResponse registerResponse);

}
