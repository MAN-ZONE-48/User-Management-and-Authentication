package id.project.skripsi.manzone.service.impl;

import id.project.skripsi.manzone.dao.UserRepository;
import id.project.skripsi.manzone.dao.UserRoleRepository;
import id.project.skripsi.manzone.domain.UserData;
import id.project.skripsi.manzone.domain.UserRole;
import id.project.skripsi.manzone.dto.RegisterUserDTO;
import id.project.skripsi.manzone.dto.response.RegisterResponse;
import id.project.skripsi.manzone.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService {

    final UserRepository userRepository;
    final UserRoleRepository userRoleRepository;
    final PasswordEncoder passwordEncoder;

    @Autowired
    public RegisterServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public RegisterResponse saveUserDataForRegisterOwner(RegisterResponse registerResponse) {
        try {
            UserData userData = new UserData();
            UserRole currentUserRole = userRoleRepository.findUserRoleByUserRoleName("OWNER");
            insertData(userData, registerResponse, currentUserRole);

            userRepository.save(userData);
            return registerResponse;
        }catch(Exception e){
            return null;
        }
    }

    @Override
    public RegisterResponse saveUserDataForOwner(RegisterResponse registerResponse) {
        UserData userData = new UserData();
        UserRole currentUserRole = userRoleRepository.findUserRoleByUserRoleName(registerResponse.getData().getUserRole().getUserRoleName());
        insertData(userData,registerResponse, currentUserRole);

        userRepository.save(userData);
        return registerResponse;
    }

    private void insertData(UserData userData, RegisterResponse registerResponse, UserRole currentUserRole){
        List<UserRole> userRoleList = new ArrayList<>();
        userRoleList.add(currentUserRole);
        userData.setUserName(registerResponse.getData().getUserName());
        userData.setUserAddress(registerResponse.getData().getUserAddress());
        userData.setUserPassword(passwordEncoder.encode(registerResponse.getData().getUserPassword()));
        userData.setUserPhone(registerResponse.getData().getUserPhone());
        userData.setUserEnable(true);
        userData.setUserRole(userRoleList);
        userData.setUserDob(registerResponse.getData().getUserDob());
        userData.setUserGender(registerResponse.getData().getUserGender());
        userData.setUserEmail(registerResponse.getData().getUserEmail());
    }
}
