import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task4 {
    public static void main(String[] args) {
        String fileName = args[0];
        List<Integer> nums = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(" ");
                for (String value : values) {
                    nums.add(Integer.parseInt(value));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int minMoves = Integer.MAX_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            int number = nums.get(i);
            int moves = 0;
            for (int num : nums) {
                if (number == num) {
                    continue;
                }
                moves += Math.abs(num - number);
            }
            minMoves = Math.min(minMoves, moves);
        }
        System.out.println(minMoves);
    }
}