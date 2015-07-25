package sales.features.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sales.features.domain.Feature;

/**
 * Created by volodya on 24.07.15.
 */
public interface FeatureRepository extends JpaRepository<Feature, Integer> {

    public Feature findById(int id);

    public void removeById(int id);

}
