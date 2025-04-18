public class P12921_W {
    class Solution {
        public int solution(int n) {
            int answer = 0;
            boolean[] isPrime=new boolean[n+1]; //처음은 다 false처리
            for(int i=2;i<=n;i++)
            {
                for(int j=i*2;j<=n;j+=i)
                {
                    isPrime[j]=true;
                }
            }
            for(int i=2;i<=n;i++)
            {
                if(!isPrime[i]) answer++;
            }
            return answer;
        }
    }
    
}
