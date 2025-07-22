class Solution {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) 
    {
        int sum = 0;
        for(int i=0;i<nums.size();i++)
        {
            int cnt = 0; //store no. of 1 bits
            int num = i;
            while(num!=0)
            {
                cnt+=num&1; //find if last bit is set
                num=num>>>1; //right shift
            }

            if(cnt==k)
                sum+=nums.get(i);
        }

        return sum;
    }
}