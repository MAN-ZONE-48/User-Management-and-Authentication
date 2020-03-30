package id.project.skripsi.manzone.service.impl;

import com.java.common.lib.domain.UserData;
import id.project.skripsi.manzone.dao.UserRepository;
import id.project.skripsi.manzone.dto.UserDTO;
import id.project.skripsi.manzone.dto.UserProfileDTO;
import id.project.skripsi.manzone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserProfileDTO getUserProfile(Authentication authentication) {
        UserData currentUserData = userRepository.findUserDataByUserName(authentication.getName());
        UserProfileDTO userProfileDTO = new UserProfileDTO.Builder(currentUserData.getUserName())
                .withEmail(currentUserData.getUserEmail())
                .withGender(currentUserData.getUserGender())
                .withPhoneNumber(currentUserData.getUserPhone())
                .withAge(calculateUserAge(currentUserData.getUserDob(),new Date()))
                .build();

        return userProfileDTO;

    }

    @Override
    public List<UserDTO> getAllUser() {
        List<UserData> userDataList = userRepository.getAllUser();
        List<UserDTO> userDTOS = new ArrayList<>();

        for(int count = 0; count<userDataList.size(); count++){
            UserDTO userDTO = new UserDTO();
            userDTO.setUserId(userDataList.get(count).getId());
            userDTO.setUserName(userDataList.get(count).getUserName());
            userDTO.setUserAddress(userDataList.get(count).getUserAddress());
            userDTO.setUserGender(userDataList.get(count).getUserGender());
            userDTO.setUserEmail(userDataList.get(count).getUserEmail());
            userDTOS.add(userDTO);
        }
        return userDTOS;
    }

    private int calculateUserAge(Date dob, Date currentTime){
        DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        int myDob = Integer.parseInt(formatter.format(dob));
        int currentDate = Integer.parseInt(formatter.format(currentTime));

        int age = (currentDate-myDob) / 10000;
        return age;
    }
}
