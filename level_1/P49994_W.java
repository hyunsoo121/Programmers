import java.util.*;
public class P49994_W {
    class Solution {
    public int solution(String dirs) {
        int current_x=0; int current_y=0; //현재 위치를 저장
        Set<String> set=new TreeSet<>();
        for(int i=0;i<dirs.length();i++)
        {
            char c=dirs.charAt(i);
            StringBuilder sb=new StringBuilder();
            if(c=='U' && current_y<=4)
            {
                sb.append(current_x).append(current_y).
                append(current_x).append(current_y+1);
                set.add(sb.toString());
                sb.setLength(0);     
                sb.append(current_x).append(current_y+1).
                append(current_x).append(current_y);
                set.add(sb.toString());
                current_y++;
            }
            else if(c=='L' && current_x>=-4)
            {
                sb.append(current_x).append(current_y).
                append(current_x-1).append(current_y);
                set.add(sb.toString());
                sb.setLength(0);
                sb.append(current_x-1).append(current_y).
                append(current_x).append(current_y);
                current_x--;
                set.add(sb.toString());
            }
            else if(c=='R' && current_x<=4)
            {
                sb.append(current_x).append(current_y).
                append(current_x+1).append(current_y);
                set.add(sb.toString());
                sb.setLength(0);
                sb.append(current_x+1).append(current_y).
                append(current_x).append(current_y);
                current_x++;
                set.add(sb.toString());
            }
            else if(c=='D' && current_y>=-4)
            {
                sb.append(current_x).append(current_y).
                append(current_x).append(current_y-1);
                set.add(sb.toString());
                sb.setLength(0);
                sb.append(current_x).append(current_y-1).
                append(current_x).append(current_y);
                current_y--;
                set.add(sb.toString());
            }
            sb.setLength(0);
        }
        return set.size()/2;
    }
}
}
