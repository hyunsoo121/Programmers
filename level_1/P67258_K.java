
import java.util.*;

public class P67258_K {
//    class Solution {
//        public int[] solution(String[] gems) {
//
//            int start = 0, end = 0;
//            HashSet<String> gemSet = new HashSet<>();
//
//            for(String s : gems){
//                gemSet.add(s);
//            }
//
//            for(int i = gemSet.size(); i <= gems.length; i++){
//                HashSet<String> buyGem = new HashSet<>();
//                for(int j = 0; j <= gems.length - i; j++){
//                    for(int k = j; k < j + i; k++){
//                        buyGem.add(gems[k]);
//                    }
//
//                    if(buyGem.size() == gemSet.size()){
//                        start = j + 1;
//                        end = j + i;
//                        break;
//                    }
//
//                    buyGem.clear();
//                }
//                if(start != 0)
//                    break;
//            }
//            int[] answer = {start, end};
//            return answer;
//        }
//    }
    class Solution {
        public int[] solution(String[] gems) {
            HashSet<String> gemSet = new HashSet<>(Arrays.asList(gems));
            HashMap<String, Integer> gemMap = new HashMap<>();

            int start = 0, end = 0, left = 0;
            int minLen = Integer.MAX_VALUE;

            for (int right = 0; right < gems.length; right++) {
                gemMap.put(gems[right], gemMap.getOrDefault(gems[right], 0) + 1);

                while (gemMap.size() == gemSet.size()) {
                    if (right - left < minLen) {
                        minLen = right - left;
                        start = left + 1;
                        end = right + 1;
                    }

                    gemMap.put(gems[left], gemMap.get(gems[left]) - 1);
                    if (gemMap.get(gems[left]) == 0) {
                        gemMap.remove(gems[left]);
                    }
                    left++;
                }
            }

            int[] answer = {start, end};

            return answer;
        }
    }
}
