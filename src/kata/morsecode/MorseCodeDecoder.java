package kata.morsecode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

public class MorseCodeDecoder {

    public static final String WORD_SPLITTER = "   ";
    public static final String LETTER_SPLITTER = " ";

    public static String decodeMorse(String morseCode) {
        return Arrays.stream(morseCode.split(WORD_SPLITTER))
                .map(word->Arrays.stream(word.split(LETTER_SPLITTER))
                        .map(MorseCode::get).filter(Objects::nonNull)
                    .collect(joining()))
                .collect(joining(" ")).trim();
    }

    public static String decodeBits(String bits) {
        int timeUnit = analyseTimeUnit(bits);
        bits = stripZeroPaddings(bits);
        java.util.Map<String, String> bitsToCodeMap = buildBitsToCodeMap(timeUnit);
        String charSeparator = IntStream.iterate(0, value -> 0)
                .mapToObj(String::valueOf).limit(3L * timeUnit).reduce((a, b)-> a+b).get();
        String wordSeparator = IntStream.iterate(0, value -> 0)
                .mapToObj(String::valueOf).limit(7L * timeUnit).reduce((a, b)-> a+b).get();

        String[] bitWords = bits.split(wordSeparator);
        return Arrays.stream(bitWords).map(bitWord -> Arrays.stream(bitWord.split(charSeparator)).peek(System.out::println).map(bitsToCodeMap::get).collect(joining(" ")))
                .collect(joining("   "));

    }

    private static Map<String, String> buildBitsToCodeMap(int timeUnit) {
        Map<String, String> bitsToCodeMap = new HashMap<>();
        String dot = IntStream.iterate(1, value -> 1)
                .mapToObj(String::valueOf).limit(timeUnit).reduce((a, b)-> a+b).get();
        String dash = IntStream.iterate(1, value -> 1)
                .mapToObj(String::valueOf).limit(3*timeUnit).reduce((a, b)-> a+b).get();
        String dotDashDelimiter = IntStream.iterate(0, value ->0)
                .mapToObj(String::valueOf).limit(timeUnit).reduce((a, b)-> a+b).get();
        CODES.forEach((key, value) -> bitsToCodeMap.put(
                String.join(dotDashDelimiter, key.split(""))
                                .replaceAll("\\.", dot).replaceAll("\\-", dash),
                key));
        return bitsToCodeMap;
    }

    public static String stripZeroPaddings(String bits) {
        if (!bits.contains("1")) {
            return "";
        }
        return bits.substring(bits.indexOf("1"), 1+bits.lastIndexOf("1"));
    }

    public static int analyseTimeUnit(String bits) {
        int timeUnit = 1;
        String timeUnitChecker1 = "010";
        String timeUnitChecker2 = "101";

        while (!bits.contains(timeUnitChecker1) && !bits.contains(timeUnitChecker2)) {
            ++timeUnit;
            timeUnitChecker1 = timeUnitChecker1.replaceFirst("0", "01");
            timeUnitChecker2 = timeUnitChecker2.replaceFirst("1", "10");
        }
        if (timeUnit %3 ==0) {
            int indx10 = stripZeroPaddings(bits).indexOf("10");
            if (indx10 !=-1 && indx10 < timeUnit) {
                timeUnit = 1+indx10;
            }
        }

        return timeUnit;
    }

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

}
