import java.util.*;

public class P92334_K {
    class Solution {
        public int[] solution(String[] id_list, String[] report, int k) {
            int len = id_list.length;

            int[] answer = new int[len];

            boolean[][] history = new boolean[len][len];

            HashMap<String, Integer> idMap = new HashMap<>();

            for(int i = 0; i < len; i++){
                idMap.put(id_list[i], i);
            }

            for(String s : report){
                String[] reportList = s.split(" ");

                history[idMap.getOrDefault(reportList[0], -1)][idMap.getOrDefault(reportList[1], -1)] = true;

            }

            for(int i = 0; i < len; i++){
                for(int j = 0; j < len; j++){
                    if(history[i][j]){
                        answer[j]++;
                    }
                }
            }

            int[] result = new int[len];

            for(int i = 0; i < len; i++){
                if(answer[i] >= k){
                    for(int j = 0; j < len; j++){
                        if(history[j][i])
                            result[j]++;
                    }
                }
            }

            return result;
        }
    }
}
