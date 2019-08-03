class Solution:
    def parseBoolExpr(self, expression: str) -> bool:
        N=len(expression)
        def evaluate(i):
            if expression[i] in ['t', 'f']:
                return True if expression[i]=='t' else False, i+1
            operator=expression[i]
            i,st=i+2,[]
            while expression[i]!=')':
                if expression[i]==',':
                    i+=1
                    continue
                res,i=evaluate(i)
                st.append(res)
            if operator=='&':
                return all(st), i+1
            if operator=='|':
                return any(st), i+1
            return not st[0], i+1
        res,i=evaluate(0)
        return res
