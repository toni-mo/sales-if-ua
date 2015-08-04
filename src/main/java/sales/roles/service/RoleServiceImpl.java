package sales.roles.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sales.roles.domain.Role;
import sales.roles.repository.RoleRepository;

/**
 * Created by taras on 29.07.15.
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    final static Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);


    @Autowired
    private RoleRepository roleRepository;

    public Role getRoleById(Long id) {
        logger.debug("Get role by id");
        return roleRepository.findOne(id);
    }

    public Role getRoleByValue(String value) {
        logger.debug("Get role by value");
        return roleRepository.findByValue(value);
    }
}
