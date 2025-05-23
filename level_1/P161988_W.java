public class P161988_W 
{
class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        int[] arr1=new int[sequence.length];
        int[] arr2=new int[sequence.length];
        for (int i = 0; i < sequence.length; i++) 
        {
            arr1[i]=sequence[i]*(i%2==0?1:-1);
            arr2[i]=sequence[i]*(i%2==0?-1:1);
        }
        answer=Math.max(dp(arr1),dp(arr2));
        return answer;
    }
    public long dp(int[] arr) 
    {
    long[] dp = new long[arr.length];
    dp[0] = arr[0];
    long max = dp[0];
    for (int i = 1; i < arr.length; i++) 
    {
        dp[i] = Math.max(arr[i],dp[i-1]+arr[i]);
        max = Math.max(max,dp[i]);
    }
    return max;
}
}    
}
