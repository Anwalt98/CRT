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
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ConfigUtils {

    private static String browser;
    private static String options;
    private static String URL;
    private static String language;
    private static int wait;
    public static void setConfValues()  {
      try {
          String path = System.getProperty("user.dir");
          try (Stream<Path> walk = Files.walk(Path.of(path))) {
              List<String> result = walk.filter(Files::isRegularFile)
                      .filter(x -> x.endsWith("config.json"))
                      .map(Path::toString).collect(Collectors.toList());
              path = result.get(0);
          } catch (IOException e) {
              e.printStackTrace();
          }
          File config = new File(path);
          FileReader reader = new FileReader(config.getAbsolutePath());
          JSONParser jsonParser = new JSONParser();
          JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
          browser = (String) jsonObject.get("BROWSER");
          options = (String) jsonObject.get("OPTIONS");
          URL = (String) jsonObject.get("URL");
          language = (String) jsonObject.get("LANG");
          wait = StringUtils.getInt((String) jsonObject.get("WAIT"));
      }
      catch (ParseException ignored){
      } catch (IOException e) {
          throw new RuntimeException(e);
      }
  }

    public static String getBrowser(){
        return browser;
    }
    public static String getOptions(){
        return options;
    }
    public static String getURL(){
        return URL;
    }
    public static String getLanguage(){
        return language;
    }
    public static int getWait(){
        return wait;
    }

}