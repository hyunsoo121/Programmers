import java.util.*;
class P67257_W{
class Solution {
        char[][] priority=new char[6][3];
    public long solution(String expression) {
        init(priority);
        ArrayList<Character> operator=new ArrayList<>();
        ArrayList<Long> number=new ArrayList<>();
        long num=0;
        for(int i=0;i<expression.length();i++)
        {
            char c=expression.charAt(i);
            int digit=c-'0';
            if(digit>=0 && digit<=9)
            {
                num=num*10+digit; //숫자면 더하면서 몇인지 구함
            }
            else
            {
                operator.add(c); //연사자인 경우 연산자 list에 추가
                number.add(num);
                num=0; //num초기화
            }
        }
        number.add(num);

        long max=0;
        for(int i=0;i<6;i++) //우선순위를 정하는 경우
        {
            ArrayList<Long> al = new ArrayList<>(number);
            ArrayList<Character> op =new ArrayList<>(operator);
            for(int j=0;j<3;j++)
            {
                char oper=priority[i][j];
                for(int k=0;k<op.size();)
                {
                    if(op.get(k)==oper)
                    {
                        long temp_result=calculate(al.get(k), al.get(k+1), oper);
                        al.remove(k); al.remove(k);
                        al.add(k,temp_result);
                        op.remove(k);
                    }
                    else k++;
                }
            }
            max=Math.max(max,Math.abs(al.get(al.size()-1)));
        }

        return max;
    }
    public void init(char[][] priority)
    {
        priority[0][0]='*'; priority[0][1]='-'; priority[0][2]='+';
        priority[1][0]='*'; priority[1][1]='+'; priority[1][2]='-';
        priority[2][0]='-'; priority[2][1]='*'; priority[2][2]='+';
        priority[3][0]='-'; priority[3][1]='+'; priority[3][2]='*';
        priority[4][0]='+'; priority[4][1]='-'; priority[4][2]='*';
        priority[5][0]='+'; priority[5][1]='*'; priority[5][2]='-';
    }
    public long calculate(long v1, long v2, char oper)
    {
        if(oper=='*')
        {
            return v1*v2;
        }
        else if(oper=='+')
        {
            return v1+v2;
        }
        else
        {
            return v1-v2;
        }
    }
}
}