# 950. Reveal Cards In Increasing Order

Difficulty:2.5

Reversing the think process:
[2,3,5,7,11,13,17] -> [2,13,3,11,5,17,7]

1. Start from an empty deck(queue)
2. Think about if you flip the cards reversely, how do you do
3. always take the last card from the deck, put the largest one onto the top of the deck
    1. why put the largest one? because we will flip the top card everytime, and each flipped card must be in-order
4. and then you will have the final result in a queue.
