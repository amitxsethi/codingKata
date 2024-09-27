package kata.morsecode;

import java.util.HashMap;
import java.util.Map;

public class MorseCode {
        final static Map<String, String> CODES = new HashMap<>();

        static {
            CODES.put(".-", "A");
            CODES.put("-...", "B");
            CODES.put("-.-.", "C");
            CODES.put("-..", "D");
            CODES.put(".", "E");
            CODES.put("..-.", "F");
            CODES.put("--.", "G");
            CODES.put("....", "H");
            CODES.put("..", "I");
            CODES.put(".---", "J");
            CODES.put("-.-", "K");
            CODES.put(".-..", "L");
            CODES.put("--", "M");
            CODES.put("-.", "N");
            CODES.put("---", "O");
            CODES.put(".--.", "P");
            CODES.put("--.-", "Q");
            CODES.put(".-.", "R");
            CODES.put("...", "S");
            CODES.put("-", "T");
            CODES.put("..-", "U");
            CODES.put("...-", "V");
            CODES.put(".--", "W");
            CODES.put("-..-", "X");
            CODES.put("-.--", "Y");
            CODES.put("--..", "Z");
            CODES.put("-----", "0");
            CODES.put(".----", "1");
            CODES.put("..---", "2");
            CODES.put("...--", "3");
            CODES.put("....-", "4");
            CODES.put(".....", "5");
            CODES.put("-....", "6");
            CODES.put("--...", "7");
            CODES.put("---..", "8");
            CODES.put("----.", "9");
            CODES.put(".-.-.-", ".");
        }


    public static String get(String code) {
            return CODES.get(code);
    }
}
