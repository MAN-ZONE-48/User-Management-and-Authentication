package id.project.skripsi.manzone.dto;

import id.project.skripsi.manzone.domain.UserData;
import id.project.skripsi.manzone.domain.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserDetail implements UserDetails {

    private UserData userData;
    private UserRole userRole;

    public UserDetail(UserData userData) {
        this.userData = userData;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.userData.getUserPassword();
    }

    @Override
    public String getUsername() {
        return this.userData.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
