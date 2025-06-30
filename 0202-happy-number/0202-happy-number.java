class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> hs=new HashSet<>();
        int ans=0;
        while(ans!=1){
            ans=0;
        while(n!=0){
            ans+=Math.pow(n%10,2);
            n=n/10;
        }
        if(hs.contains(ans)){
            return false;
        }
        hs.add(ans);
        n=ans;
        }
        return true;
}
}