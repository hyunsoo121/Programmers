

import java.util.*;

public class P132267_K {
    class Solution {
        public int solution(int a, int b, int n) {
            int answer = 0;
            int d = n;
            while (d >= a){
                int takeBottle = (d / a) * b;;
                d %= a;
                answer += takeBottle;
                d += takeBottle;
            }
            return answer;
        }
    }
}