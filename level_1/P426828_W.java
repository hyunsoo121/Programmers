import java.util.*;

public class P426828_W {
    class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
            return Integer.compare(b,a);
        });
        int min=Integer.MAX_VALUE;
        for(String s : operations)
        {
            String[] oper=s.split(" ");
            String command=oper[0];
            int num=Integer.parseInt(oper[1]);
            if(command.equals("I"))
            {
                pq.add(num);
                min=Math.min(min,num);
            }
            else if(command.equals("D"))
            {
                if(pq.isEmpty()) continue; //비어있는 경우 D 명령어 무시
                if(num==1)
                {
                    pq.poll(); //가장 앞에 있는거 삭제
                    if(!pq.isEmpty())
                    {
                        min=Collections.min(pq);
                    }
                    else
                    {
                        min=Integer.MAX_VALUE;
                    }
                }
                else if(num==-1)
                {
                    pq.remove(min); //제일 뒤에 있는거 삭제
                    if(!pq.isEmpty())
                    {
                        min=Collections.min(pq);
                    }
                    else
                    {
                        min=Integer.MAX_VALUE;
                    }
                }
            }
        }
        if(pq.isEmpty())
        {
            return new int[] {0,0};
        }
        else
        {
            return new int[] {Collections.max(pq),Collections.min(pq)};
        }
    }
}
}
