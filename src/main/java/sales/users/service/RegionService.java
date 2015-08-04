package sales.users.service;

import sales.users.domain.Country;
import sales.users.domain.Region;

import java.util.List;

/**
 * Created by taras on 04.08.15.
 */
public interface RegionService {
    List<Region> getAll(Country country);

    Region getOne(Country country, Long id);

    Region getOneByName(String name);
}
