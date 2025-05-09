class P250137{
    class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int t=bandage[0]; int x=bandage[1]; int y=bandage[2];
        int len=attacks.length; int LastTime=attacks[len-1][0];
        int current_health=health;
        int current=0; //기술이 연속된 시간
        int last_attack=0;
        for(int i=last_attack;i<=LastTime;i++)
        {
            boolean attacked=false;
            for(int j=0;j<len;j++)
            {
                if(i==attacks[j][0]) //공격시간이라면
                {
                    current=0; current_health-=attacks[j][1]; //health에서 깎음
                    attacked=true; //공격당함
                    last_attack=j;
                    if(current_health<=0) return -1;
                    break;
                }
            }
            if(attacked) continue;
            current_health+=x; current++;
            if(current==t) //연속으로 t초만큼 증가시킨 경우
            {
                current_health+=y; current=0;
            }
            if(current_health>=health) current_health=health;
        }
        answer=current_health;
        return answer;
    }
}
}