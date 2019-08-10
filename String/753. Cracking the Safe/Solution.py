class Solution:
    def crackSafe(self, n: int, k: int) -> str:
        visited=set()
        total=k**n
        
        def dfs(builder):
            if len(visited)==total:
                print(visited)
                return True
            last_digits = len(builder)-n+1
            last=builder[last_digits:] if last_digits<len(builder) else []
            for i in range(k):
                num=str(i)
                last.append(num)
                curStr=''.join(last)
                if curStr not in visited:
                    visited.add(curStr)
                    builder.append(num)
                    if dfs(builder):
                        return True
                    visited.remove(curStr)
                    builder.pop(-1)
                #### important here ########
                last.pop(-1)
                ############################
            return False
        builder=['0']*n
        visited.add(''.join(builder))
        dfs(builder)
        return ''.join(builder)