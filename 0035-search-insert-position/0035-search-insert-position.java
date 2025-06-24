class Solution {
    public int searchInsert(int[] nums, int target) {
        int S=0;
        int e=nums.length-1;
        while(S<=e){
            int mid=(S+e)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]<target) S=mid+1;
            else e=mid-1;
        }
        return S;
    }
}