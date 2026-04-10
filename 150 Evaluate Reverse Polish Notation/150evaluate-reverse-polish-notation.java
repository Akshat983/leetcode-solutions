class Solution {
    public int evalRPN(String[] tokens) {
        int[] st = new int[tokens.length];
        int top = -1;

        for (String t : tokens) {

            if (!t.equals("+") && !t.equals("-") && 
                !t.equals("*") && !t.equals("/")) {

                st[++top] = Integer.parseInt(t);
            } 
            else {
                int a = st[top--];
                int b = st[top--];

                if (t.equals("+")) {
                    st[++top] = b + a;
                } else if (t.equals("-")) {
                    st[++top] = b - a;
                } else if (t.equals("*")) {
                    st[++top] = b * a;
                } else {
                    st[++top] = b / a;
                }
            }
        }

        return st[top];
    }
}