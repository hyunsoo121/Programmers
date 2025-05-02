import java.util.*;

public class P118666_K {
    class Solution {
        public String solution(String[] survey, int[] choices) {
            StringBuilder answer = new StringBuilder();
            String[] arr = {"RT", "CF", "JM", "AN"};
            HashMap<String, Integer> map = new HashMap<>();

            for(int i = 0; i < 4; i++){
                map.put(arr[i], 0);
            }

            int index = 0;

            for(String s : survey){
                if(!s.equals("RT") && !s.equals("CF") && !s.equals("JM") && !s.equals("AN")){
                    StringBuffer sb = new StringBuffer(s);
                    String key = sb.reverse().toString();
                    int score = 4 - choices[index++];
                    map.put(key, map.getOrDefault(key, 0) + score);
                }
                else{
                    int score = choices[index++] - 4;
                    map.put(s, map.getOrDefault(s, 0) + score);
                }
            }

            List<Integer> values = new ArrayList<>(map.values());

            for(int i = 0; i < 4; i++){
                if(values.get(i) <= 0){
                    answer.append(arr[i].charAt(0));
                }
                else{
                    answer.append(arr[i].charAt(1));
                }
            }
            return answer.toString();
        }
    }
}
