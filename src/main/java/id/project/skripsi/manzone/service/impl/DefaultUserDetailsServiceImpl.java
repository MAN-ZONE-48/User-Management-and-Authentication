package id.project.skripsi.manzone.service.impl;

import id.project.skripsi.manzone.dao.UserRepository;
import id.project.skripsi.manzone.dao.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.java.common.lib.domain.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultUserDetailsServiceImpl implements UserDetailsService{

    final UserRepository userRepository;
    final UserRoleRepository userRoleRepository;

    @Autowired
    public DefaultUserDetailsServiceImpl(UserRepository userRepository, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }


    private User buildUserForAuthentication(UserData userData, List<GrantedAuthority> authorities){
        return new User(userData.getUserName(),userData.getUserPassword(), userData.isUserEnable(),true,true,true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(UserData userData){
        List<GrantedAuthority> setAuths = new ArrayList<>();
        setAuths.add(new SimpleGrantedAuthority(userData.getUserRole().getUserRoleName()));

        return setAuths;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserData currentUserData = userRepository.findUserDataByUserName(userName);
        List<GrantedAuthority> authorities = buildUserAuthority(currentUserData);

        if(!currentUserData.getUserName().equals(userName)) throw new UsernameNotFoundException("Invalid Username!");
        return buildUserForAuthentication(currentUserData,authorities);
    }
}
