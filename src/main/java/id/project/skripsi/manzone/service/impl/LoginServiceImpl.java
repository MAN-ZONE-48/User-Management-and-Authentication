package id.project.skripsi.manzone.service.impl;

import id.project.skripsi.manzone.dao.UserRepository;
import id.project.skripsi.manzone.domain.UserData;
import id.project.skripsi.manzone.dto.response.LoginResponse;
import id.project.skripsi.manzone.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    final UserDetailsService userDetailsService;
    final PasswordEncoder passwordEncoder;
    final UserRepository userRepository;
    final AuthenticationManager authenticationManager;

    @Autowired
    public LoginServiceImpl(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder, UserRepository userRepository, AuthenticationManager authenticationManager) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public LoginResponse getUserAccount(LoginResponse loginResponse) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginResponse.getData().getUsername());
        UserData userData =  userRepository.findUserDataByUserName(loginResponse.getData().getUsername());

        if(userDetails == null || !passwordEncoder.matches(loginResponse.getData().getPassword(),userData.getUserPassword()))
            throw new UsernameNotFoundException("Incorrect Username or Password!");

        Authentication request = new UsernamePasswordAuthenticationToken(userData.getUserName(), userData.getUserPassword(), userDetails.getAuthorities());
        Authentication response = authenticationManager.authenticate(request);
        SecurityContextHolder.getContext().setAuthentication(response);

        return loginResponse;
    }
}
