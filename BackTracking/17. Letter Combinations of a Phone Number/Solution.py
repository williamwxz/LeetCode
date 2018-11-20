class Solution(object):
    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        n = len(digits)
        phone = {'0':'', '1':'','2':'abc','3':'def','4':'ghi','5':'jkl','6':'mno','7':'pqrs','8':'tuv','9':'wxyz'}
        result=[]
        if n==0:
            return result
        def combinations(digits, index, builder):
            if index>=n:
                result.append(''.join(builder))
                return
            letters = phone[digits[index]]
            for l in letters:
                builder.append(l)
                combinations(digits, index+1, builder)
                builder.pop()
        combinations(digits, 0, list())
        return result
        