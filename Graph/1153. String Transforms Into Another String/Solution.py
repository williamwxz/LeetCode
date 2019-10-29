class Solution:
    # Principal, if the letter can be swap, it should only be swapped ONCE
    #   in case you need to swap twice, because a->c->b->a, some letter will be affected
    #   by other swap, so we need a tmp char for swap, such as, a->tmp, b->a, c->b, tmp->c
    #   with different order, we can break the loop.
    #   however, we will need 1 unused char
    def canConvert(self, str1: str, str2: str) -> bool:
        if str1==str2:
            return True
        record={}
        for i,j in zip(str1, str2):
            if record.get(i, j)!=j:
                return False
            record[i]=j
        return len(set(str2))<26