class Solution {
    public int[][] imageSmoother(int[][] img) {
        int rows=img.length;
        int cols=img[0].length;
        int[][] resultimg=new int[rows][cols];

        int[] directions={-1,0,1};

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                int sum=0;
                int n=0;
                for(int di:directions){
                    for(int dj:directions){
                        int neighi=i+di;
                        int neighj=j+dj;

                        if(neighi>=0 && neighi<rows && neighj>=0 && neighj<cols){
                            sum+=img[neighi][neighj];
                            n++;
                        }
                    }
                }
                resultimg[i][j]+=sum/n;
            }
        }
        return resultimg;
    }
}