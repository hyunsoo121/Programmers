public class P67256_W {
class Solution {
    static int[][] key=new int[][] {{1,2,3},{4,5,6},{7,8,9},{-1,0,-2}};
    public String solution(int[] numbers, String hand) {
        StringBuilder sb=new StringBuilder();
        int h=0; //0이면 왼손잡이
        if(hand.equals("right")) h=1; //1이면 오른손잡이
        int current_L=-1; //현재 왼손의 위치를 저장
        int current_R=-2; //현재 오른손의 위치를 저장
        for(int num : numbers){
            if(num==1 || num==4 || num==7)
            {
                sb.append("L");
                current_L=num;
            }
            else if(num==3 || num==6 || num==9){
                sb.append("R");
                current_R=num;
            }
            else{
                int d[]=distance(current_L,current_R,num);
                int L_distance=d[0]; int R_distance=d[1];
                if(L_distance<R_distance){
                    sb.append("L");
                    current_L=num;
                }
                else if(R_distance<L_distance){
                    sb.append("R");
                    current_R=num;
                }
                else{
                    if(h==0){
                        sb.append("L"); current_L=num;
                    }
                    else{
                        sb.append("R"); current_R=num;
                    }
                }
            }
        }
        
        return sb.toString();
    }
    int[] distance(int current_L,int current_R,int num)
    {
        int lx=0; int ly=0; int rx=0; int ry=0;
        int target_x=0; int target_y=0;
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<3;j++){
                if(current_L==key[i][j]){
                    lx=i; ly=j;
                }
                if(current_R==key[i][j]){
                    rx=i; ry=j;
                }
                if(num==key[i][j]){
                    target_x=i; target_y=j;
                }
            }
        }
        int Ldistance=Math.abs(lx-target_x)+Math.abs(ly-target_y);
        int Rdistance=Math.abs(rx-target_x)+Math.abs(ry-target_y);
        return new int[] {Ldistance,Rdistance};
    }
}  
}
