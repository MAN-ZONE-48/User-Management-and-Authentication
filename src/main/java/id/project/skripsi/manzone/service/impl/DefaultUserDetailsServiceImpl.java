package id.project.skripsi.manzone.service.impl;

import id.project.skripsi.manzone.dao.UserRepository;
import id.project.skripsi.manzone.domain.UserData;
import id.project.skripsi.manzone.domain.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultUserDetailsServiceImpl implements UserDetailsService{

    final UserRepository userRepository;

    @Autowired
    public DefaultUserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    private User buildUserForAuthentication(UserData userData, List<GrantedAuthority> authorities){
        return new User(userData.getUserName(),userData.getUserPassword(), userData.isUserEnable(),true,true,true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(List<UserRole> userRoles){
        List<GrantedAuthority> setAuths = new ArrayList<GrantedAuthority>();

        for(UserRole userRole : userRoles){
            setAuths.add(new SimpleGrantedAuthority(userRole.getUserRoleName()));
        }
        return setAuths;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserData currentUserData = userRepository.findUserDataByUserName(userName);
        List<GrantedAuthority> authorities = buildUserAuthority(currentUserData.getUserRole());

        if(!currentUserData.getUserName().equals(userName)) throw new UsernameNotFoundException("Invalid Username!");
        return buildUserForAuthentication(currentUserData,authorities);
    }
}
