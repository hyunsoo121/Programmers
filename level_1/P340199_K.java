import java.util.*;
public class P340199_K {
    class Solution {
        public int solution(int[] wallet, int[] bill) {
            int answer = 0;
            Arrays.sort(wallet);
            Arrays.sort(bill);
            for(; wallet[0] < bill[0] || wallet[1] < bill[1]; Arrays.sort(bill)){

                if(bill[0] > bill[1]){
                    bill[0] /= 2;
                }
                else{
                    bill[1] /= 2;
                }

                answer++;

            }
            return answer;
        }
    }
}
