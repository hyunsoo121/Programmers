import java.util.*;
public class P42889_W {
class Solution 
{
    public int[] solution(int N, int[] stages) 
    {
        Arrays.sort(stages);
        ArrayList<Stage> staging = new ArrayList<>();
        boolean[] visited=new boolean[N+1]; //staging에 추가했는지 여부 저장장
        for (int i = 0; i <stages.length;) 
        {
            int current=stages[i];
            if(current==N+1) break;
            int cnt=0;
            for(int j=i;j<stages.length;j++)
            {
                if(stages[j]==current) cnt++;
                else break;
            }
            float failureRate=(float) cnt / (stages.length-i); //실패율 계산
            staging.add(new Stage(current, failureRate));
            visited[current]=true;
            i+=cnt;
        }
        for(int i=1;i<=N;i++)
        {
            if(!visited[i]) //staging에 추가하지 않은 경우우
            {
                staging.add(new Stage(i,0));
                visited[i]=true;
            }
        }
        // 정렬
        Collections.sort(staging, new MyComparator());
        // 결과 배열 생성
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) 
        {
            answer[i] = staging.get(i).stage_num;
        }

        return answer;
    }

    class Stage 
    {
        int stage_num;
        float failure;

        public Stage(int stage_num, float failure) 
        {
            this.stage_num = stage_num;
            this.failure = failure;
        }
    }

    static class MyComparator implements Comparator<Stage> 
    {
        public int compare(Stage s1, Stage s2) 
        {
            // 실패율이 높은 순 → 내림차순
            if (s2.failure != s1.failure) 
            {
                return Float.compare(s2.failure, s1.failure);
            } 
            else 
            {
                return Integer.compare(s1.stage_num, s2.stage_num); // 같으면 스테이지 번호 오름차순
            }
        }
    }
}

    
}
