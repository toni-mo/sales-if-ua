package sales.goods.service;

import com.google.common.collect.Lists;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sales.goods.domain.Good;
import sales.goods.repository.GoodsRepository;

import javax.persistence.criteria.Order;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service("goodsService")
@Transactional
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsRepository repository;

    public Good get(int id) {
        return repository.findById(id);
    }

    public List<Good> getAll() {
        return repository.findAll();
    }

    public Good save(Good good) {
        repository.save(good);
        return good;
    }

    public void delete(int id) {
        repository.removeById(id);
    }

    public List<Good> page(int page, int amount, Map<String, String> sort) {
        PageRequest pageRequest;
        if (sort == null || sort.isEmpty()) {
            pageRequest = new PageRequest(page, amount);
        } else {
            List<Sort.Order> orders = new ArrayList();
            Set<String> sortParams = sort.keySet();
            for (String sortParam : sortParams) {
                orders.add(new Sort.Order(Sort.Direction.fromString(sort.get(sortParam)), sortParam));
            }
            pageRequest = new PageRequest(
                    page,
                    amount,
                    new Sort(orders));
        }
        return Lists.newArrayList(repository.findAll(pageRequest).getContent());
    }

    public List<Good> searchByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }

    public List<Good> filterPriceScope(int from, int to)
    {
        return repository.findByPriceBetween(from, to);
    }
}
