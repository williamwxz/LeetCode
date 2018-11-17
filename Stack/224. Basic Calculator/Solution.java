class Solution {
    //(,),+,-,space,non-negative number
    public int calculate(String s) {
        int n = s.length();
        Deque<Integer> stack = new ArrayDeque<>();
        int result=0, sign=1, number=0;
        for (int i=0; i<n; i++){
            char c = s.charAt(i);
            if (Character.isDigit(c)){
                number = number*10 + (c-'0');
            }else if (c=='('){
                stack.offerFirst(result);
                stack.offerFirst(sign);
                number=0;
                result=0;
                sign=1;
            }else if (c==')'){
                result += sign*number;
                sign = stack.pollFirst();
                result = stack.pollFirst() + sign*result;
                number = 0;
                sign=1;
            }else if (c=='+'){
                result += sign*number;
                sign=1;
                number=0;
            }else if (c=='-'){
                result += sign*number;
                sign=-1;
                number=0;
            }
        }
        if (number>0){
            result += sign*number;
        }
        return result;
    }
}