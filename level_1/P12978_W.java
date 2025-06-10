import java.util.*;
public class P12978_W {
    class Solution {
    public int solution(int N, int[][] road, int K) {
        HashMap<Integer,HashMap<Integer,ArrayList<Integer>>> hm = new HashMap<>();
        for(int i=1;i<N+1;i++)
        {
            hm.put(i,new HashMap<>());
        }
        for(int i=0;i<road.length;i++)
        {
            int[] temp=road[i];
            int place1=temp[0]; int place2=temp[1];
            int weight=temp[2];
            hm.get(place1).computeIfAbsent(place2,k->new ArrayList<>()).add(weight);
            hm.get(place2).computeIfAbsent(place1, k->new ArrayList<>()).add(weight);
        }
        int[] dist=new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1]=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>(Comparator.comparingInt(a->a[1]));
        pq.add(new int[] {1,0});
        while(!pq.isEmpty())
        {
            int[] temp=pq.poll();
            int place=temp[0]; int total_time=temp[1];
            if(total_time>dist[place]) continue;
            for(int candidate : hm.get(place).keySet())
            {
                for(int weight : hm.get(place).get(candidate))
                {
                    if(total_time+weight<dist[candidate])
                    {
                        dist[candidate]=total_time+weight;
                        pq.add(new int[] {candidate,dist[candidate]});
                    }
                }
            }
        }
        int cnt=0;
        for(int d:dist) if(d<=K) cnt++;
        return cnt;
    }
}
}
