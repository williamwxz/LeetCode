class Solution:
    def pyramidTransition(self, bottom: str, allowed: List[str]) -> bool:
        triple=collections.defaultdict(list)
        for a in allowed:
            triple[a[:2]].append(a[2])
            
        def pyramid(bottom):
            if len(bottom)==1:
                return True
            upper=[]
            for i in range(1, len(bottom)):
                upper.append(triple[bottom[i-1:i+1]])
            child=itertools.product(*upper)
            for c in child:
                b=''.join(c)
                if pyramid(b):
                    return True
            return False
        return pyramid(bottom)