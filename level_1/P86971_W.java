import java.util.*;
public class P86971_W {
    class Solution {
    static HashMap<Integer,ArrayList<Integer>> hm=new HashMap<>();
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        for(int i=1;i<n+1;i++)
        {
            hm.put(i,new ArrayList<>());
        }
        for(int[] node : wires)
        {
            hm.get(node[0]).add(node[1]);
            hm.get(node[1]).add(node[0]);
        }
        for(int i=1;i<n+1;i++)
        {
            ArrayList<Integer> key=new ArrayList<>(hm.get(i));
            for(int k : key) //하나씩 끊으면서 그래프 탐색
            {
                answer=Math.min(answer,cut(i,k,n));
            }
        }
        return answer;
    }
    public int cut(int k1,int k2,int n) //k1는 끊는 곳,k2도 끊는 곳, n은 개수
    {
        boolean[] visited=new boolean[n+1];
        hm.get(k1).remove(Integer.valueOf(k2));
        hm.get(k2).remove(Integer.valueOf(k1));
        int absolute=0;
        for(int i=1;i<n+1;i++)
        {
            int cnt=0;
            if(!visited[i]) //방문되지 않은경우
            {
                Stack<Integer> stack=new Stack<>();
                stack.push(i);
                visited[i]=true;
                cnt=1;
                while(!stack.isEmpty())
                {
                    int node=stack.pop();
                    for(int temp : hm.get(node))
                    {
                        if(!visited[temp])
                        {
                            visited[temp]=true;
                            stack.push(temp);
                            cnt++;
                        }
                    }
                }
            }
            if(absolute==0) absolute+=cnt;
            else absolute-=cnt;
        }
        hm.get(k1).add(k2);
        hm.get(k2).add(k1); //원상복구
        return Math.abs(absolute);
    }
}
}
