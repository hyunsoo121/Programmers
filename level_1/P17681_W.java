public class P17681_W {
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) { //n은 지도의 한 변의 크기
        int[][] money_map=new int[n][n];
        make_map(n,arr1,money_map);
        make_map(n,arr2,money_map);
        StringBuilder sb=new StringBuilder();
        String[] answer = new String[n];
        for(int i=0;i<n;i++)
        {
            for(int j=n-1;j>=0;j--)
            {
                if(money_map[i][j]==1)
                {
                    sb.append('#');
                }
                else
                {
                    sb.append(" ");
                }
            }
            answer[i]=sb.toString();
            sb.setLength(0);
        }
        return answer;
    }
    public void make_map(int n, int[] arr,int[][] money_map)
    {
        int r=0;
        for(int key : arr)
        {
            int temp=key;
            int[] map=new int[n];
            int c=0;
            if(temp!=0)
            {
             while(temp!=1)
            {
                map[c]=temp%2; c++;
                temp/=2;
            }
            map[c]=1;
            if(c==n-2)
            {
                c++;
                map[c]=0;
            }   
            }
            for(int j=n-1;j>=0;j--)
            {
                if(money_map[r][j]==0) //0일때
                {
                    if(map[j]==1)
                    {
                        money_map[r][j]=1;
                    }
                }
            }
            r++;
        }
    }
}
    
}
