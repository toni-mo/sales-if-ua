package sales.goods.generator;

import sales.goods.domain.Good;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

/**
 * Created by volodya on 23.07.15.
 */
public class GoodsGenerator {

    protected static Logger logger = Logger.getLogger(GoodsGenerator.class.getName());

    List<String> listName;
    List<String> listDescription;

    public GoodsGenerator(){
        listName = new ArrayList<String>();
        listDescription = new ArrayList<String>();
    }

    public void init(String fileName) throws IOException {
        String[] row;
        CustomCSVReader reader = new CustomCSVReader(fileName);
        List cells = reader.read();
        for (Object object : cells) {
            row = (String[]) object;
            listName.add(row[0]);
            listDescription.add(row[1]);
        }
    }

    public List<Good> generateList() {
        Random r = new Random();
        List<Good> list = new ArrayList<Good>();
        for (int i = 0; i < listName.size(); i++) {
            list.add(createGood(listName.get(r.nextInt(listName.size())),
                    listDescription.get(r.nextInt(listName.size()))));
        }
        return list;
    }

    private Good createGood(String name, String description) {
        Good good = new Good.GoodsBuilder()
                .name(name)
                .description(description)
                .amount(this.random(10, 50))
                .price(this.random(1, 100))
                .build();
        return good;
    }

    private int random(int from, int to) {
        Random r = new Random();
        return r.nextInt(to - from) + from;
    }

}
