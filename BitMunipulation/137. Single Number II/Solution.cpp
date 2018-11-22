class Solution {
public:
    int singleNumber(vector<int>& nums) {
        /*
        ab      c   next_ab
        00      0   00
        01      0   01
        10      0   10
        00      1   01
        01      1   10
        10      1   00
        only count the '1' in next state, use your knowledge in Comp Eng 3DQ5
        */
        int a=0, b=0;
        for (auto c:nums){
            int tmp = (~a&b&c)|(a&~b&~c);
            b = (~a&~b&c)|(~a&b&~c);
            a = tmp;
        }
        return (a|b);
    }
};