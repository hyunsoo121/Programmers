public class P159994_K {
    class Solution {
        public String solution(String[] cards1, String[] cards2, String[] goal) {
            String answer = "Yes";

            for (int i = 0, j = 0, k = 0; k < goal.length; k++){
                if(i < cards1.length && goal[k].equals(cards1[i])){
                    i++;
                }

                else if(j < cards2.length && goal[k].equals(cards2[j])){
                    j++;
                }

                else{
                    answer = "No";
                    break;
                }
            }

            return answer;
        }
    }
}
