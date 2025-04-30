import java.util.*;
public class P250121_W {
class Solution {
    static int sort_key=0;
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        ArrayList<Integer> candidate=new ArrayList<>(); //후보 뽑음
        int ext_key=0;
        if(ext.equals("date")) ext_key=1;
        else if(ext.equals("maximum")) ext_key=2;
        else if(ext.equals("remain")) ext_key=3;
        for(int i=0;i<data.length;i++)
        {
            if(data[i][ext_key]<val_ext) //data에서 ext 값이 val_ext보다 작은 데이터 뽑음
            {
                candidate.add(i);
            }
        }
        int[][] answer = new int[candidate.size()][4];
        for(int i=0;i<candidate.size();i++)
        {
            for(int j=0;j<4;j++)
            {
                answer[i][j]=data[candidate.get(i)][j];
            }
        }
        if(sort_by.equals("date")) sort_key=1;
        else if(sort_by.equals("maximum")) sort_key=2;
        else if(sort_by.equals("remain")) sort_key=3;
        Arrays.sort(answer,new mycomparator());
        return answer;
    }
    class mycomparator implements Comparator<int[]>
    {
        public int compare(int[] c1,int[] c2)
        {
            return Integer.compare(c1[sort_key],c2[sort_key]);
        }
    }
}
//data에서 ext 값이 val_ext보다 작은 데이터만 뽑은 후, sort_by에 해당하는 값을 기준으로 오름차순으로 정렬
    
}
