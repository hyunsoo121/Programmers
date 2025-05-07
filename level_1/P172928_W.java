public class P172928_W{
    class Solution {
        static int row=0;
        static int col=0;
        public int[] solution(String[] park, String[] routes) {
            int[] answer = new int[2];
            row=park.length; col=park[0].length();
            String[][] map=new String[row][col]; //공원을 저장
            int start_x=0; int start_y=0; //시작 장소를 저장
            for(int i=0;i<row;i++)
            {
                String s=park[i];
                for(int j=0;j<col;j++)
                {
                    map[i][j] = String.valueOf(s.charAt(j));
                    if(map[i][j].equals("S"))
                    {
                        start_x=i; start_y=j;
                    }
                }
            }
            for(int i=0;i<routes.length;i++)
            {
                String[] input=routes[i].split(" ");
                String op=input[0]; int n=Integer.parseInt(input[1]);
                int[] check=checking(map,op,n,start_x,start_y); //1이면 이동가능, -1이면 무시
                if(check[2]==1) //이동가능인 경우
                {
                    map[start_x][start_y]="O";
                    start_x=check[0]; start_y=check[1];
                    map[start_x][start_y]="S";
                }
            }
            answer[0]=start_x; answer[1]=start_y;
            return answer;
        }
        static int[] checking(String[][] map, String op, int n, int start_x, int start_y) //움직일 수 있는 지 확인하는 메서드
        {
            if(op.equals("E"))
            {
                for(int i=0;i<n;i++)
                {
                    start_y+=1;
                    if(start_y>=col) return new int[] {start_x,start_y,-1};
                    if(map[start_x][start_y].equals("X")) return new int[] {start_x,start_y,-1};
                }
            }
            else if(op.equals("W"))
            {
                for(int i=0;i<n;i++)
                {
                    start_y-=1;
                    if(start_y<0) return new int[] {start_x,start_y,-1};
                    if(map[start_x][start_y].equals("X")) return new int[] {start_x,start_y,-1};
                }
            }
            else if(op.equals("S"))
                for(int i=0;i<n;i++)
                {
                    start_x+=1;
                    if(start_x>=row) return new int[] {start_x,start_y,-1};
                    if(map[start_x][start_y].equals("X")) return new int[] {start_x,start_y,-1};
                }
            else //"N"
            {
                for(int i=0;i<n;i++)
                {
                    start_x-=1;
                    if(start_x<0) return new int[] {start_x,start_y,-1};
                    if(map[start_x][start_y].equals("X")) return new int[] {start_x,start_y,-1};
                }
            }
            return new int[] {start_x,start_y,1};
        }
    }
}