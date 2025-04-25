package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Utils {
    public static int genarateRandom(int max, int min){
       double randomID = Math.random()*(max-min)+min;
       return (int) randomID;
    }
    public static void saveUserInfo(String filePath, JSONObject jsonObject) throws InterruptedException, IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(filePath));
        jsonArray.add(jsonObject);//object to array
        FileWriter file = new FileWriter(filePath);
        file.write(jsonArray.toJSONString());
        file.flush();
        file.close();

    }
}
