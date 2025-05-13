import java.util.*;
public class P258712_W {
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        HashMap<String,HashMap<String,Integer>> hm=new HashMap<>();
        int[] presents_cnt=new int[friends.length]; //선물 지수 저장
        int[] present=new int[friends.length]; //받은 선물 저장
        for(String f : friends)
        {
            hm.put(f,new HashMap<>());
        }
        for(int i=0;i<friends.length;i++)
        {
            hm.get(friends[i]).put(friends[i],0);
        }
        for(String g : gifts)
        {
            String[] input=g.split(" ");
            String f1=input[0]; String f2=input[1]; //누구에게 준건지
            hm.get(f1).put(f2,hm.get(f1).getOrDefault(f2,0)+1);
        }
        for(int i=0; i<friends.length;i++) // 선물 지수 계산
        {
            int total_cnt=0;
            for(int give : hm.get(friends[i]).values())
            {
                total_cnt+=give;
            }
            for(int j=0;j<friends.length;j++)
            {
                if(hm.get(friends[j]).containsKey(friends[i]))
                {
                    total_cnt-=hm.get(friends[j]).get(friends[i]);
                }
            }
            presents_cnt[i]=total_cnt;
        }
        for(int i=0;i<friends.length;i++)
        {
            for(int j=0;j<friends.length;j++)
            {
                if(i!=j)
                {
                    int give=hm.get(friends[i]).getOrDefault(friends[j],0);
                    int given=hm.get(friends[j]).getOrDefault(friends[i],0);
                    
                    if(give > given) //준게 받은거보다 많은 경우
                    {
                        present[i]++;
                    }
                    else if(given==give) //주고 받은 값이 같은 경우
                    {
                        if(presents_cnt[i] > presents_cnt[j])
                        {
                            present[i]++; //선물 지수가 더 큰 사람이 받음
                        }
                    }
                }
            }
        }
        for(int pre : present)
        {
            answer=Math.max(answer,pre);
        }
        return answer;
    }
}
//선물지수 : 준 선물 - 받은 선물
// 더 많이 준애가 하나 받음
// 받은 수가 같으면 선물 지수가 더 큰 사람이 더 작은사람에게 받음
// 선물 지수도 같으면 서로 주고 받지 않음
    
}
