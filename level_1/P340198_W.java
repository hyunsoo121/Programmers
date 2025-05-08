import java.util.*;
public class P340198_W 
{
    class Solution {
        public int solution(int[] mats, String[][] park) 
        {
            int row = park.length;
            int col = park[0].length;
    
            // mats 배열을 내림차순으로 정렬
            Arrays.sort(mats);
            for (int i = 0; i < mats.length / 2; i++) 
            {
                int temp = mats[i];
                mats[i] = mats[mats.length - 1 - i];
                mats[mats.length - 1 - i] = temp;
            }
    
            // 가장 큰 돗자리부터 차례대로 확인
            for (int mat : mats) 
            {
                for (int i = 0; i <= row - mat; i++) 
                {
                    for (int j = 0; j <= col - mat; j++) 
                    {
                        if (check(i, j, mat, park)) 
                        {
                            return mat; // 가장 큰 돗자리부터 찾으면 바로 리턴
                        }
                    }
                }
            }
    
            return -1; // 어떤 돗자리도 못 깔면 -1 리턴
        }
    
        // 주어진 위치에서 해당 크기의 돗자리를 깔 수 있는지 확인하는 메소드
        public boolean check(int x, int y, int mat, String[][] park) 
        {
            for (int i = 0; i < mat; i++) 
            {
                for (int j = 0; j < mat; j++) 
                {
                    int row = x + i;
                    int col = y + j;
    
                    // 범위를 벗어나면 false
                    if (row >= park.length || col >= park[0].length) 
                    {
                        return false;
                    }
    
                    // 빈 공간이 아니면 false
                    if (!park[row][col].equals("-1")) 
                    {
                        return false;
                    }
                }
            }
            return true; // 모든 공간이 빈 공간이면 true
        }
    }
        
}
