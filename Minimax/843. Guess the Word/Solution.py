# """
# This is Master's API interface.
# You should not implement it, or speculate about its implementation
# """
#class Master(object):
#    def guess(self, word):
#        """
#        :type word: str
#        :rtype int
#        """

class Solution(object):
    def findSecretWord(self, wordlist, master):
        """
        :type wordlist: List[Str]
        :type master: Master
        :rtype: None
        """
        def match(s1, s2):
            count=0
            for c,v in enumerate(s1):
                if s1[c]==s2[c]:
                    count+=1
            return count
        
        length=len(wordlist[0])
        n=0
        while n<length:
            count=collections.defaultdict(int)
            for w1 in wordlist:
                for w2 in wordlist:
                    if match(w1, w2)==0:
                        count[w1]+=1
            word=min(wordlist, key=lambda x:count[x])
            n=master.guess(word)
            wordlist=[w for w in wordlist if match(word, w)==n]
            