import java.util.*;

public class P67257_K {
    class Solution {

        long answer = 0;

        public long solution(String expression) {
            ArrayList<Character> opList = new ArrayList<>();
            ArrayList<String> exp = new ArrayList<>();

            StringBuilder sb = new StringBuilder();

            for (char c : expression.toCharArray()) {
                if (!Character.isDigit(c)) {
                    exp.add(sb.toString());
                    sb.setLength(0);
                    exp.add(String.valueOf(c));
                    if (!opList.contains(c)) {
                        opList.add(c);
                    }
                } else {
                    sb.append(c);
                }
            }
            exp.add(sb.toString());

            boolean[] used = new boolean[opList.size()];
            ArrayList<Character> cur = new ArrayList<>();
            op(opList, used, cur, exp);

            return answer;
        }

        public void op(ArrayList<Character> opList, boolean[] used, ArrayList<Character> cur, ArrayList<String> exp) {
            if (cur.size() == opList.size()) {
                long result = Math.abs(calculate(exp, cur));
                answer = Math.max(answer, result);
                return;
            }

            for (int i = 0; i < opList.size(); i++) {
                if (!used[i]) {
                    used[i] = true;
                    cur.add(opList.get(i));
                    op(opList, used, cur, exp);
                    cur.remove(cur.size() - 1);
                    used[i] = false;
                }
            }
        }

        public long calculate(ArrayList<String> exp, ArrayList<Character> opList) {
            ArrayList<String> expCopy = new ArrayList<>(exp);

            for (char op : opList) {
                for (int i = 0; i < expCopy.size(); ) {
                    if (expCopy.get(i).equals(String.valueOf(op))) {
                        long a = Long.parseLong(expCopy.get(i - 1));
                        long b = Long.parseLong(expCopy.get(i + 1));
                        long result = 0;

                        if (op == '+') {
                            result = a + b;
                        }

                        else if (op == '-') {
                            result = a - b;
                        }

                        else if (op == '*') {
                            result = a * b;
                        }

                        expCopy.remove(i - 1);
                        expCopy.remove(i - 1);
                        expCopy.remove(i - 1);
                        expCopy.add(i - 1, String.valueOf(result));

                        i = 0;
                    } else {
                        i++;
                    }
                }
            }
            return Long.parseLong(expCopy.get(0));
        }

    }
}
