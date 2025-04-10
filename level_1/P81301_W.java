import java.util.ArrayList;
import java.util.HashMap;

public class P81301_W 
{
class Solution {
    public int solution(String s) {
        int size=s.length();
        HashMap<String,Integer> hm=new HashMap<>();
        ArrayList<Integer> al=new ArrayList<>();
        hm.put("zero",0);
        hm.put("one",1); hm.put("two",2); hm.put("three",3);
        hm.put("four",4); hm.put("five",5); hm.put("six",6);
        hm.put("seven",7); hm.put("eight",8); hm.put("nine",9);
        char[] c=s.toCharArray();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<size;i++)
        {
            char key=c[i];
            if(hm.containsValue(key-'0')) //숫자인 경우
            {
                int num=key-'0';
                al.add(num); //al에 저장
            }
            else
            {
                sb.append(key);
                if(hm.containsKey(sb.toString()))
                {
                    al.add(hm.get(sb.toString()));
                    sb.setLength(0);
                }
            }
        }
        int answer=0;
        for(int num : al)
        {
            answer=answer*10 + num;
        }
        return answer;
}
    }
}