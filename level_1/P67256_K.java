public class P67256_K {
    class Solution {
        public String solution(int[] numbers, String hand) {
            StringBuilder sb = new StringBuilder();
            int left = 10;
            int right = 12;

            for(int i : numbers){
                if(i == 0)
                    i = 11;
                if(i == 1 || i == 4 || i == 7){
                    left = i;
                    sb.append("L");
                }
                else if(i == 3 || i == 6 || i == 9){
                    right = i;
                    sb.append("R");
                }
                else{
                    if(getDistance(i, left) == getDistance(i, right))
                        if(hand.equals("right")){
                            right = i;
                            sb.append("R");
                        }
                        else{
                            left = i;
                            sb.append("L");
                        }
                    else if(getDistance(i, left) < getDistance(i, right)){
                        left = i;
                        sb.append("L");
                    }
                    else{
                        right = i;
                        sb.append("R");
                    }
                }
            }
            return sb.toString();
        }
        public static int getDistance(int num, int hand){
            if(hand == 2 || hand == 5 || hand == 8 || hand == 11){
                return Math.abs(num-hand) / 3;
            }
            else if(hand % 3 == 0){
                return (Math.abs(num-(hand-1)) / 3) + 1;
            }
            else{
                return (Math.abs(num-(hand+1)) / 3) + 1;
            }
        }
    }
}
