class Solution:
    def isNStraightHand(self, hand: List[int], W: int) -> bool:
        N=len(hand)
        if N%W!=0:
            return False
        count=collections.Counter(hand)
        queue=collections.deque()
        last_card,open_group=-1, 0
        for card in sorted(count):
            if open_group>0 and last_card<card-1:
                #there are groups need card, but no consecutive left
                return False
            if count[card]<open_group:
                #not enough to cover all groups
                return False
            # now must be count[card]>=open_group
            # append # of new group
            queue.append(count[card]-open_group)
            last_card,open_group=card,count[card]
            if len(queue)==W:
                #close some groups
                open_group-=queue.popleft()
        return open_group==0