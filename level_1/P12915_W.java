import java.util.*;
public class P12915_W {
    class Solution 
    {
        public String[] solution(String[] strings, int n) 
        {
            Arrays.sort(strings,new mycomparator(n));
            String[] answer = strings;
            return answer;
        }
    }
    class mycomparator implements Comparator<String>
    {
        private int n;
        public mycomparator(int n){
            this.n=n;
        }
        
        public int compare(String s1,String s2)
        {
            if(s1.charAt(n)==s2.charAt(n))
            {
                return s1.compareTo(s2);
            }
            else
            {
                return Character.compare(s1.charAt(n),s2.charAt(n));
            }
        }
    }
    
}