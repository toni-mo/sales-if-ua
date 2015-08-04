package sales.roles.service;

import sales.roles.domain.Role;

/**
 * Created by taras on 29.07.15.
 */
public interface RoleService {
    Role getRoleById(Long id);

    Role getRoleByValue(String value);
}
