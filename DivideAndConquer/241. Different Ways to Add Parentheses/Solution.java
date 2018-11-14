class Solution {
    //divide and conquer
    //split string by its operator, record the spliter function
    //each function return list of possible value
    //if no operator, just parseInt
    //ignore the case when -2*2, there is - sign at the front
    
    //optimized solution, add map to memo
    Map<String, List<Integer>> memo = new HashMap<>();
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();
        if (memo.containsKey(input)){
            return memo.get(input);
        }
        int n = input.length();
        int number = 0;
        if (n==0){
            return result;
        }
        boolean onlyNumber = true;
        for (int i=0; i<n; i++){
            char cur = input.charAt(i);
            if (cur=='+' || cur=='-' || cur=='*'){
                onlyNumber = false;
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i+1));
                for (int l:left){
                    for (int r:right){
                        if (cur=='+'){
                            result.add(l+r);
                        }else if (cur=='-'){
                            result.add(l-r);
                        }else if (cur=='*'){
                            result.add(l*r);
                        }
                    }
                }
            }
        }
        if (onlyNumber){
            result.add(Integer.parseInt(input));
        }
        memo.put(input, result);
        return result;
    }
}