import java.util.*;
public class P176963_W{
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        HashMap<String,Integer> hm=new HashMap<>();
        for(int i=0;i<name.length;i++)
        {
            hm.put(name[i],yearning[i]);
        }
        int[] answer = new int[photo.length];
        int cnt=0;
        for(String[] s1 : photo)
        {
            int total=0;
            for(String s2 : s1)
            {
                total += hm.getOrDefault(s2, 0);
            }
            answer[cnt]=total;
            cnt++;
        }
        return answer;
    }
}

}