import java.util.*;
public class P1845_W
{
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashMap<Integer,Integer> hm=new HashMap<>(); //key는 종류, value는 마리수
        for(int key : nums)
        {
            if(hm.containsKey(key))
            {
                int num=hm.get(key)+1;
                hm.put(key,num);
            }
            else
            {
                hm.put(key,1);
            }
        }
        int can_selector=nums.length/2; //선택할 수 있는 마리수
        int size=hm.keySet().size(); //key들의 개수
        if(can_selector <= size) // 포켓몬의 종류가 더 많은 경우
        {
            answer=can_selector;
            return answer;
        }
        //선택할 수 있는 포켓몬의 종류가 더 적은경우
        else
        {
            answer=size;
            return answer;
        }
    }
}
}