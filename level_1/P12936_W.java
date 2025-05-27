import java.util.ArrayList;

public class P12936_W 
{
    class Solution 
    {
        public int[] solution(int n, long k) 
        {
            ArrayList<Integer> al = new ArrayList<>();
            for (int i = 1; i <= n; i++) al.add(i);
            int[] answer = new int[n];
            k--;
            long fato = factorial(n - 1);
            for (int i = 0; i < n; i++) 
            {
                int idx = (int)(k / fato);
                answer[i] = al.get(idx);
                al.remove(idx);
                k %= fato;
                if (n - i - 1 > 0)
                    fato /= (n - i - 1);
            }
            return answer;
        }

        public long factorial(int num) {
            if (num == 0) return 1;
            long pac = 1;
            for (int i = 2; i <= num; i++) {
                pac *= i;
            }
            return pac;
        }
    }
}