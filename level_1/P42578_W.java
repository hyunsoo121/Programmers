import java.util.*;
public class P42578_W {
    class Solution {
    public int solution(String[][] clothes) {
        HashMap<String,ArrayList<String>> hm=new HashMap<>();
        for(String[] c : clothes)
        {
            if(hm.getOrDefault(c[1],null)==null)
            {
                hm.put(c[1], new ArrayList<>());
            }
            hm.get(c[1]).add(c[0]);
        }
        int total=1;
        for(String s : hm.keySet())
        {
            int k=hm.get(s).size()+1;
            total*=k;
        }        
        return total-1;
    }
}
}
