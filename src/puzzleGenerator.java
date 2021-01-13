import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class puzzleGenerator implements generator{

        int puzzleSize = fApp.puzzleSize;

    @Override
    public Queue<String> numGen() {
        String[] nums = new String[(puzzleSize * puzzleSize)];
        int randPosition;
        String randNum;
        for (int i = 0; i < 3; i++) {
            randPosition = new Random().nextInt((puzzleSize * puzzleSize) - 1) + 1;
            randNum = Integer.toString (new Random().nextInt(puzzleSize - 1) + 1);
            if (nums[randPosition] == null){
                nums[randPosition] = randNum;
            }else{
                i = i - 1;
            }

        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == null){
                nums[i] = "0";
            }
        }

        Queue<String> numQueue = new LinkedList<>(Arrays.asList(nums));
        return numQueue;
    }

    @Override
    public Queue<String> opGen() {
        String[] ops = new String[((puzzleSize * puzzleSize) + (puzzleSize * (puzzleSize-1)- puzzleSize))];
        String[] avalibleOps = {"\u02C2","\u02C3","\u02C4","\u02C5"};
        int randPosition;
        for (int i = 0; i < 3; i++) {
            randPosition = new Random().nextInt((ops.length - 1) + 1);
            if (ops[randPosition] == null){
                ops[randPosition] = avalibleOps[new Random().nextInt(avalibleOps.length)];
            }else{
                i = i - 1;
            }

        }
        Queue<String> opsQueue = new LinkedList<>(Arrays.asList(ops));
        return opsQueue;

    }

    @Override
    public String[] puzzleGen() {
        Queue<String> numbers = numGen();
        Queue<String> operators = opGen();
        String[] puzzle = new String[numbers.size() + operators.size()];

        int puzzlePointer = 0;

        for (int i = 0; i < puzzleSize; i++) {
            for (int j = 0; j < puzzleSize + (puzzleSize - 1); j= j +2) {
                if (j != puzzleSize + 2){
                    puzzle[puzzlePointer] = numbers.remove();
                    puzzle[puzzlePointer + 1] = operators.remove();
                    puzzlePointer = puzzlePointer + 2;
                }else{
                    puzzle[puzzlePointer] = numbers.remove();
                    puzzlePointer = puzzlePointer + 1;
                }
            }
            System.out.println();
            if(operators.size() != 0){
                for (int j = 0; j < puzzleSize; j++) {
                    puzzle[puzzlePointer] = operators.remove();
                    puzzlePointer++;
                }
            }
        }
        return puzzle;
    }

    @Override
    public int[][] combineLists() {
        return new int[0][];
    }
}
