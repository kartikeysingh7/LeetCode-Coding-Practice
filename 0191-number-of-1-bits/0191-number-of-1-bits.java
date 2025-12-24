class Solution {
    public int hammingWeight(int n) {
        int i=0,res=0;
        while(n>0){
            int r = n%2;
            if(r==1) res++;
            n /=2;
        }
        return res;
    }
}