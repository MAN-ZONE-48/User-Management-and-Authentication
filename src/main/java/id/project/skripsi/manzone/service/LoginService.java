package id.project.skripsi.manzone.service;

import id.project.skripsi.manzone.dto.response.LoginResponse;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {

    LoginResponse getUserAccount(LoginResponse loginResponse);

}
