package id.project.skripsi.manzone.service.impl;

import id.project.skripsi.manzone.dao.UserRepository;
import id.project.skripsi.manzone.domain.UserData;
import id.project.skripsi.manzone.service.AuthenticationProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;

import java.util.Optional;

public class AuthenticationProviderServiceImpl implements AuthenticationProviderService {

    private final UserRepository userRepository;

    @Autowired
    public AuthenticationProviderServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Authentication authenticate(Authentication authentication) {

        if(authentication.getName() == null || authentication.getName().isEmpty() || authentication.getCredentials() == null || authentication.getCredentials().toString().isEmpty()) return null;

        final Optional<UserData> user = this.userRepository.findOne(authentication.getName());
        if(user.isPresent()){

        }

    }
}
