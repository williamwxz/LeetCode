class FenwickTree{
    private int[] array;
    public FenwickTree(int n){
        array=new int[n];
    }
    
    public void update(int i, int val){
        while (i<array.length){
            array[i]+=val;
            i += lowbit(i);
        }
    }

    public int query(int i){
        int sum=0;
        if (i>=array.length)
            return sum;
        while (i>0){
            sum += array[i];
            i -= lowbit(i);
        }
        return sum;
    }

    private int lowbit(int x){
        return x&(-x);
    }
}