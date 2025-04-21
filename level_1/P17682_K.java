import java.util.*;
public class P17682_K {
    class Solution {
        public int solution(String dartResult) {
            int answer = 0;
            ArrayList<Integer> nums = new ArrayList<>();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < dartResult.length(); i++) {
                char c = dartResult.charAt(i);
                if (Character.isDigit(c)) {
                    sb.append(c);
                } else {
                    if (sb.length() > 0) {
                        nums.add(Integer.parseInt(sb.toString()));
                        sb.setLength(0);
                    }

                    int idx = nums.size() - 1;

                    if (c == 'D') {
                        nums.set(idx, (int) Math.pow(nums.get(idx), 2));
                    } else if (c == 'T') {
                        nums.set(idx, (int) Math.pow(nums.get(idx), 3));
                    } else if (c == '*') {
                        nums.set(idx, nums.get(idx) * 2);
                        if (idx > 0) {
                            nums.set(idx - 1, nums.get(idx - 1) * 2);
                        }
                    } else if (c == '#') {
                        nums.set(idx, nums.get(idx) * -1);
                    }
                }
            }

            for (int n : nums) {
                answer += n;
            }

            return answer;
        }
    }
}
