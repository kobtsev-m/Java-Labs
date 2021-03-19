package morse;

import utils.FileUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Converter {

    private Map<String, String> decodeMap = new HashMap<>();
    private Map<String, String> encodeMap = new HashMap<>();

    public Converter(String lang) {
        FileUtils fileUtils = new FileUtils(lang + ".txt", "src/convert_files");
        BufferedReader covertFileReader = fileUtils.getFileReader();
        try {
            while (true) {
                String charLine = covertFileReader.readLine();
                if (charLine == null) break;
                String[] args = charLine.split(" ");
                encodeMap.put(args[0], args[1]);
                decodeMap.put(args[1], args[0]);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Map<String, String> getMap(String operation) {
        return operation.equals("code") ? encodeMap : decodeMap;
    }
}
