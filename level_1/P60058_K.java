public class P60058_K {
    class Solution {
        public String solution(String p) {

            return recursion(p).toString();
        }

        public String recursion(String s){
            if(s.length() == 0){
                return "";
            }

            int left = 0, right = 0;
            boolean isTrue = false;
            StringBuilder u = new StringBuilder(), v = new StringBuilder();

            for(char c : s.toCharArray()){
                if(isTrue)
                    v.append(c);
                else{
                    u.append(c);

                    if(c == ')'){
                        right++;
                    }
                    else{
                        left++;
                    }
                }
                if(left == right){
                    isTrue = true;
                }
            }

            String s1 = u.toString();
            int count = 0;
            isTrue = true;

            for (char c : u.toString().toCharArray()) {
                if (c == '(') count++;
                else {
                    if (count == 0) {
                        isTrue = false;
                        break;
                    }
                    count--;
                }
            }

            System.out.println("u = " + u.toString());
            System.out.println("v = " + v.toString());
            if(isTrue){
                return new StringBuilder(u).append(recursion(v.toString())).toString();
            }
            else {
                StringBuilder sb = new StringBuilder();
                sb.append("(");
                sb.append(recursion(v.toString()));
                sb.append(")");
                String trimmedU = u.substring(1, u.length() - 1);
                for (char c : trimmedU.toCharArray()) {
                    sb.append(c == '(' ? ")" : "(");
                }
                return sb.toString();
            }
        }
    }
}
