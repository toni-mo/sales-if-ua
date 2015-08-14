package sales.goods.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sales.category.domain.SubCategory;
import sales.goods.domain.Good;

import java.util.List;

/**
 * Created by volodya on 21.07.15.
 */
public interface GoodsRepository extends JpaRepository<Good, Long>  {

    public List<Good> findByNameContainingIgnoreCase(String name);

    public Good findById(long id);

    public void removeById(long id);

    public List<Good> findBySubCategory(SubCategory subCategory);
}
