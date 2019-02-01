class RangeModule {
    TreeMap<Integer, Integer> map;
    public RangeModule() {
        map=new TreeMap<>();
    }
    
    public void addRange(int left, int right) {
        // System.out.println("add: ["+left+","+right+")");
        Integer low=map.floorKey(left) , high=map.floorKey(right);
        if (low==null && high==null){
            map.put(left, right);
        }else if (low!=null && left<=map.get(low)){
            int end=Math.max(map.get(low), Math.max(map.get(high), right));
            map.put(low, end);
        }else{
            map.put(left, Math.max(map.get(high), right));
        }
        Map<Integer, Integer> subMap=map.subMap(left, false, right, true);
        map.keySet().removeAll(new HashSet(subMap.keySet()));
        // System.out.println(map);
        // System.out.println();
    }
    
    public boolean queryRange(int left, int right) {
        Integer low=map.floorKey(left);
        return low!=null&&right<=map.get(low);
    }
    
    public void removeRange(int left, int right) {
        // System.out.println("remove: ["+left+","+right+")");
        Integer low=map.floorKey(left), high=map.floorKey(right);
        if (high!=null && right<map.get(high)) {
            map.put(right, map.get(high));
        }
        if (low!=null && left<map.get(low)){
            map.put(low, left);
        }
        Map<Integer, Integer> subMap=map.subMap(left, true, right, false);
        Set<Integer> set = new HashSet(subMap.keySet());
        map.keySet().removeAll(set);
        // System.out.println(map);
        // System.out.println();
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */