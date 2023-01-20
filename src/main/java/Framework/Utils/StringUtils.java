package Framework.Utils;

import Framework.Constants;

public class StringUtils {
    public static int getInt(String string){
        return Integer.parseInt(string);
    }
    public static String getRandomString(int n){
        String AlphaNumericString = Constants.LETTERS_LOWER_CASE + Constants.NUMBERS + Constants.LETTERS_UPPER_CASE;
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int index = (int)(AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }
    public static String getString(Integer num){
        return num.toString();
    }
}
