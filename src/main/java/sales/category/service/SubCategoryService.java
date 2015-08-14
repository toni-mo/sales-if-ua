package sales.category.service;

import sales.category.domain.SubCategory;

import java.util.List;

/**
 * Created by taras on 11.08.15.
 */
public interface SubCategoryService {

    SubCategory findOne(Long id);

    List<SubCategory> findAll(Long id);

    SubCategory findOne(Long id, Long idS);
}
