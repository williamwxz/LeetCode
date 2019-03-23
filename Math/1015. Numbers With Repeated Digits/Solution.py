class Solution:
    def numDupDigitsAtMostN(self, N: int) -> int:
        num = str(N+1)
        array=[int(c) for c in num]
        res,n=0,len(array)
        # n=slot, if no slots left, only one way
        def P(m, n):
            return 1 if n==0 else P(m, n-1)*(m-n+1)
        # count number smaller than N, from 1 digit to n-1 digit
        for i in range(1, n):
            res+=9*P(9, i-1)
        
        # count the number with same digit as N
        visited = set()
        for i, val in enumerate(array):
            for j in range(0 if i else 1, val):
                if j not in visited:
                    res+=P(9-i, n-i-1)
            if val in visited:
                break
            visited.add(val)
        return N-res