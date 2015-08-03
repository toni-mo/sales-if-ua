package sales.goods.generator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sales.goods.repository.GoodsRepository;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * Created by volodya on 23.07.15.
 */


//@Component
public class Fixtures {

    @Autowired
    private GoodsRepository repository;

//    @PostConstruct
//    public void init() throws IOException {
//        GoodsGenerator generator = new GoodsGenerator();
//        generator.init("goodsresource");
//        for (int i = 0; i < 2; i++) {
//            repository.save(generator.generateList());
//        }
//    }

}
