package domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.Assert;

/**
 * Created by nkanakis on 10/4/2017.
 */
public class CustomSimpleGrantedAuthority implements GrantedAuthority {
    private static final long serialVersionUID = 420L;
    private final String role;

    public CustomSimpleGrantedAuthority(String role) {
        Assert.hasText(role, "A granted authority textual representation is required");
        this.role = role;
    }

    public CustomSimpleGrantedAuthority() {
        this.role = "ROLE_USER";
    }

    @Override
    public String getAuthority() {
        return this.role;
    }

    public boolean equals(Object obj) {
        return this == obj ? true : (obj instanceof CustomSimpleGrantedAuthority ? this.role.equals(((CustomSimpleGrantedAuthority) obj).role) : false);
    }

    public int hashCode() {
        return this.role.hashCode();
    }

    public String toString() {
        return this.role;
    }
}
