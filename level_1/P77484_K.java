import java.util.*;
public class P77484_K {
    class Solution {
        public int[] solution(int[] lottos, int[] win_nums) {
            int[] answer = {7, 7};

            ArrayList<Integer> nums = new ArrayList<>();

            for(int i : win_nums){
                nums.add(i);
            }

            for(int i : lottos){
                if(i == 0)
                    answer[0]--;
                else
                if(nums.contains(i))
                    answer[1]--;
            }

            answer[0] -= 7 - answer[1];

            if(answer[1] == 7)
                answer[1] = 6;
            if(answer[0] == 7)
                answer[0] = 6;

            return answer;
        }
    }
}
