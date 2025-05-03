import java.util.*;
public class P72410_W {
class Solution {
    public String solution(String new_id) {
        StringBuilder sb=new StringBuilder();
        char[] special = new char[] {
    '~','!','@','#','$','%','^','&','*','(',')','=','+',
    '[',']','{','}',':','?',',','<','>','/'};
        new_id = new_id.toLowerCase(); //소문자로 치환
        char [] temp=new_id.toCharArray();
        ArrayList<Character> al=new ArrayList<>();
        for(char c : temp){
            boolean check=false;
            for(char k : special){
                if(c==k){
                    check=true; break;
                } 
            }
            if(!check) al.add(c);
        }
        for(int i=1;i<al.size();){
            if(al.get(i-1)=='.' && al.get(i)=='.'){
                al.remove(i);
            }
            else{
                i++;
            }
        }
        if(!al.isEmpty()&&al.get(0)=='.') al.remove(0);
        if(!al.isEmpty()&&al.get(al.size()-1)=='.') al.remove(al.size()-1);
        if(al.isEmpty()) al.add('a');
        if(al.size()>=16){
            for(int i=al.size()-1;i>=15;i--) al.remove(i);
        }
        if(!al.isEmpty()&&al.get(0)=='.') al.remove(0);
        if(!al.isEmpty()&&al.get(al.size()-1)=='.') al.remove(al.size()-1);
        while (al.size() < 3) al.add(al.get(al.size() - 1));
        for(char c : al){
            sb.append(c);
        }
        return sb.toString();
    }
    }
    
}
