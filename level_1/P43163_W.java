public class P43163_W {
    class Solution {
        int min=Integer.MAX_VALUE;
        boolean[] visited;
    public int solution(String begin, String target, String[] words) {
        boolean check=false; //target이 존재하는지 확인
        visited=new boolean[words.length];
        for(int i=0;i<words.length;i++)
        {
            if(words[i].equals(target))
            {
                check=true;
                break;
            }
        }
        if(!check) return 0; //target이 존재하지 않으면 0 return 하고 종료
        dfs(begin,target,words,0);
        return min == Integer.MAX_VALUE ? 0 : min;
    }
    public void dfs(String begin,String target,String[] words,int cnt)
    {
        if(begin.equals(target))
        {
            min=Math.min(min, cnt);
            return;
        }
        for(int i=0;i<words.length;i++)
        {
            if(!visited[i] && change(begin, words[i]))
            {
                visited[i]=true;
                dfs(words[i], target, words, cnt+1);
                visited[i]=false;
            }
        }
    }
    public boolean change(String s1,String s2)
    {
        int diff=0;
        for(int i=0;i<s1.length();i++)
        {
            if(s1.charAt(i)!=s2.charAt(i))
            {
                diff++;
            }
        }
        if(diff==1)
        {
            return true;
        }
        return false;
    }
}
}
