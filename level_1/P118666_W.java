import java.util.*;
public class P118666_W {
    class Solution {
        public String solution(String[] survey, int[] choices) {
            StringBuilder sb=new StringBuilder();
            HashMap<Character,Integer> hm=new HashMap<>();
            for(int i=0;i<survey.length;i++)
            {
                String in=survey[i];
                char c1=in.charAt(0); char c2=in.charAt(1);
                int score=choices[i];
                if(score>=1 && score<=3){
                 hm.put(c1,hm.getOrDefault(c1,0)+4-score);
                    System.out.println(c1+" : "+hm.get(c1));
                }
                else if(score>=5 && score<=7){
                    hm.put(c2,hm.getOrDefault(c2,0)+score-4);
                    System.out.println(c2+" : "+hm.get(c2));
                }
                System.out.println("---");
            }
            if(hm.getOrDefault('R',0) > hm.getOrDefault('T',0) || 
              hm.getOrDefault('R',0) == hm.getOrDefault('T',0)) sb.append("R");
            else sb.append("T");
            
            if(hm.getOrDefault('C',0) > hm.getOrDefault('F',0) || 
              hm.getOrDefault('C',0) == hm.getOrDefault('F',0)) sb.append("C");
            else sb.append("F");
            
            if(hm.getOrDefault('J',0) > hm.getOrDefault('M',0) || 
              hm.getOrDefault('J',0) == hm.getOrDefault('M',0)) sb.append("J");
            else sb.append("M");
            
            if(hm.getOrDefault('A',0) > hm.getOrDefault('N',0) || 
              hm.getOrDefault('A',0) == hm.getOrDefault('N',0)) sb.append("A");
            else sb.append("N");
            
            return sb.toString();
        }
    }
    //성격 유형 점수가 같으면 사전 순으로 판단
    //첫번째 요소는 비동의 관련, 두번째 요소는 동의 관련
    // R-T , C-F , J-M, A-N
//성격 유형 점수가 같으면 사전 순으로 판단
//첫번째 요소는 비동의 관련, 두번째 요소는 동의 관련
// R-T , C-F , J-M, A-N
}
