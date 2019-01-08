class Solution(object):
    def threeEqualParts(self, A):
        """
        :type A: List[int]
        :rtype: List[int]
        """
        n=len(A)
        total=A.count(1)
        if total%3!=0:
            return [-1,-1]
        if total==0:
            return [0, n-1]
        c=total/3
        array=[]
        c2=0
        for a in A[::-1]:
            array.insert(0, a)
            c2+=a
            if c2==c:
                break
        res=[]
        i=0
        c2l=len(array)
        while i<=n-2*c2l:
            if A[i]==1 and A[i:i+c2l]==array:
                res.append(i)
                i+=c2l
            else:
                i+=1
        if len(res)!=2:
            return [-1, -1]
        return [res[0]+c2l-1, res[1]+c2l]
        