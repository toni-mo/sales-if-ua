package sales.goods.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sales.goods.domain.Good;

import java.util.List;

/**
 * Created by volodya on 21.07.15.
 */
public interface GoodsRepository extends JpaRepository<Good, Integer>  {

    public List<Good> findByNameContainingIgnoreCase(String name);

    public Good findById(int id);

    public void removeById(int id);

    public List<Good> findByPriceBetween(int from, int to);

}
