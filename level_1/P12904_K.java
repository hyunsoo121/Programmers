public class P12904_K {
    class Solution {
        public int solution(String s)
        {
            int answer = 0;

            for(int i = s.length(); i > 0; i--){
                for(int j = 0; j + i <= s.length(); j++){
                    answer = i;
                    for(int k = 0; k < i / 2; k++){
                        if (s.charAt(j + k) != s.charAt(j + i - 1 - k)){
                            answer = 0;
                            break;
                        }
                    }
                    if(answer != 0)
                        return answer;
                }
            }

            return answer;
        }
    }
}
