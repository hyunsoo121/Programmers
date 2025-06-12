import java.util.*;

public class P42579_W {
    class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String,ArrayList<int[]>> hm=new HashMap<>();
        ArrayList<info> al=new ArrayList<>();
        for(int i=0;i<genres.length;i++)
        {
            hm.putIfAbsent(genres[i], new ArrayList<>());
        }
        for(int i=0;i<genres.length;i++)
        {
            hm.get(genres[i]).add(new int[] {i,plays[i]});
        }
        for(String gen : hm.keySet())
        {
            int total=0; //재생된 횟수를 저장장
            for(int[] playing : hm.get(gen))
            {
                total+=playing[1];
            }
            al.add(new info(gen, total));
        }
        al.sort((a,b)->{
            return Integer.compare(b.playing, a.playing); //재생된 횟수를 기준으로 정렬
        });
        for(String gen : hm.keySet())
        {
            hm.get(gen).sort((a,b)->{
                if(a[1]==b[1])
                {
                    return Integer.compare(a[0],b[0]);
                }
                return Integer.compare(b[1], a[1]);
            });
        }

        ArrayList<Integer> ans=new ArrayList<>();
        for(info temp : al)
        {
            if(hm.get(temp.gen).size()>=2)
            {
                for(int i=0;i<2;i++)
                {
                    int[] candidate=hm.get(temp.gen).get(i);
                    ans.add(candidate[0]);
                }
            }
            else
            {
                int[] candidate=hm.get(temp.gen).get(0);
                ans.add(candidate[0]);
            }
        }
        int n=ans.size();
        int[] answer=new int[n];
        for(int i=0;i<n;i++)
        {
            answer[i]=ans.get(i);
        }
        return answer;
    }
}
class info
{
    String gen;
    int playing;
    info(String gen,int playing)
    {
        this.gen=gen;
        this.playing=playing;
    }
}
}
