import java.util.*;

public class P138476_K {
    class Solution {
        public int solution(int k, int[] tangerine) {
            int answer = 0;

            HashMap<Integer, Integer> size = new HashMap<>();
            ArrayList<Integer> list = new ArrayList<>();

            for(int i : tangerine){

                if(size.getOrDefault(i, 0) == 0)
                    list.add(i);

                size.put(i, size.getOrDefault(i, 0) + 1);
            }

            Collections.sort(list, (a, b) -> {
                return Integer.compare(size.get(b), size.get(a));
            });

            for(int i : list){
                k -= size.get(i);
                answer++;

                if(k <= 0)
                    break;
            }

            return answer;
        }
    }
}
