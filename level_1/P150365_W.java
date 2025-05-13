public class P150365_W {
    class Solution {
    static int[] dx={1,0,0,-1}; // d, l, r, u
    static int[] dy={0,-1,1,0};
    static String[] dir={"d","l","r","u"};

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        StringBuilder sb=new StringBuilder();
        int min_distance=Math.abs(x-r)+Math.abs(y-c); //맨해튼 거리
        if (min_distance>k||(k-min_distance)%2!=0) 
        {
            return "impossible";
        }
        int cx=x,cy=y;
        for (int i=0;i<k;i++) 
        {
            boolean move=false;
            for (int d=0;d<4;d++) 
            {
                int nx=cx+dx[d];
                int ny=cy+dy[d];
                if (nx<1||nx>n||ny<1||ny>m) continue;
                int distance = Math.abs(nx-r)+Math.abs(ny-c);
                int remain=k-i-1;
                if (distance<=remain&&(remain-distance)%2==0) 
                {
                    sb.append(dir[d]);
                    cx=nx;
                    cy=ny;
                    move=true;
                    break;
                }
            }
            if (!move) 
            {
                return "impossible";
            }
        }
        return sb.toString();
    }
}

}
