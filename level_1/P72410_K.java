public class P72410_K {
    class Solution {
        public String solution(String new_id) {

            StringBuilder answer = new StringBuilder();
            for (char c : new_id.toCharArray()) {
                if (Character.isUpperCase(c))
                    c = Character.toLowerCase(c);
                if (!Character.isLowerCase(c) && !Character.isDigit(c)
                        && c != '-' && c != '_' && c != '.')
                    continue;
                answer.append(c);
            }

            StringBuilder string3 = new StringBuilder();
            int count = 0;
            for (char c : answer.toString().toCharArray()) {
                if (c == '.' && count == 0) {
                    string3.append(c);
                    count++;
                } else if (c == '.' && count != 0) {
                    continue;
                } else {
                    count = 0;
                    string3.append(c);
                }
            }

            String string4 = string3.toString();
            if (string4.startsWith("."))
                string4 = string4.substring(1);
            if (string4.endsWith(".") && !string4.isEmpty())
                string4 = string4.substring(0, string4.length() - 1);

            if (string4.isEmpty())
                string4 = "a";

            if (string4.length() >= 16)
                string4 = string4.substring(0, 15);
            if (string4.endsWith("."))
                string4 = string4.substring(0, string4.length() - 1);

            while (string4.length() < 3) {
                string4 += string4.charAt(string4.length() - 1);
            }

            return string4;
        }
    }
}
