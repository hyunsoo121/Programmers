public class P12921_K {
    class Solution {
        public int solution(int n) {
            int answer = 0;

            int[] arr = new int[n+1];

            for(int i = 2; i <= n / 2; i++){
                for(int j = 2; i * j <= n; j++){
                    arr[i*j] = 1;
                }
            }

            for(int i : arr){
                if(i == 0)
                    answer++;
            }
            return answer - 2; // 0,1 제거
        }
    }
}
