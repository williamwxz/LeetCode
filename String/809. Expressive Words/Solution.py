class Solution:
    def expressiveWords(self, S: str, words: List[str]) -> int:
        def check(s, w):
            N,M=len(s),len(w)
            i,j=0,0
            while j<M:
                if i<N and s[i]==w[j]:
                    i,j=i+1,j+1
                elif i>0 and i<N-1 and (s[i-1]==s[i]==s[i+1]):
                    i+=1
                elif i>1 and i<N and (s[i-2]==s[i-1]==s[i]):
                    i+=1
                else:
                    return False
            while i<N:
                if i>0 and i<N-1 and (s[i-1]==s[i]==s[i+1]):
                    i+=1
                elif i>1 and i<N and (s[i-2]==s[i-1]==s[i]):
                    i+=1
                else:
                    return False
            return True
        res=0
        for word in words:
            res+= 1 if check(S, word) else 0
        return res