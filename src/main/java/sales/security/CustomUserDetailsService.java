package sales.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sales.users.repository.UserRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by taras on 28.07.15.
 */

@Service
@Transactional(readOnly = true)
public class CustomUserDetailsService implements UserDetailsService {
    final static Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);


    @Autowired
    private UserRepository userRepository;

    /**
     * Returns a populated {@link UserDetails} object.
     * The username is first retrieved from the database and then mapped to
     * a {@link UserDetails} object.
     */
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        logger.debug("Process of authorization");
        try {
            sales.users.domain.User domainShop = userRepository.findByEmail(userEmail);
            boolean enabled = true;
            boolean accountNonExpired = true;
            boolean credentialsNonExpired = true;
            boolean accountNonLocked = true;

            return new User(
                    domainShop.getEmail(),
                    StringToMd5.getMd5(domainShop.getPassword().toLowerCase()),
                    enabled,
                    accountNonExpired,
                    credentialsNonExpired,
                    accountNonLocked,
                    getAuthorities(2));

        } catch (Exception e) {
            logger.error("Can`t authorize user " + e);
            throw new RuntimeException(e);
        }
    }

    /**
     * Retrieves a collection of {@link GrantedAuthority} based on a numerical role
     * @param role the numerical role
     * @return a collection of {@link GrantedAuthority
     */
    public Collection<? extends GrantedAuthority> getAuthorities(Integer role) {
        List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));
        return authList;
    }

    /**
     * Converts a numerical role to an equivalent list of roles
     * @param role the numerical role
     * @return list of roles as as a list of {@link String}
     */
    public List<String> getRoles(Integer role) {
        List<String> roles = new ArrayList<String>();

        if (role.intValue() == 1) {
            roles.add("ROLE_USER");
            roles.add("ROLE_ADMIN");

        } else if (role.intValue() == 2) {
            roles.add("ROLE_USER");
        } else if (role.intValue() == 3) {
            roles.add("ROLE_SHOP");
        }

        return roles;
    }

    /**
     * Wraps {@link String} roles to {@link SimpleGrantedAuthority} objects
     * @param roles {@link String} of roles
     * @return list of granted authorities
     */
    public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }
}