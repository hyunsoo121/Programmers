import java.util.*;

public class P250121_K {
    class Solution {
        public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
            List<int[]> list = new ArrayList<>();

            String[] extList = {"code", "date", "maximum", "remain"};

            int extIdx = 0;
            int sortIdx = 0;

            for(int i = 0; i < 4; i++){
                if(extList[i].equals(ext))
                    extIdx = i;
                if(extList[i].equals(sort_by))
                    sortIdx = i;
            }

            final int sortColumn = sortIdx;

            for(int i = 0; i < data.length; i++){
                if(data[i][extIdx] < val_ext){
                    list.add(data[i]);
                }
            }

            list.sort(new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    return Integer.compare(a[sortColumn], b[sortColumn]);
                }
            });

            return list.toArray(new int[0][]);
        }
    }
}
