package sales.descriptions.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sales.descriptions.domain.Description;
import sales.descriptions.repository.DescriptiionRepository;

import java.util.List;

/**
 * Created by volodya on 30.07.15.
 */
@Service("descriptionService")
@Transactional
public class DescriptionImpl implements DescriptionService {

    @Autowired
    private DescriptiionRepository repository;

    @Override
    public Description get(long id) {
        return repository.findById(id);
    }

    @Override
    public List<Description> get() {
        return repository.findAll();
    }

    @Override
    public Description save(Description description) {
        return repository.save(description);
    }

    @Override
    public void delete(long id) {
        repository.removeById(id);
    }
}
