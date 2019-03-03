class Solution {
    public int numSquarefulPerms(int[] A) {
        int n=A.length;
        if(n==0)
            return 0;
        int[] res=new int[1];
        dfs(A, new boolean[n], new ArrayList<>(), res);
        return res[0];
    }
    private void dfs(int[] A, boolean[] used, List<Integer> track, int[] res){
        int n=A.length;
        if(track.size()==n){
            res[0]++;
            return;
        }
        //skip the following condition
        //1. if the number has been used
        //2. skip unused duplicate number
        //3. make sure the sum of last two number is perfect square
        for(int i=0; i<n; i++){
            int size=track.size();
            if(used[i]||(i>0&&A[i-1]==A[i]&&!used[i-1])||(size>0&&!isSquare(A[i]+track.get(size-1))))
                continue;
            used[i]=true;
            track.add(A[i]);
            dfs(A, used, track, res);
            track.remove(track.size()-1);
            used[i]=false;
        }
    }
    private boolean isSquare(int num){
        return (Double)Math.sqrt(num)==(int)Math.sqrt(num);
    }
}