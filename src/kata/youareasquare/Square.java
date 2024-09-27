package kata.youareasquare;

public class Square {

    public static boolean isSquare(int n) {
        if(n < 0) {
            return false;
        }
        return n == Math.pow((int) Math.sqrt(n), 2);

    }
}
