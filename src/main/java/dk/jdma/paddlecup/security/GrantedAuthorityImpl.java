package dk.jdma.paddlecup.security;

import org.springframework.security.core.GrantedAuthority;


public class GrantedAuthorityImpl implements GrantedAuthority {

    private String roleName;

    public GrantedAuthorityImpl(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String getAuthority() {
        return this.roleName;
    }
}
