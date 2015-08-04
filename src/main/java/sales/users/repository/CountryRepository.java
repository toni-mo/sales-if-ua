package sales.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sales.users.domain.Country;

/**
 * Created by taras on 04.08.15.
 */
public interface CountryRepository extends JpaRepository<Country, Long> {
    Country findByName(String name);
}
