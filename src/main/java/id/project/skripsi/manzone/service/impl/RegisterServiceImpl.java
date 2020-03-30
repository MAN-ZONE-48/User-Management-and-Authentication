package id.project.skripsi.manzone.service.impl;

import com.java.common.lib.domain.UserData;
import com.java.common.lib.domain.UserRole;
import id.project.skripsi.manzone.dao.UserRepository;
import id.project.skripsi.manzone.dao.UserRoleRepository;
import id.project.skripsi.manzone.dto.response.RegisterResponse;
import id.project.skripsi.manzone.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {

    final UserRoleRepository userRoleRepository;
    final PasswordEncoder passwordEncoder;
    final UserRepository userRepository;

    @Autowired
    public RegisterServiceImpl(PasswordEncoder passwordEncoder, UserRoleRepository userRoleRepository, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRoleRepository = userRoleRepository;
        this.userRepository = userRepository;
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

        userData.setUserName(registerResponse.getData().getUserName());
        userData.setUserAddress(registerResponse.getData().getUserAddress());
        userData.setUserPassword(passwordEncoder.encode(registerResponse.getData().getUserPassword()));
        userData.setUserPhone(registerResponse.getData().getUserPhone());
        userData.setUserEnable(true);
        userData.setUserRole(currentUserRole);
        userData.setUserDob(registerResponse.getData().getUserDob());
        userData.setUserGender(registerResponse.getData().getUserGender());
        userData.setUserEmail(registerResponse.getData().getUserEmail());
    }
}
