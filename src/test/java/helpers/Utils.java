package helpers;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;
import constants.TestConstants;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Utils {

    public static String generateStringFromResource(String fileName) throws IOException {

        String filePath = new File("").getAbsolutePath();
        filePath = filePath.concat(TestConstants.TEST_RESOURCES_DIR_PATH);
        String result = new String(Files.readAllBytes(Paths.get( filePath+fileName)));
        return result;

    }

    public static JsonObject parseJsonStringToJSONObject(String jsonStr ){
        JsonObject jsonObject = Json.parse(jsonStr).asObject();
        return jsonObject;

    }
}
