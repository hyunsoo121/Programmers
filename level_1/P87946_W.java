public class P87946_W 
{
    class Solution 
    {
        static int n;
        static int answer = -1;
        static boolean[] visited;
    public static int solution(int k, int[][] dungeons) {
        n=dungeons.length; //던전의 개수를 저장
        visited=new boolean[n];
        dfs(k,dungeons,0);
        return answer;
    }
    public static void dfs(int k,int[][] dungeons,int count)
    {
        answer=Math.max(answer,count);
        for(int i=0;i<n;i++)
        {
            if(!visited[i] && k>=dungeons[i][0])
            {
                visited[i]=true;
                dfs(k-dungeons[i][1],dungeons,count+1);
                visited[i]=false;
            }
        }
    }
}
}
