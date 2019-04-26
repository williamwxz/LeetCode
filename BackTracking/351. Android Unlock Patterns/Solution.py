class Solution:
    def numberOfPatterns(self, m: int, n: int) -> int:
        skip={}
        skip[(1,9)]=skip[(9,1)]=skip[(2,8)]=skip[(8,2)]=skip[(3,7)]=skip[(7,3)]=skip[(4,6)]=skip[(6,4)]=5
        skip[(1,3)]=skip[(3,1)]=2
        skip[(1,7)]=skip[(7,1)]=4
        skip[(3,9)]=skip[(9,3)]=6
        skip[(7,9)]=skip[(9,7)]=8
        
        visited=[False]*10
        def backtrack(cur, remain):
            if remain<=0:
                return 1
            count=0
            visited[cur]=True
            for i in range(1, 10):
                if (not visited[i]) and ((cur,i) not in skip or visited[skip[(cur,i)]]):
                    count+=backtrack(i, remain-1)
            visited[cur]=False
            return count
        res=0
        for i in range(m, n+1):
            res+=backtrack(1, i-1)*4 #1,3,7,9
            res+=backtrack(2, i-1)*4 #2,4,6,8
            res+=backtrack(5, i-1)
        return res