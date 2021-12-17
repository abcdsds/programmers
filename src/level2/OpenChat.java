package level2;

import java.util.*;

public class OpenChat {

    public static class User {
        private String id;
        private String name;


    }

    public static String[] solution(String[] record) {
        /**
         *  객체간 공유되므로 변경된다. 이 공유는 무엇으로 해야할까 ? map으로 간다
         *  flow는 어떻게 저장해야할까 list나 map queue등등
         */

        HashMap<String, String> b = new HashMap<>();

        for (String s : record) {
            String[] s1 = s.split(" ");
            if (s.startsWith("Enter")) {
                if (b.containsKey(s1[1])) {
                    b.put(s1[1], s1[2]);
                } else {
                    b.put(s1[1], s1[2]);
                }
            }

            if (s.startsWith("Change")) {
                b.replace(s1[1], s1[2]);
            }
        }

        return Arrays.stream(record)
                .map(r -> r.split(" "))
                .filter(rr -> !rr[0].equals("Change"))
                .map(rr -> {
                    String s = b.get(rr[1]);
                    if (rr[0].equals("Enter")) {
                        return s + "님이 들어왔습니다";
                    }

                    return s + "님이 나갔습니다.";
                })
                .peek(System.out::println)
                .toArray(String[]::new);
    }

    public static void main(String[] args) {

        solution(
                new String[]{
                        "Enter uid1234 Muzi",
                        "Enter uid4567 Prodo",
                        "Leave uid1234",
                        "Enter uid1234 Prodo",
                        "Change uid4567 Ryan",
                        "Leave uid1234",});
    }
}
