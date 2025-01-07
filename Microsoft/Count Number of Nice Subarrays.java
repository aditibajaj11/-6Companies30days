class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int left=0,right=0;
        int oddcount=0,prefixcount=0;
        int answer=0;

        while(right<nums.length){
            if(nums[right]%2!=0){
                oddcount++;
                prefixcount=0;
            }
            while(oddcount==k){
                if(nums[left]%2!=0){
                    oddcount--;
                }
                prefixcount++;
                left++;
            }
            answer+=prefixcount;
            right++;
        }

        return answer;
        
    }
}