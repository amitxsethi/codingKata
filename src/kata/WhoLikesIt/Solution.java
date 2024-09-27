package kata.WhoLikesIt;

public class Solution {

    public static final String TEMPLATE_0 = "no one likes this";
    public static final String TEMPLATE_1 = "%s likes this";
    public static final String TEMPLATE_2 = "%s and %s like this";
    public static final String TEMPLATE_3 = "%s, %s and %s like this";
    public static final String TEMPLATE_MORE_THAN_3 = "%s, %s and %s others like this";

    public static String whoLikesIt(String... names) {
        final int length = names.length;
        return switch (length) {
            case 0 -> TEMPLATE_0;
            case 1 -> TEMPLATE_1.formatted(names[0]);
            case 2 -> TEMPLATE_2.formatted(names[0], names[1]);
            case 3 -> TEMPLATE_3.formatted(names[0], names[1], names[2]);
            default -> TEMPLATE_MORE_THAN_3.formatted(names[0], names[1], length - 2);
        };
    }
}
