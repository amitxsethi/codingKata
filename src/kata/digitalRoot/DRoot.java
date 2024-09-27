package kata.digitalRoot;

import java.util.Arrays;

public class DRoot {
    public static int digital_root(int n) {
         int result = Arrays.stream(String.valueOf(n).split("")).map(Integer::valueOf).reduce(Integer::sum).get();
         if (result > 9) {
             return digital_root(result);
         }
         return result;
    }

}