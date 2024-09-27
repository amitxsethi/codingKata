package kata.greed_is_good;


import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Greed{

    final static Map<String, Integer> scoreMap;
    static {
        scoreMap = Map.of(
                "111", 1000,
                "666", 600,
                "555", 500,
                "444", 400,
                "333", 300,
                "200", 200,
                "11", 200,
                "55", 100,
                "1", 100,
                "5", 50
        );
    }


    public static int greedy(int[] dice){
        System.out.println(Arrays.toString(dice));
        //code here
        AtomicInteger score = new AtomicInteger();
        final String[] input = new String[1];
        input[0] =
                Arrays.stream(dice).sorted().mapToObj(String::valueOf).collect(Collectors.joining());
        scoreMap.entrySet().stream().sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue())).forEach(stringIntegerEntry ->
                {
                    boolean matched = input[0].contains(stringIntegerEntry.getKey());
                    if (matched) {
                        input[0] = input[0].replace(stringIntegerEntry.getKey(), "");
                        score.set(score.get() + stringIntegerEntry.getValue());
                    }
                }
        );

        return score.get();
    }
}