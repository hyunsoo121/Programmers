import java.util.*;
public class P138477_W {
class Solution {
    public int[] solution(int k, int[] score) { //k는 점수의 개수, score은 가수들의 점수
        ArrayList<Integer> al=new ArrayList<>();
        ArrayList<Integer> today=new ArrayList<>();
        for(int key : score)
        {
            if(al.size()<k) //k일보다 적은 경우
            {
                al.add(key);
                Collections.sort(al);
                today.add(al.get(0)); //
            }
            else
            {
                if(al.get(0)<key) //key가 최하점보다 높은 경우
                {
                    al.remove(0); //최하점을 삭제
                    al.add(key); //key 추가
                    Collections.sort(al);
                    today.add(al.get(0));
                }
                else
                {
                    today.add(al.get(0));
                }
            }
        }
        int[] answer = new int[today.size()];
        for(int i=0;i<today.size();i++)
        {
            answer[i]=today.get(i);
        }
        return answer;
    }
}
    
}
