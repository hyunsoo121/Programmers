import java.util.HashSet;
public class P12981_W 
{
    class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        char prev=words[0].charAt(0); //이전 단어의 마지막글자를 저장
        int loser=0;
        HashSet<String> hs=new HashSet<>();
        for(int i=0;i<words.length;i++)
        {
            char cur=words[i].charAt(0);
            if(prev!=cur) //단어의 첫번째 글자확인
            {
                loser=i;
                break;
            }
            if(hs.contains(words[i])) //단어를 포함하고 있는지 확인
            {
                loser=i;
                break;
            }
            hs.add(words[i]);
            prev=words[i].charAt(words[i].length()-1);
        }
        if(loser==0)
        {
            answer[0]=0; answer[1]=0;
            return answer;
        }
        int lose_person=loser%n+1; //몇번인지
        int number=loser/n+1;
        answer[0]=lose_person; answer[1]=number;
        return answer;
    }
}
}
