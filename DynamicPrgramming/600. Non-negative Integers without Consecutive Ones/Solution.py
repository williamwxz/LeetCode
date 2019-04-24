class Solution:
    def findIntegers(self, num: int) -> int:
        binary='{0:b}'.format(num)
        binary=binary[::-1]
        N=len(binary)
        zeros=[0]*(N)
        ones=[0]*(N)
        zeros[0]=1
        ones[0]=1
        for i in range(1, N):
            zeros[i]=zeros[i-1]+ones[i-1]
            ones[i]=zeros[i-1]
        res = zeros[N-1]+ones[N-1]
        for i in range(N-2, -1, -1):
            if binary[i]=='0' and binary[i+1]=='0':
                res-=ones[i]
            elif binary[i]=='1' and binary[i+1]=='1':
                break
        return res