
public class P134240_K {
    class Solution {
        public String solution(int[] food) {
            String answer = "";
            String reverseAnswer = "";

            for(int i = 1; i < food.length; i++){
                for(int j = 0; j < food[i] / 2; j++){
                    answer += i;
                    reverseAnswer = i + reverseAnswer;
                }
            }

            answer = answer + 0 + reverseAnswer;

            return answer;
        }
    }
}