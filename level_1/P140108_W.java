public class P140108_W 
{
    class Solution {
        public int solution(String s) {
            int answer = 0;
            char[] str=s.toCharArray();
            for(int i=0;i<str.length;)
            {
                char x=str[i]; //첫번째 문자
                int cor=1; int dif=0; //각각 일치 개수, 불일치 개수
                for(int j=i+1;j<str.length;j++)
                {
                    if(x==str[j]) cor++; //같은 경우
                    else dif++; //같지 않은 경우
                    
                    if(cor==dif) break; //숫자가 같아지면 빠져나옴
                }
                answer++; //문자열 증가
                i+=(cor+dif);
            }
            return answer;
        }
    }
}
