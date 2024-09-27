import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

public class SpinWords {

    public String spinWords(String sentence) {
        List<String> updatedStringsList = Arrays.stream(sentence.split(" ")).map(x -> {
            if (x.length() >= 5) {
                String[] chars = x.split("");
                StringBuilder sb = new StringBuilder();
                for (int i = chars.length - 1; i >= 0; i--) {
                    sb.append(chars[i]);
                }
                return sb.toString();
            } else {
                return x;
            }
        }).collect(toList());
        return String.join(" ", updatedStringsList);

    }
}