package level2;

import java.util.Stack;

public class CraneGame {

    public static int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();

        for (int j = 0; j < moves.length; j++) {
            int mm = moves[j] - 1;
            for (int i = 0; i < board.length; i++) {
                int[] bb = board[i];
                if (bb[mm] == 0) {
                    continue;
                } else {
                    stack.push(bb[mm]);
                    bb[mm] = 0;
                    break;
                }
            }
        }

        Stack<Integer> result = new Stack<>();
        int answer = 0;
        if (stack.size() == 0) {
            return 0;
        }

        int before = stack.pop();
        int size = stack.size();
        result.push(before);

        for (int i = 0; i < size; i++) {
            Integer boom = stack.pop();
            if (before == boom) {
                answer++;
                result.pop();
                if (i != size-1) {
                    before = result.peek();
                }
            } else {
                before = boom;
                result.push(boom);
            }
        }

        return answer * 2;
    }


    public static void main(String[] args) {

        int[][] ints =
                {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};

        int[] ints1 = {1, 5, 3, 5, 1, 2, 1, 4};
        solution(ints, ints1);
    }
}
