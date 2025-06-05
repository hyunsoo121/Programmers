public class P12904_W 
{
    class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        char[] c=s.toCharArray();
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            int len_odd=palindrome(c,n,i,i); //홀수 있떄
            int len_even=palindrome(c,n,i,i+1); //짝수일때
            answer=Math.max(answer,Math.max(len_even,len_odd));
        }
        return answer;
    }
    public int palindrome(char[] c,int n,int left,int right)
    {
        while(left>=0 && left<n && right<n && c[left]==c[right])
        {
            left--;
            right++;
        }
        return right-left-1;
    }
}
}
