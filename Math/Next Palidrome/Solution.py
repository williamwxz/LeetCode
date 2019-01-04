def next_palidrome(s):
    """
    :type s: str
    :rtype: str
    """
    n=len(s)
    if n%2==0:
        center=''
    else:
        center=s[n//2]
    left=s[:n//2]
    right=left[::-1]
    num=left+center+right
    if num>s:
        return num
    else:
        if center:
            if center<'9':
                center=str(int(center)+1)
                return left+center+right
            else:
                center='0'
        if left==len(left)*'9':
            return '1'+(n-1)*'0'+'1'
        left=str(int(left)+1)
        right=left[::-1]
        return left+center+right


if __name__ == "__main__":
    print(next_palidrome('3995'))
