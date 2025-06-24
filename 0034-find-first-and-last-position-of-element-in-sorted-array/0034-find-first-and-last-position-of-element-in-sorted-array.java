class Solution {
    public int[] searchRange(int[] nums, int target) {
        int S=0;
        int e=nums.length-1;
        int[] arr=new int[2];
        arr[0]=-1;arr[1]=-1;
        while(S<=e){
            if(nums[S]==target){
                arr[0]=S;
                if(arr[1]!=-1) break;
            }
            if(nums[e]==target){
                arr[1]=e;
                if(arr[0]!=-1) break;
            }
            if(nums[S]<target) S++;
            if(nums[e]>target) e--;
        }
        return arr;
    }
}