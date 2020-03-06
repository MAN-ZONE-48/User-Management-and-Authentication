package id.project.skripsi.manzone.service.impl;

import id.project.skripsi.manzone.dao.UserRepository;
import id.project.skripsi.manzone.domain.UserData;
import id.project.skripsi.manzone.service.DefaultUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class DefaultUserDetailsServiceImpl implements DefaultUserDetailsService {

    final UserRepository userRepository;

    @Autowired
    public DefaultUserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) {
        return null;
    }

    private UserDetails getUserDetails(String userName, String userPassword){

        UserData currentUserData = userRepository.findUserDataByUserName(userName);
        List<GrantedAuthority> authorities =

        if(!currentUserData.getUserName().equals(userName) || !currentUserData.getUserPassword().equals(userPassword)) throw new UsernameNotFoundException("Invalid Username or Password!");

    }

    private User buildUserForAuthentication(UserData userData, List<GrantedAuthority> authorities){
        return new User(userData.getUserName(),userData.getUserPassword(), userData.isUserEnable(),true,true,true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(){

    }

}
