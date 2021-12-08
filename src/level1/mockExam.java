package level1;

import java.util.*;
import java.util.stream.Collectors;

public class mockExam {

    public static int[] solution(int[] answers) {
        Map<Integer, Integer> a = new HashMap<>();
        a.put(1, 0);
        a.put(2, 0);
        a.put(3, 0);

        int[] ints = {1, 2, 3, 4, 5};
        int[] ints1 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] ints2 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];
            if (answer == ints[i % 5]) {
                Integer integer = a.get(1);
                a.put(1, integer + 1);
            }

            if (answer == ints1[i % 8]) {
                Integer integer = a.get(2);
                a.put(2, integer + 1);
            }
            if (answer == ints2[i % 10]) {
                Integer integer = a.get(3);
                a.put(3, integer + 1);
            }
        }


        Map.Entry<Integer, Integer> integerIntegerEntry = a.entrySet()
                .stream()
                .max(
                        Comparator.comparing(
                                Map.Entry::getValue))
                .get();

        int[] answer = a.entrySet()
                .stream()
                .filter(
                        e -> integerIntegerEntry.getValue() == e.getValue())
                .mapToInt(mm -> mm.getKey())
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
