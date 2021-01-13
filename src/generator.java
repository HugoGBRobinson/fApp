import java.util.Queue;

public interface generator {

    public Queue<String> numGen();
    public Queue<String> opGen();
    public String[] puzzleGen();
    public int[][] combineLists();
}
