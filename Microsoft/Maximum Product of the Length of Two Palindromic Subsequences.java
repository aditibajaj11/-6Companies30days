class Solution {
    public int maxProduct(String s) {
        int n=s.length();
        int maxproduct=0;

        for(int mask1=1;mask1<(1<<n);mask1++){
            String subseq1=getsubsequence(s,mask1);
            if(!ispalindrome(subseq1)){
                continue;
            }
            for(int mask2=1;mask2<(1<<n);mask2++){
                if((mask1&mask2)!=0){
                    continue;
                }
                String subseq2=getsubsequence(s,mask2);
                if(ispalindrome(subseq2)){
                    maxproduct=Math.max(maxproduct,subseq1.length() * subseq2.length());
                }

            }
        }
        return maxproduct;
    }

    private String getsubsequence(String s, int mask) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if ((mask & (1 << i)) != 0) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    private boolean ispalindrome(String s){
        int left=0,right=s.length()-1;

        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}