import java.util.*;
public class P42862_K {
    class Solution {
        public int solution(int n, int[] lost, int[] reserve) {

            Arrays.sort(lost);
            Arrays.sort(reserve);

            ArrayList<Integer> lostArr = new ArrayList<>();

            for (int i : lost) {
                lostArr.add(i);
            }

            n -= lost.length;

            for (int i = 0; i < reserve.length; i++) {
                if (lostArr.contains(reserve[i])) {
                    lostArr.remove(lostArr.indexOf(reserve[i]));
                    reserve[i] = 0;
                    n++;
                }
            }

            for (int i = 0; i < reserve.length; i++) {
                if (reserve[i] == 0)
                    continue;

                if (lostArr.contains(reserve[i] - 1)) {
                    lostArr.remove(lostArr.indexOf(reserve[i] - 1));
                    n++;
                }
                else if (lostArr.contains(reserve[i] + 1)) {
                    lostArr.remove(lostArr.indexOf(reserve[i] + 1));
                    n++;
                }
            }

            int answer = n;

            return answer;
        }
    }

}
