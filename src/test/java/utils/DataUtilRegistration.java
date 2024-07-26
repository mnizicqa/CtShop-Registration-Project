package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

public class DataUtilRegistration {

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
    @DataProvider
    public Object[] dataProviderErrorMessages() {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject;

        // Read JSON data
        Object obj = null;
        try {
            obj = parser.parse(new FileReader("src/test/test_data/testDataErrorMessages.json"));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        jsonObject = (JSONObject) obj;

        // Extract array data from JSONObject
        assert jsonObject != null;
        JSONArray registrationInfo = (JSONArray) jsonObject.get("registration info");

        // String array to store JSONArray data
        String[] dataArray = new String[registrationInfo.size()];

        // JSONObject to read each JSONArray object
        JSONObject registrationInfoData;
        String firstName, lastName, email, password, errorMessage;

        // Get data from JSONArray and store in String array
        for(int i = 0; i < registrationInfo.size(); i++) {
            registrationInfoData = (JSONObject) registrationInfo.get(i);
            firstName = (String) registrationInfoData.get("First Name");
            lastName = (String) registrationInfoData.get("Last Name");
            email = (String) registrationInfoData.get("Email");
            password = (String) registrationInfoData.get("Password");
            errorMessage = (String) registrationInfoData.get("Error Message");

            dataArray[i] = firstName + "," + lastName + "," + email + "," + password + ","  + errorMessage;
        }
        return dataArray;
    }
}
