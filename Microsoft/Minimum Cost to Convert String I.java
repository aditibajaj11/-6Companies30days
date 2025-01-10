class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = source.length();
        int alphabetsize = 26;

        
        int[][] minCost = new int[alphabetsize][alphabetsize];
        for (int i = 0; i < alphabetsize; i++) {
            Arrays.fill(minCost[i], Integer.MAX_VALUE / 2); 
            minCost[i][i] = 0; 
        }

        for (int i = 0; i < original.length; i++) {
            int from = original[i] - 'a';
            int to = changed[i] - 'a';
            minCost[from][to] = Math.min(minCost[from][to], cost[i]);
        }

   
        for (int k = 0; k < alphabetsize; k++) {
            for (int i = 0; i < alphabetsize; i++) {
                for (int j = 0; j < alphabetsize; j++) {
                    if (minCost[i][k] < Integer.MAX_VALUE / 2 && minCost[k][j] < Integer.MAX_VALUE / 2) {
                        minCost[i][j] = Math.min(minCost[i][j], minCost[i][k] + minCost[k][j]);
                    }
                }
            }
        }

        
        long totalCost = 0;
        for (int i = 0; i < n; i++) {
            int from = source.charAt(i) - 'a';
            int to = target.charAt(i) - 'a';
            if (minCost[from][to] == Integer.MAX_VALUE / 2) {
                return -1; 
            }
            totalCost += minCost[from][to];
        }

        return totalCost; 
    }
}