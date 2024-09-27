import java.util.Arrays;
import java.util.List;

public class VowelCount {

    public static int getCount(String str) {
        return (int)str.chars().filter(c-> "aeiou".indexOf(c)>=0).count();
    }

}
