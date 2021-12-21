package level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class FailRate {
    public static int[] solution(int N, int[] stages) {
        int total = stages.length;
        int[] ints = new int[N];
        Double[][] doubles = new Double[N][2];
        for (int i = 0; i < N; i++) {
            for (int stage : stages) {
                if (i+1 == stage) {
                    System.out.println("11");
                    ints[i] = ++ints[i];
                }
            }

            double v = (double) ints[i] / total;
            if (ints[i] == 0) {
                v = 0;
            }

            System.out.printf("Total: %s, Boom: %s, FailRate: %s \n", total, ints[i], v);
            total -= ints[i];
            doubles[i][0] = (double)i+1;
            doubles[i][1] = v;
        }

        return Arrays.stream(doubles)
                .sorted((o1, o2) -> o2[1].compareTo(o1[1]))
                .mapToInt(d -> d[0].intValue())
                .toArray();
    }

    public static void main(String[] args) {
//        int[] solution = solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
//        for (int i : solution) {
//            //System.out.println(i);
//        }
//
//        int[] solution2 = solution(3, new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3});
//        for (int i : solution2) {
//            //System.out.println(i);
//        }

        int[] solution4 = solution(4, new int[]{1, 2, 3, 2, 1});
        for (int i : solution4) {
            System.out.println(i);
        }
    }
}
