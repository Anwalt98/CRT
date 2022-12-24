package Framework.ConfigUtils;

import Framework.Utils.StringUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test3Data {
    private static String game;
    private static String hero;
    private static String search_input;
    private static String rarity;
    private static int numberOfResultsToCheckInput;
    private static int numberOfResultToClick;
    public static void setTestValues()  {
        try {
            String path = String.valueOf(Paths.get(System.getProperty("user.dir")));
            try (Stream<Path> walk = Files.walk(Path.of(path))) {
                List<String> result = walk.filter(Files::isRegularFile)
                        .filter(x -> x.endsWith("test3Data.json"))
                        .map(Path::toString).collect(Collectors.toList());
                path = result.get(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
            File config = new File(path);
            FileReader reader = new FileReader(config.getAbsolutePath());
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
            game  = (String) jsonObject.get("GAME");
            hero = (String) jsonObject.get("HERO");
            search_input = (String) jsonObject.get("SEARCH_INPUT");
            rarity = (String) jsonObject.get("RARITY");
            numberOfResultsToCheckInput = StringUtils.getInt((String) jsonObject.get("NUMBER_OF_RESULTS_TO_CHECK"));
            numberOfResultToClick = StringUtils.getInt((String) jsonObject.get("NUMBER_OF_RESULT_TO_CLICK"));
        }
        catch (ParseException ignored){
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static String getGame(){
        return game;
    }
    public static String getHero(){
        return hero;
    }
    public static String getSearchInput(){
        return search_input;
    }
    public static String getRarity(){
        return rarity;
    }
    public static int getNumberOfResultToCheckFilters(){
        return numberOfResultsToCheckInput;
    }
    public static int getNumberOfResultToClick(){
        return numberOfResultToClick;
    }
}
