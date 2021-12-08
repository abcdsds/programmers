package level1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class marathon {

    public static void main(String[] args) {
        String[] a = {"mislav", "stanko", "mislav", "ana"};
        String[] b = {"stanko", "ana", "mislav"};

        solution(a, b);
    }

    public static String solution(String[] participant, String[] completion) {
        Map<String, Integer> a = new HashMap<>();
        for (String s : participant) {
            if (a.containsKey(s)) {
                Integer integer = a.get(s);
                a.replace(s, integer+1);
            } else {
                a.put(s, 0);
            }
        }

        for (String s : completion) {
            if (a.containsKey(s)) {
                Integer integer = a.get(s);
                a.replace(s, integer-1);
            }
        }

        String answer = "";
        for (String s : participant) {
            Integer integer = a.get(s);
            if (integer == 0) {
                answer = s;
            }
        }

        return answer;
    }

    public static class marathoner {
        private int no;
        private String name;
        private boolean complete;

        public marathoner(int no, String name) {
            this.no = no;
            this.name = name;
        }

        public void setComplete(boolean complete) {
            this.complete = complete;
        }

        public int getNo() {
            return no;
        }

        public String getName() {
            return name;
        }

        public boolean isComplete() {
            return complete;
        }
    }
}
