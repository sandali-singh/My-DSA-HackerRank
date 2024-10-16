import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;

class Result {

    /*
     * Complete the 'dynamicArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        List<List<Integer>> seqList = new ArrayList<>(n);
        List<Integer> result = new ArrayList<>();
        int lastAnswer = 0;

        // Initialize the seqList with n empty lists
        for (int i = 0; i < n; i++) {
            seqList.add(new ArrayList<>());
        }

        // Process each query
        for (List<Integer> query : queries) {
            int queryType = query.get(0);
            int x = query.get(1);
            int y = query.get(2);
            
            int idx = (x ^ lastAnswer) % n;

            if (queryType == 1) {
                // Append y to the sequence at seqList[idx]
                seqList.get(idx).add(y);
            } else if (queryType == 2) {
                // Find the value of lastAnswer
                List<Integer> seq = seqList.get(idx);
                lastAnswer = seq.get(y % seq.size());
                result.add(lastAnswer);
            }
        }

        return result;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // Read input values
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);
        int q = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Result.dynamicArray(n, queries);

        // Output the result to the console
        System.out.println(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
        );

        bufferedReader.close();
    }
}
