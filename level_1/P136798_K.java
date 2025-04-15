import java.util.*;

public class P136798_K {
    class Solution {
        public int solution(int number, int limit, int power) {
            int answer = 1;

            for(int i = 2; i <= number; i++){
                int atk = divisor(i);

                if(atk > limit)
                    atk = power;

                answer += atk;
            }

            return answer;
        }

        public int divisor(int num){
            Set<Integer> list = new HashSet<>();

            if(num == 2 || num == 3)
                return 2;

            for(int i = 1; i <= num / Math.sqrt(num); i++){
                if(num % i == 0){
                    list.add(i);
                    list.add(num / i);
                }

            }

            return list.size();
        }
    }
}
