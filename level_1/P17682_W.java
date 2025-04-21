public class P17682_W {
class Solution {
    public int solution(String dartResult) { //점수|보너스|옵션
        int[] before_add=new int[3]; //총 3번의 기회
        int cnt=-1; //before_add에 넣을 때 사용
        char[] input=dartResult.toCharArray();
        int num=0;
        for(int i=0;i<input.length;i++)
        {
            if(input[i]-'0'<=9 && input[i]-'0'>=0)
            {
                cnt++;
                if(input[i]-'0'==1 && input[i+1]-'0'==0)
                {
                    num=10; i++;
                    before_add[cnt]=num;
                }
                else
                {
                 num=input[i]-'0';
                before_add[cnt]=num;   
                }
            }
            if(input[i]=='D') before_add[cnt]=(int)Math.pow(before_add[cnt],2);
            else if(input[i]=='T') before_add[cnt]=(int)Math.pow(before_add[cnt],3);
            
            if(input[i]=='*')
            {
                if(cnt==0) before_add[cnt]*=2;
                else
                {
                    before_add[cnt-1]*=2;
                    before_add[cnt]*=2;
                }
            }
            if(input[i]=='#') before_add[cnt]*=-1;
        }
        int answer = 0;
        for(int number : before_add)
        {
            answer+=number;
        }
        return answer;
    }
}
    
}
