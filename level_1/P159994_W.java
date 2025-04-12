public class P159994_W 
{
    class Solution {
        public String solution(String[] cards1, String[] cards2, String[] goal) {
            int std1=0; int std2=0; //각 카드에서 뽑을 순서
            for(int i=0;i<goal.length;i++)
            {
                if(std1<cards1.length&&goal[i].equals(cards1[std1]))
                {
                    std1++;
                }
                else if(std2<cards2.length && goal[i].equals(cards2[std2]))
                {
                    std2++;
                }
                else
                {
                    return "No";
                }
            }
            return "Yes";
        }
    } 
}
