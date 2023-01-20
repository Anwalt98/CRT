package Framework.DataProvider;

import TestProject.User.User;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DProvider {

    public static JsonElement getJsonElem() throws IOException {
        JsonElement jsonData = null;
        String path = String.valueOf(Paths.get(System.getProperty("user.dir")));
        try (Stream<Path> walk = Files.walk(Path.of(path))) {
            List<String> result = walk.filter(Files::isRegularFile)
                    .filter(x -> x.endsWith("TestData.json"))
                    .map(Path::toString).collect(Collectors.toList());
            path = result.get(0);
            File config = new File(path);
            FileReader reader = null;
            try {
                reader = new FileReader(config.getAbsolutePath());
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            jsonData = new JsonParser().parse(reader);
            return jsonData;
        }
    }

    @DataProvider(name = "TestCase_1")
    public static Object[][] provideUser() {
        try {
            JsonElement dataSet = getJsonElem().getAsJsonObject().get("dataSet1");
            List<User> testData = new Gson().fromJson(dataSet, new TypeToken<List<User>>() {
            }.getType());
            Object[][] returnValue = new Object[testData.size()][1];
            int index = 0;
            for (Object[] each : returnValue) {
                each[0] = testData.get(index++);
            }
            return returnValue;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @DataProvider(name = "TestCase_2")
    public static Object[][] provideUser2() {
        try {
            JsonElement dataSet = getJsonElem().getAsJsonObject().get("dataSet2");
            List<User> testData = new Gson().fromJson(dataSet, new TypeToken<List<User>>() {
            }.getType());
            Object[][] returnValue = new Object[testData.size()][1];
            int index = 0;
            for (Object[] each : returnValue) {
                each[0] = testData.get(index++);
            }
            return returnValue;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @DataProvider(name = "TestCase_3")
    public static Object[][] provideUser3() {
        try {
            JsonElement dataSet = getJsonElem().getAsJsonObject().get("dataSet3");
            List<User> testData = new Gson().fromJson(dataSet, new TypeToken<List<User>>() {
            }.getType());
            Object[][] returnValue = new Object[testData.size()][1];
            int index = 0;
            for (Object[] each : returnValue) {
                each[0] = testData.get(index++);
            }
            return returnValue;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @DataProvider(name = "TestCase_4")
    public static Object[][] provideUser4() {
        try {
            JsonElement dataSet = getJsonElem().getAsJsonObject().get("dataSet4");
            List<User> testData = new Gson().fromJson(dataSet, new TypeToken<List<User>>() {
            }.getType());
            Object[][] returnValue = new Object[testData.size()][1];
            int index = 0;
            for (Object[] each : returnValue) {
                each[0] = testData.get(index++);
            }
            return returnValue;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @DataProvider(name = "TestCase_5")
    public static Object[][] provideUser5() {
        try {
            JsonElement dataSet = getJsonElem().getAsJsonObject().get("dataSet5");
            List<User> testData = new Gson().fromJson(dataSet, new TypeToken<List<User>>() {
            }.getType());
            Object[][] returnValue = new Object[testData.size()][1];
            int index = 0;
            for (Object[] each : returnValue) {
                each[0] = testData.get(index++);
            }
            return returnValue;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @DataProvider(name = "TestCase_6")
    public static Object[][] provideUser6() {
        try {
            JsonElement dataSet = getJsonElem().getAsJsonObject().get("dataSet6");
            List<User> testData = new Gson().fromJson(dataSet, new TypeToken<List<User>>() {
            }.getType());
            Object[][] returnValue = new Object[testData.size()][1];
            int index = 0;
            for (Object[] each : returnValue) {
                each[0] = testData.get(index++);
            }
            return returnValue;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

