package sales.descriptions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sales.descriptions.domain.Description;

/**
 * Created by volodya on 30.07.15.
 */
public interface DescriptiionRepository extends JpaRepository<Description, Long> {

    public Description findById(long id);

    public void removeById(long id);

}
