class Solution {
    public int incremovableSubarrayCount(int[] nums) {
        int ans=0;
        int n=nums.length;
        for(int left=0;left<n;left++){
            for(int right=left;right<n;right++){
                boolean incremovable=true;
                if(left>0 && right<n-1){
                    if(nums[left-1]>=nums[right+1]){
                    incremovable=false;
                    }
                }
                
                if (incremovable) {
                    for (int k = 0; k < left - 1; k++) {
                        if (nums[k] >= nums[k + 1]) {
                            incremovable = false;
                            break;
                        }
                    }
                    for (int k = right + 1; k < n - 1; k++) {
                        if (nums[k] >= nums[k + 1]) {
                            incremovable = false;
                            break;
                        }
                    }
                }
                if (incremovable) {
                    ans++;
                }
            }
        }
        return ans; 
    }
}
