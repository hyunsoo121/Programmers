public class P340199_W {
    class Solution {
        public int solution(int[] wallet, int[] bill) {
            int answer = 0;
            boolean possible=false; //돈이 지폐에 들어가는 지 여부를 저장
            int wallet_row=wallet[0]; int wallet_col=wallet[1];
            int bill_row=bill[0]; int bill_col=bill[1];
            while(!possible)
            {
                if((bill_row <= wallet_row && bill_col <=wallet_col) || (bill_row<=wallet_col && bill_col <=wallet_row))
                {
                    possible=true;
                    break;
                }
                
                if(bill_row >= bill_col)
                {
                    bill_row/=2;
                    answer++;
                }
                else
                {
                    bill_col/=2;
                    answer++;
                }
            }
            return answer;
        }
    }
    //
    
}
