public class P131128_W 
{

    class Solution {
        public String solution(String X, String Y) 
        {
            StringBuilder sb = new StringBuilder();
            int[] x1 = new int[10];  // X 문자열에서 각 숫자의 개수를 저장
            int[] y1 = new int[10];  // Y 문자열에서 각 숫자의 개수를 저장
            // X와 Y의 각 문자의 빈도수를 계산
            for (char ch : X.toCharArray()) 
            {
                x1[ch - '0']++;
            }
            for (char ch : Y.toCharArray()) 
            {
                y1[ch - '0']++;
            }
    
            // 겹치는 숫자를 구해서 answer에 저장
            for (int i = 9; i >= 0; i--) 
            {
                int cnt = Math.min(x1[i], y1[i]);  // 겹치는 숫자의 개수
                for (int j = 0; j < cnt; j++) 
                {
                    sb.append(i);
                }
            }
            if (sb.length() == 0) 
            {
                return "-1";
            }
            if (sb.charAt(0) == '0') 
            {
                return "0";
            }
            return sb.toString();
        }
    }
        
}
