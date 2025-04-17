import java.util.*;
public class P135808_W {
class Solution {
    public long solution(int k, int m, int[] score) {
        Arrays.sort(score); //크기 순으로 정렬
        long answer = 0;
        int start_point=0; //각각의 상자의 시작점을 저장
        int end_point=0; //각각의 상자의 끝점을 저장
        for(int i=score.length-1;i>=0;)
        {
            start_point=i;
            for(int j=i;j>i-m;j--)
            {
                if(j<0 || j>=score.length)
                {
                    return answer;
                }
                else
                {
                    end_point=j;
                }
            }
            if(start_point-end_point+1==m) //상자를 만들 수 있는 경우
            {
                answer+=score[end_point]*m; //최저 점수 사과 * 사과의 개수
            }
            i-=m;
        }
        return answer;
    }
}
    
}
