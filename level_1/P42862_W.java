import java.util.*;
class P42862_W{
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        boolean[] usedReserve = new boolean[reserve.length];
        boolean[] recovered = new boolean[lost.length];
        Arrays.sort(lost); Arrays.sort(reserve);
        // 자기 여벌로 해결한 학생
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    usedReserve[j] = true;
                    recovered[i] = true;
                }
            }
        }

        // 옆 친구에게 빌린 경우
        for (int i = 0; i < lost.length; i++) 
        {
            for (int j = 0; j < reserve.length; j++) 
            {
                if (Math.abs(lost[i] - reserve[j]) == 1 && !usedReserve[j] && !recovered[i]) {
                    usedReserve[j] = true;
                    recovered[i] = true;
                    break;
                }
            }
        }

        for (boolean b : recovered) {
            if (!b) n--;
        }

        return n;
    }
}

}