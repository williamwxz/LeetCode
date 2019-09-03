class Solution:
    def maximumSwap(self, num: int) -> int:
        digits=list(map(int, str(num)))
        last={x:i for i, x in enumerate(digits)}
        N=len(digits)
        for i in range(N):
            for d in range(9, digits[i], -1):
                if d not in last:
                    continue
                index=last[d]
                if index>i:
                    digits[i], digits[index]=digits[index],digits[i]
                    return int(''.join(str(digit) for digit in digits))
        return num