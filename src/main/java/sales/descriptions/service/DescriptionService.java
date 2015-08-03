package sales.descriptions.service;

import sales.descriptions.domain.Description;

import java.util.List;

/**
 * Created by volodya on 30.07.15.
 */
public interface DescriptionService {

    public Description get(long id);

    public List<Description> get();

    public Description save(Description description);

    public void delete(long id);


}
