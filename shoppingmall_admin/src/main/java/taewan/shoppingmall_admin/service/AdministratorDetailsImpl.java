package taewan.shoppingmall_admin.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import taewan.shoppingmall_admin.entity.Administrator;

import java.util.Collection;

public class AdministratorDetailsImpl implements UserDetails {

    private Administrator administrator;

    public AdministratorDetailsImpl(Administrator administrator) {
        this.administrator = administrator;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return administrator.getPassword();
    }

    @Override
    public String getUsername() {
        return administrator.getUserId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
