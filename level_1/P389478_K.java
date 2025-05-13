public class P389478_K {
    class Solution {
        public int solution(int n, int w, int num) {
            int answer = 0;

            int[][] arr = new int[(n/w) + 1][w];

            int num_h = 0;
            int num_w = 0;

            for(int i = 0, count = 1; i < arr.length; i++){

                if(i % 2 == 0){
                    for(int j = 0; j < w; j++, count++){
                        if(count > n)
                            break;

                        if(count == num){
                            num_h = i;
                            num_w = j;
                        }

                        arr[i][j] = count;
                    }
                }
                else{
                    for(int j = w - 1; j >= 0; j--, count++){
                        if(count > n)
                            break;

                        if(count == num){
                            num_h = i;
                            num_w = j;
                        }

                        arr[i][j] = count;
                    }
                }

            }

            for(int i = arr.length - 1; i >= num_h; i--){
                if(arr[i][num_w] != 0){
                    answer++;
                }
            }

            return answer;
        }
    }
}
