import java.util.*;
public class P178871_W {
class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String,Integer> hm=new HashMap<>();
        for(int i=0;i<players.length;i++)
        {
            hm.put(players[i],i);
        }
        for(String key : callings)
        {
            int cur_rank=hm.get(key); //현재 불린 선수의 순위
            String loser=players[cur_rank-1]; //역전 당한 선수
            players[cur_rank-1]=key;
            players[cur_rank]=loser;
            
            hm.put(key,cur_rank-1);
            hm.put(loser,cur_rank);
        }
        String[] answer = new String[players.length];
        for(int i=0;i<players.length;i++)
        {
            answer[i]=players[i];
        }
        return answer;
    }
}
    
}
