class Solution {
    public String removeDuplicateLetters(String s) {
        int n=s.length();
        char[] map=new char[26];
        boolean[] exist=new boolean[26];
        Deque<Character> stack=new ArrayDeque<>();
        for (int i=0; i<n; i++)
            map[s.charAt(i)-'a']++;
        for (int i=0; i<n; i++){
            char c=s.charAt(i);
            if (!exist[c-'a']){
                //stack.peekLast()>c or stack.peekLast()>=c doesn't matter
                while (!stack.isEmpty()&&map[stack.peekLast()-'a']>0&&stack.peekLast()>c)
                    exist[stack.pollLast()-'a']=false;
                exist[c-'a']=true;
                stack.offerLast(c);
            }
            map[c-'a']--;
        }
        StringBuilder builder=new StringBuilder();
        while (!stack.isEmpty())
            builder.append(stack.pollFirst());
        return builder.toString();
    }
}