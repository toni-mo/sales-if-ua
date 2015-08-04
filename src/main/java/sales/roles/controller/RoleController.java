package sales.roles.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import sales.roles.domain.Role;
import sales.roles.service.RoleService;

/**
 * Created by taras on 29.07.15.
 */
@RestController
public class RoleController {
    final static Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private RoleService roleService;

    public Role getRole(Long id) {
        logger.debug("Get Role by id");
        return roleService.getRoleById(id);
    }
}
