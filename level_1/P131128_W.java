import java.util.*;
public class P131128_W {

class Solution {
    public String solution(String X, String Y) {
        StringBuilder sb=new StringBuilder();
        char[] x1 = X.toCharArray();
        char[] y1 = Y.toCharArray();
        HashMap<Character, Integer> hmx = new HashMap<>();
        HashMap<Character, Integer> hmy = new HashMap<>();
        ArrayList<Character> al = new ArrayList<>();
        // x1 배열에 대해 HashMap에 값 추가
        for (int i = 0; i < x1.length; i++) {
            hmx.put(x1[i], hmx.getOrDefault(x1[i], 0) + 1);
        }
        // y1 배열에 대해 HashMap에 값 추가
        for (int i = 0; i < y1.length; i++) {
            hmy.put(y1[i], hmy.getOrDefault(y1[i], 0) + 1);
        }
        // 겹치는 문자를 찾아서 ArrayList에 추가
        for (int i = 0; i < x1.length; i++) 
        {
            char k = x1[i];
            if (hmy.containsKey(k) && hmy.get(k) > 0 && hmx.get(k) > 0) {
                al.add(k);
                hmx.put(k, hmx.get(k) - 1);
                hmy.put(k, hmy.get(k) - 1);
            }
        }
        
        // 내림차순으로 정렬
        Collections.sort(al, Collections.reverseOrder());
        
        // 겹치는 문자가 없으면 "-1" 반환
        if (al.isEmpty()) return "-1";
        
        // 문자들을 하나씩 합쳐서 answer에 저장
        for (char k : al) {
            sb.append(k);
        }
        
        // 만약 answer가 0으로만 이루어져 있다면 "0"을 반환
        if (sb.charAt(0) == '0') return "0";
        
        return sb.toString();
    }
}

    
}
