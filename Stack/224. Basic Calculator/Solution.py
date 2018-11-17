class Solution(object):
    def calculate(self, s):
        """
        :type s: str
        :rtype: int
        """
        n = len(s)
        stack = []
        result, number, sign=0,0,1
        for c in s:
            if c.isdigit():
                number = number*10+int(c)
            elif c=='(':
                stack.append(result)
                stack.append(sign)
                result, number, sign=0,0,1
            elif c==')':
                result += sign*number
                result *= stack.pop()
                result += stack.pop()
                number, sign = 0, 1
            elif c=='+':
                result += sign*number
                number, sign = 0, 1
            elif c=='-':
                result += sign*number
                number, sign = 0, -1
        if number>0:
            result += sign*number
        return result
    