package sales.users.service;

import sales.users.domain.Country;

import java.util.List;

/**
 * Created by taras on 04.08.15.
 */
public interface CountryService {

    List<Country> getAll();

    Country getOne(Long id);

    Country getOneByName(String name);
}
