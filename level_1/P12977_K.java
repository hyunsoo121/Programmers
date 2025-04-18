import java.util.*;
public class P12977_K {
    class Solution {
        public int solution(int[] nums) {
            List<Integer> sum = new ArrayList<>();

            for(int i = 0; i < nums.length - 2; i++) {
                for(int j = i + 1; j < nums.length - 1; j++) {
                    for(int k = j + 1; k < nums.length; k++) {
                        sum.add(nums[i] + nums[j] + nums[k]);
                    }
                }
            }

            int max = Collections.max(sum);
            boolean[] isNotPrime = new boolean[max + 1];

            for (int i = 2; i * i <= max; i++) {
                if (!isNotPrime[i]) {
                    for (int j = i * i; j <= max; j += i) {
                        isNotPrime[j] = true;
                    }
                }
            }

            int count = 0;
            for (int num : sum) {
                if (num > 1 && !isNotPrime[num]) {
                    count++;
                }
            }

            return count;
        }
    }
}
