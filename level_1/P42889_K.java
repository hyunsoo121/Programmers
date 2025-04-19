import java.util.*;
public class P42889_K {
    class Solution {
        public int[] solution(int N, int[] stages) {
            List<Double> failureRateArr = new ArrayList<>();

            Arrays.sort(stages);
            for(int i = 1; i <= N; i++){
                int count = 0;
                int user = 0;
                for(int j : stages){
                    if(i <= j){
                        user++;
                    }
                    if(i == j){
                        count++;
                    }
                }
                double failureRate = (user == 0) ? 0.0 : (double) count / user;
                failureRateArr.add(failureRate);
            }

            int[] answer = new int[N];
            for(int i = 0; i < N; i++){
                int index = failureRateArr.indexOf(Collections.max(failureRateArr));
                failureRateArr.set(index, -1.0);
                answer[i] = index+1;
            }


            return answer;
        }
    }
}
