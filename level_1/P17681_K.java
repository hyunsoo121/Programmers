package Programmers.level_1;

import java.util.*;

public class P17681_K {
    class Solution {
        public String[] solution(int n, int[] arr1, int[] arr2) {
            String[] answer = new String[n];
            long[] arr = new long[n];

            for (int i = 0; i < n; i++){
                arr[i] = Long.parseLong((Long.toBinaryString((long)arr1[i]))) +
                        Long.parseLong(Long.toBinaryString((long)arr2[i]));
                // 이진수로 변환하여 Long 형태로 바꾸고 더해서 저장.

                String s = ""; // 벽 저장하는 배열
                for (int j = n; j > 0; j--){
                    if (arr[i] / (long)Math.pow(10, j-1) == 0){
                        s += " "; // 자릿수가 0 이면 벽 없음
                    }
                    else{
                        s += "#";
                        arr[i] %= (long)Math.pow(10, j-1); // 자릿수가 0이 아니면 벽 있음
                    }
                }

                answer[i] = s;
            }
            return answer;
        }
    }
}