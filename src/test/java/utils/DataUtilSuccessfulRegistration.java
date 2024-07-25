package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

public class DataUtilSuccessfulRegistration {

    @DataProvider
    public Object[] dataProviderSuccessfulRegistration() {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;

        // Read JSON file
        try {
            Object obj = parser.parse(new FileReader("src/test/test_data/testDataSuccessfulRegistration.json"));
            jsonObject = (JSONObject) obj;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        // Array to store JSON data
        Object[] data = new Object[1];

        // Store JSON data in key/value pairs in hashmap
        HashMap<String, String> hashMap = new LinkedHashMap<>();
        if (jsonObject != null) {
            Set<String> jsonObjKeys = jsonObject.keySet();
            for (String jsonObjKey : jsonObjKeys) {
                hashMap.put(jsonObjKey, (String) jsonObject.get(jsonObjKey));
            }
        } else {
            throw new RuntimeException();
        }

        // Store hashmap in an array and return an array
        data[0] = hashMap;
        return data;
    }

}
