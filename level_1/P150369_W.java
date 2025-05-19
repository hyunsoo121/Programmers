public class P150369_W {
    class Solution {
     public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long distance = 0;
        int total_deliver=0;
        for(int d : deliveries) total_deliver+=d; //전체 배달 개수
        int dIdx=n-1, Pidx=n-1;
        while(dIdx >=0 || Pidx>=0)
        {
            int current_cap=0; //현재 들고가는 택배 상자의 개수
            if(total_deliver>=cap) current_cap=cap;
            else current_cap=total_deliver;

            int delivery_distance=fartherest_delivery(deliveries, dIdx); //배송지 중 가장 먼 거리
            dIdx=delivery_distance-1;
            update_deliveries(deliveries, current_cap, dIdx+1); //택배 update
            total_deliver-=current_cap;

            int pickup_distance=fartherest_pickup(pickups, Pidx); //픽업 중 가장 먼 거리
            Pidx=pickup_distance-1;
            update_pickup(pickups,Pidx+1,cap); //pickup update
            distance+=Math.max(delivery_distance,pickup_distance)*2;
        }
        return distance;
    }
    int fartherest_delivery(int[] deliveries,int n) //가장 먼 배송지를 찾는 메서드
    {
        for(int i=n;i>=0;i--)
        {
            if(deliveries[i]!=0) return i+1;
        }
        return 0;
    }
    int fartherest_pickup(int[] pickups,int n) //가장 먼 픽업 장소를 찾는 메서드드
    {
        for(int i=n;i>=0;i--)
        {
            if(pickups[i]!=0) return i+1;
        }
        return 0;
    }
    void update_deliveries(int[] deliveries,int current_cap,int n)
    {
        for(int i=n-1;i>=0;i--)
        {
            if(current_cap>=deliveries[i]) //배송완료가능
            {
                current_cap-=deliveries[i];
                deliveries[i]=0;
            }
            else
            {
                deliveries[i]-=current_cap;
                current_cap=0;
            }
            if(current_cap==0) return;
        }
    }
    void update_pickup(int[] pickups,int n,int cap)
    {
        int possible=cap; //가져갈 수 있는 상자자
        for(int i=n-1;i>=0;i--)
        {
            if(possible >=pickups[i])
            {
                possible-=pickups[i];
                pickups[i]=0;
            }
            else
            {
                pickups[i]-=possible;
                possible=0;
            }
            if(possible==0) return;
        }
    }
}
}