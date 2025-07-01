import java.util.*;

public class P42746_W {
    class Solution {
        public String solution(int[] numbers) {
            PriorityQueue<num> pq = new PriorityQueue<>((a, b) -> {
                String ab = a.str + b.str;
                String ba = b.str + a.str;
                return ba.compareTo(ab); // 큰 순서대로 정렬
            });

            for (int number : numbers) {
                pq.add(new num(number));
            }

            StringBuilder sb = new StringBuilder();
            while (!pq.isEmpty()) {
                sb.append(pq.poll().str);
            }

            // "0000" 같은 경우를 처리
            if (sb.charAt(0) == '0') return "0";

            return sb.toString();
        }

        class num {
            String str;

            num(int number) {
                this.str = String.valueOf(number);
            }
        }
    }
}
