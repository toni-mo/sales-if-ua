package sales.goods.service;

import sales.goods.domain.Good;

import java.util.List;
import java.util.Map;

public interface GoodsService {

    public Good get(int id);

    public List<Good> getAll();

    public Good save(Good goods);

    public void delete(int id);

    public List<Good> page(int page, int amount, Map<String, String> sort);

    public List<Good> searchByName(String name);

    public List<Good> filterPriceScope(int from, int to);

}
