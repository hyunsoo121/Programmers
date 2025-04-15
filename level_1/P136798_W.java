public class P136798_W {
    class Solution {
        public int solution(int number, int limit, int power) 
        {
            int[] divisor = new int[number + 1]; // 각 정수의 약수 개수를 저장
    
            // 1부터 number까지 약수 개수 계산
            for (int i = 1; i <= number; i++) 
            {
                for (int j = i; j <= number; j += i) 
                {
                    divisor[j]++; // i는 j의 약수이므로 약수 개수 증가
                }
            }
    
            int answer = 0;
    
            // 약수가 limit을 초과하면 power만큼 더하고, 그렇지 않으면 약수 개수 더함
            for (int i = 1; i <= number; i++) {
                if (divisor[i] > limit) {
                    answer += power;
                } else {
                    answer += divisor[i];
                }
            }
    
            return answer;
        }
    }
    
    
}
