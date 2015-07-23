package sales.goods.generator;

import au.com.bytecode.opencsv.CSVReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Created by volodya on 23.07.15.
 */
public class CustomCSVReader {

    private String fileName;

    public CustomCSVReader(String fileName) {
        this.fileName = fileName;
    }

    public List read() throws IOException {
        String filePath = new File("").getAbsolutePath();
        CSVReader csvReader = new CSVReader(new FileReader(filePath+"/src/main/webapp/resources/"+fileName+".csv"));
        return csvReader.readAll();
    }
}
