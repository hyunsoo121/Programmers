public class P133499_W {
    class Solution {
        public int solution(String[] babbling) {
            int answer = 0;
            String[] can_speak = new String[] {"aya", "ye", "woo", "ma"};
            for (String candidate : babbling) 
            {
                boolean isValid = true;
    
                for (String speak : can_speak) 
                {
                    if (candidate.contains(speak + speak)) 
                    {
                        isValid = false;
                        break;
                    }
                }
                if (!isValid) continue;
    
                for (String speak : can_speak) 
                {
                    candidate = candidate.replace(speak, " ");
                }
    
                candidate=candidate.replace(" ", ""); // 공백 제거
                if (candidate.isEmpty()) 
                {
                    answer++;
                }
            }
    
            return answer;
        }
    }
    
    
}
