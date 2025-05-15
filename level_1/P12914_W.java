public class P12914_W {
    class Solution {
    public long solution(int n) {
        long[] dp=new long[n+1]; // 해당칸에 도달할 수 있는 경우의 수
        dp[0]=1; dp[1]=1;
        if(n==1)
        {
            return 1;
        }
        for(int i=2;i<=n;i++)
        {
            dp[i]=(dp[i-1]+dp[i-2])%1234567;
        }
        return dp[n];
    }
}
}
//한칸 또는 두칸만 가능능
