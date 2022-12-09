/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ukrim.co.id.serversideukrim.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author MSI-JO
 */
public class AppUserDetail implements UserDetails {

    private User user;

    public AppUserDetail(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return user.getRoles().stream()
//                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName().toUpperCase()))
//                .collect(Collectors.toList());// ROLE_USER
        
        List<GrantedAuthority> authroities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            String roleName = "ROLE_"+ role.getName().toUpperCase();
            authroities.add(new SimpleGrantedAuthority(roleName));
            
            role.getPrivilages().forEach(privilage -> {
                String privilageName = privilage.getName().toUpperCase();
                authroities.add(new SimpleGrantedAuthority(privilageName));
            });
        });
        
        return authroities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getPassword();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !user.getIsAccountLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.getIsEnabled();
    }

}
