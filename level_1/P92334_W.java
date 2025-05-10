import java.util.*;
public class P92334_W {
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String,ArrayList<String>> hm=new HashMap<>();
        HashMap<String,Integer> count=new HashMap<>(); //신고당한 횟수 저장
        int[] answer=new int[id_list.length];
        for(String name : id_list)
        {
            hm.put(name,new ArrayList<>());
        }
        for(int i=0;i<report.length;i++)
        {
            String[] input=report[i].split(" ");
            String call=input[0]; //신고한 사람
            String called=input[1]; //신고당한 사람
            if(!hm.get(call).contains(called)) //첫번째 신고인 경우
            {
                hm.get(call).add(called);
                count.put(called,count.getOrDefault(called,0)+1);
            }
        }
        for(int i=0;i<id_list.length;i++)
        {
            for(String call : count.keySet())
            {
                if(count.get(call)>=k && hm.get(id_list[i]).contains(call))
                {
                    answer[i]++;
                }
            }
        }
        return answer;
    }
}
}
