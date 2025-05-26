import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class P72411_W {
    class Solution {
    public String[] solution(String[] orders, int[] course) {
        HashMap<String,Integer> hm=new HashMap<>();
        ArrayList<String> al=new ArrayList<>();
        int[] max_val=new int[course.length]; //최댓값을 저장함
        for (String order : orders) 
        {
            char[] arr = order.toCharArray();
            Arrays.sort(arr);
            int n = arr.length;
            for (int i = 1; i < (1 << n); i++) 
            {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) 
            {
                if ((i & (1 << j)) != 0) sb.append(arr[j]);
            }
        // 길이가 course에 포함된 경우만 저장
                int len = sb.length();
                for (int c : course) 
                {
                    if (len == c) 
                    {
                        hm.put(sb.toString(), hm.getOrDefault(sb.toString(), 0) + 1);
                    }
                }
            }
        }
        for(int i=0;i<course.length;i++)
        {
            int len=course[i];
            for(String s : hm.keySet())
            {
                if(len==s.length())
                {
                    max_val[i]=Math.max(max_val[i],hm.get(s));
                }
            }
        }
        for(int i=0;i<course.length;i++)
        {
            int len=course[i];
            for(String s : hm.keySet())
            {
                if(len==s.length() && hm.get(s)==max_val[i] && max_val[i]>=2)
                {
                    al.add(s);
                }
            }
        }
        Collections.sort(al);
        String[] answer=new String[al.size()];
        for(int i=0;i<al.size();i++)
        {
            answer[i]=al.get(i);
        }
        return answer;
    }
}
}
