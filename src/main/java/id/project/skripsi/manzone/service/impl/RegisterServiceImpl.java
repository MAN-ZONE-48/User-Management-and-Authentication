package id.project.skripsi.manzone.service.impl;

import id.project.skripsi.manzone.dao.UserRepository;
import id.project.skripsi.manzone.domain.UserData;
import id.project.skripsi.manzone.dto.response.RegisterResponse;
import id.project.skripsi.manzone.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {

    final UserRepository userRepository;
    final PasswordEncoder passwordEncoder;

    @Autowired
    public RegisterServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserData saveUserData(RegisterResponse registerResponse) {
        UserData userData = new UserData();
        userData.setUserName(registerResponse.getData().getUserName());
        userData.setUserAddress(registerResponse.getData().getUserAddress());
        userData.setUserPassword(passwordEncoder.encode(registerResponse.getData().getUserPassword()));
        userData.setUserPhone(registerResponse.getData().getUserPhone());

        return userRepository.save(userData);
    }
}
