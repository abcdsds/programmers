package level1;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class mockExam {

    public static int[] solution(int[] answers) {
        int[] a = {0, 0, 0};
        int[] ints = {1, 2, 3, 4, 5};
        int[] ints1 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] ints2 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];
            if (answer == ints[i % 5]) {
                a[0] = a[0] + 1;
            }

            if (answer == ints1[i % 8]) {
                a[1] = a[1] + 1;
            }
            if (answer == ints2[i % 10]) {
                a[2] = a[2] + 1;
            }
        }

        int max = Arrays.stream(a)
                .max()
                .getAsInt();
        int[] answer = IntStream.range(0, a.length)
                .filter(i -> a[i] == max)
                .map(i -> i+1)
                .sorted()
                .toArray();

        return answer;
    }

    public static void main(String[] args) {
        //1,2,3,4,5
        //2,1,2,3,2,4,2,5
        //3,3,1,1,2,2,4,4,5,5

        solution(new int[]{1, 3, 2, 4, 2});


    }
}
