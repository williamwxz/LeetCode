class Solution:
    def subarraysWithKDistinct(self, A: List[int], K: int) -> int:
        N=len(A)
        def atMost(k):
            start,end,res=0,0,0
            record=collections.defaultdict(int) #num:last existing index
            while end<N:
                record[A[end]]=end
                while len(record)>k:
                    if start==record[A[start]]:
                        record.pop(A[start])
                    start+=1
                res+=(end-start+1)
                end+=1
            return res
        return atMost(K)-atMost(K-1)