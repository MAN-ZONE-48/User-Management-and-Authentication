package id.project.skripsi.manzone.dto.response;

import id.project.skripsi.manzone.dto.RegisterUserDTO;

public class RegisterResponse {

    private RegisterUserDTO data;

    public RegisterUserDTO getData() {
        return data;
    }

    public void setData(RegisterUserDTO data) {
        this.data = data;
    }
}
