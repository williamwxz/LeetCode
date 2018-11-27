class Solution {
    //greedy apprach:
    //use the least number to subtract, use the max for addition
    public int bagOfTokensScore(int[] tokens, int P) {
        int n = tokens.length;
        Arrays.sort(tokens);
        int i=0, j=n-1;
        int max=0, power=P, point=0;
        while (i<=j){
            if (power>=tokens[i]){
                power -= tokens[i++];
                point+=1;
            }else{
                if (point<=0){
                    break;
                }
                power+=tokens[j--];
                point-=1;
            }
            max = Math.max(max, point);
        }
        return max;
    }
}