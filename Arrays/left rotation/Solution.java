import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;

class Result {

    /*
     * Complete the 'rotateLeft' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER d
     *  2. INTEGER_ARRAY arr
     */

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        int n = arr.size(); 
        d = d % n; 
        List<Integer> rotatedArray = new ArrayList<>();
        
        // Create rotated array
        for (int i = d; i < n; i++) {
            rotatedArray.add(arr.get(i));
        }
        for (int i = 0; i < d; i++) {
            rotatedArray.add(arr.get(i));
        }

        return rotatedArray; 
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // Read input values
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);
        int d = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        List<Integer> result = Result.rotateLeft(d, arr);

        // Output the result to the console
        System.out.println(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
        );

        bufferedReader.close();
    }
}
