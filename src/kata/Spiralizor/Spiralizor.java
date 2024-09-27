package kata.Spiralizor;

import java.util.Arrays;
import java.util.Map;

public class Spiralizor {

    static Map<DIRECTION, DIRECTION> flow = Map.of(
            DIRECTION.FORWARD, DIRECTION.DOWN,
            DIRECTION.DOWN, DIRECTION.BACKWARD,
            DIRECTION.BACKWARD, DIRECTION.UP,
            DIRECTION.UP, DIRECTION.FORWARD);

    Node lowerBoundaryNode;
    Node upperBoundaryNode;
    int count = 0;
    Node currentNode = new Node(0,0);

    public static int[][] spiralize(int size) {
        Spiralizor spiralizor = new Spiralizor();
        int xMax = size-1, yMax = size-1;
        int[][] input = new int[size][size];
        spiralizor.lowerBoundaryNode = new Node(0,0);
        spiralizor.upperBoundaryNode = new Node(xMax,yMax);
        spiralizor.moveAndMark(input, DIRECTION.FORWARD);
        print(input);
        return input;
    }

    private static void print(int[][] input) {
        for (int[] ints : input) {
            Arrays.stream(ints).forEach(System.out::print);
            System.out.println();
        }
    }

    private void moveAndMark(int[][] input, DIRECTION direction) {
        switch (direction) {
            case FORWARD -> {
                for (int j = currentNode.y(); j <= upperBoundaryNode.y(); j++) {
                    input[currentNode.x()][j] = 1;
                }
                currentNode = new Node(currentNode.x(), upperBoundaryNode.y());
            }
            case BACKWARD -> {
                for (int j = currentNode.y(); j >= lowerBoundaryNode.x(); j--) {
                    input[currentNode.x()][j] = 1;
                }
                currentNode = new Node(currentNode.x(), lowerBoundaryNode.y());
            }
            case UP -> {
                for (int i = currentNode.x(); i >= lowerBoundaryNode.x(); i--) {
                    input[i][currentNode.y()] = 1;
                }
                currentNode = new Node(lowerBoundaryNode.x(), currentNode.y());
            }
            case DOWN -> {
                for (int i = currentNode.x(); i <= upperBoundaryNode.x(); i++) {
                    input[i][currentNode.y()] = 1;
                }
                currentNode = new Node(upperBoundaryNode.x(), currentNode.y());

            }
        }
        direction = flow.get(direction);


        if (++count < 4) {
            if (count == 3) {
                lowerBoundaryNode = new Node(lowerBoundaryNode.x()+2, lowerBoundaryNode.y()+2 );
                upperBoundaryNode = new Node(upperBoundaryNode.x()-2, upperBoundaryNode.y()-2 );
            }
            this.moveAndMark(input, direction);
        } else {
            if(lowerBoundaryNode.x() <= upperBoundaryNode.x()) {
                count = 0;
                currentNode = new Node(lowerBoundaryNode.x(), lowerBoundaryNode.y());
                input[currentNode.x()][currentNode.y()-1] = 1;
                if(upperBoundaryNode.x()- lowerBoundaryNode.x() ==1) {
                    //reached 2 x 2
                    input[currentNode.x()][currentNode.y()] = 1;
                    input[currentNode.x()][currentNode.y()+1] = 1;
                    input[currentNode.x()+1][currentNode.y()+1] = 1;
                    return;
                }

                this.moveAndMark(input, direction);
            }
        }
    }

    enum DIRECTION {
        FORWARD ,
        DOWN,
        BACKWARD,
        UP
    }

    record Node(int x, int y){}

}
