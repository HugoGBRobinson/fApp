import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class fApp {

    protected static int puzzleSize = 4;

    public static void main(String[] args){

        for (String str: new puzzleGenerator().puzzleGen()) {
            System.out.print(str + " ");
        }
    }
}

