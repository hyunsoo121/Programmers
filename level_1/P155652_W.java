public class P155652_W 
{
class Solution {
    public String solution(String s, String skip, int index) {
        //skip에 들어있는거는 세지 않음, index뒤에있는걸로바꿈
        StringBuilder sb=new StringBuilder();
        char[] str=s.toCharArray();
        int[] num=new int[str.length];
        for(int i=0;i<str.length;i++)
        {
            num[i]=str[i]-'a'; //숫자로 바꿈
        }
        for(int i=0;i<str.length;i++)
        {
            int x=num[i];
            int move=0;
            while(move<index)
            {
                x+=1; //이동
                x%=26; //순환
                if(skip.contains(String.valueOf((char)(x + 'a')))) continue;
                move++;
            }
            num[i]=x;
        }
        for(int i=0;i<num.length;i++)
        {
            sb.append((char)(num[i] + 'a'));
        }
        String answer = sb.toString();
        return answer;
    }
}    
}
