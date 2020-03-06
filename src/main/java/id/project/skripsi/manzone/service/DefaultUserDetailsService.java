package id.project.skripsi.manzone.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface DefaultUserDetailsService {

    UserDetails loadUserByUsername(String userName);

}
