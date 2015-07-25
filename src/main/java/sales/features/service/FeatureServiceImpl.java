package sales.features.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sales.features.domain.Feature;
import sales.features.repository.FeatureRepository;

import java.util.List;

/**
 * Created by volodya on 24.07.15.
 */
@Service("featureService")
@Transactional
public class FeatureServiceImpl implements FeatureService{

    @Autowired
    FeatureRepository repository;


    @Override
    public Feature get(int id) {
        return repository.findById(id);
    }

    @Override
    public List<Feature> getAll() {
        return repository.findAll();
    }

    @Override
    public Feature save(Feature feature) {
        return repository.save(feature);
    }

    @Override
    public void delete(int id) {
        repository.removeById(id);
    }
}
