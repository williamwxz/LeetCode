class Solution(object):
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        def helper(result, builder, left, right):
            if left==0 and right==0:
                result.append(''.join(builder))
                return
            if left>0:
                builder.append('(')
                helper(result, builder, left-1, right)
                builder.pop()
            if left<right:
                builder.append(')')
                helper(result, builder, left, right-1)
                builder.pop()
            return
        result, builder=[], []
        helper(result, builder, n, n)
        return result
        