class Solution:
    def maxProduct(self, words: List[str]) -> int:
        d=collections.defaultdict(int)
        N=len(words)
        if N<2:
            return 0
        a=ord('a')
        for word in words:
            key=0
            for s in word:
                key|=(1<<(ord(s)-a))
            d[key]=max(d[key], len(word))
        res=0
        for w1 in d:
            for w2 in d:
                if not w1&w2:
                    res=max(res, d[w1]*d[w2])
        return res