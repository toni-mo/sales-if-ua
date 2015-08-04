package sales.users.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sales.users.domain.Country;
import sales.users.repository.CountryRepository;

import java.util.List;

/**
 * Created by taras on 04.08.15.
 */
@Service("countryService")
public class CountryServiceImpl implements CountryService{

    final static Logger logger = LoggerFactory.getLogger(CountryServiceImpl.class);

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<Country> getAll() {
        logger.debug("Get all countries");
        return countryRepository.findAll();
    }

    @Override
    public Country getOne(Long id) {
        logger.debug("Get country by id");
        return countryRepository.findOne(id);
    }

    @Override
    public Country getOneByName(String name) {
        logger.debug("Get country by name");
        return countryRepository.findByName(name);
    }
}
