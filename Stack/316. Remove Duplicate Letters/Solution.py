import collections
class Solution(object):
    def removeDuplicateLetters(self, s):
        """
        :type s: str
        :rtype: str
        """
        n=len(s)
        stack=[]
        record=collections.Counter(s)
        for c in s:
            if c not in stack:
                while stack and record[stack[-1]]>0 and stack[-1]>=c:
                    stack.pop()
                stack.append(c)
            record[c]-=1
        return "".join(stack)
