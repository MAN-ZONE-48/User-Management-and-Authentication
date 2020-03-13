package id.project.skripsi.manzone.dto.response;

import id.project.skripsi.manzone.dto.LoginUserDTO;

public class LoginResponse {

    private LoginUserDTO data;

    public LoginUserDTO getData() {
        return data;
    }

    public void setData(LoginUserDTO data) {
        this.data = data;
    }
}
