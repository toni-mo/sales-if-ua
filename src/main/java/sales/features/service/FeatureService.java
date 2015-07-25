package sales.features.service;

import sales.features.domain.Feature;

import java.util.List;

/**
 * Created by volodya on 24.07.15.
 */
public interface FeatureService {

    public Feature get(int id);

    public List<Feature> getAll();

    public Feature save(Feature feature);

    public void delete(int id);

}
