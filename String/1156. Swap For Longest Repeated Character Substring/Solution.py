class Solution:
    def maxRepOpt1(self, text: str) -> int:
        N=len(text)
        record=collections.Counter(text)
        res=0
        for i in range(N):
            j=i+1
            count=1
            diff=0
            while j<N:
                if text[i]!=text[j]:
                    if diff>0:
                        break
                    diff+=1
                count+=1
                j+=1
            count-=diff
            if diff==1 and record[text[i]]-count>0:
                count+=1
            res=max(res, count)
        return res