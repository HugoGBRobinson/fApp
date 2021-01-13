import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class fApp {

    protected static int puzzleSize = 4;

    public static void main(String[] args){

        String[] puzzle = new puzzleGenerator().puzzleGen();

        int count = 0;
        for (int i = 0; i < puzzleSize; i++) {
            for (int j = 0; j < puzzleSize + (puzzleSize - 1); j++) {
                System.out.print(puzzle[count] + " ");
                count+=1;
            }
            System.out.println();
            for (int j = 0; j < puzzleSize; j++) {
                System.out.print(puzzle[count]+ " ");
                count+=1;
            }
            System.out.println();
        }
    }
}

