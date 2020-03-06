package id.project.skripsi.manzone.service;

import org.springframework.security.core.Authentication;

public interface AuthenticationProviderService {

    Authentication authenticate(final Authentication authentication);

}
