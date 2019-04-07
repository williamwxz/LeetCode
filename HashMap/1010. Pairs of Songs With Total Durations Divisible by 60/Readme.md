# 1010. Pairs of Songs With Total Durations Divisible by 60

Difficulty: 2.0

Most interesting is this part:

If we want hash key (t%60), and use (60-t%60) to find the previous key, you found the range of key is 1~60, not want you want 0~59.

Here is the trick:
Try to find key on ((60-t%60)%60), then the range will become 0~59.