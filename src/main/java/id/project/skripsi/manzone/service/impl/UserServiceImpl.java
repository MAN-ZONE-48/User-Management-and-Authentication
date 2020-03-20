package id.project.skripsi.manzone.service.impl;

import id.project.skripsi.manzone.dao.UserRepository;
import id.project.skripsi.manzone.domain.UserData;
import id.project.skripsi.manzone.dto.UserProfileDTO;
import id.project.skripsi.manzone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UserServiceImpl  implements UserService {

    final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserProfileDTO getUserProfile(Authentication authentication) {
        UserData currentUserData = userRepository.findUserDataByUserName(authentication.getName());
        UserProfileDTO userProfileDTO = new UserProfileDTO.Builder(currentUserData.getUserName())
                .withEmail(currentUserData.getUserEmail()).withGender(currentUserData.getUserGender())
                .withPhoneNumber(currentUserData.getUserPhone()).withAge(calculateUserAge(currentUserData.getUserDob(),new Date())).build();

        return userProfileDTO;

    }

    private int calculateUserAge(Date dob, Date currentTime){
        DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        int mydob = Integer.parseInt(formatter.format(dob));
        int currentDate = Integer.parseInt(formatter.format(currentTime));

        int age = (currentDate-mydob) / 10000;
        return age;
    }
}
