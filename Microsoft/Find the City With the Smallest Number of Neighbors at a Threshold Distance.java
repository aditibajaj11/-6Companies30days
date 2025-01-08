class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] distance=new int[n][n];
        for(int[] row:distance){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        for(int i=0;i<n;i++){
            distance[i][i]=0;
        }

        for(int[] edge:edges){
            int from=edge[0];
            int to=edge[1];
            int weight=edge[2];

            distance[from][to]=weight;
            distance[to][from]=weight;
        }

        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if (distance[i][k] != Integer.MAX_VALUE && distance[k][j] != Integer.MAX_VALUE) {
                        distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                    }
                }
            }
        }
        int minNeighbors=Integer.MAX_VALUE;
        int result=-1;

        for (int i = 0; i < n; i++) {
            int reachableCities = 0;
            for (int j = 0; j < n; j++) {
                if (distance[i][j] <= distanceThreshold) {
                    reachableCities++;
                }
            }

            if (reachableCities < minNeighbors || (reachableCities == minNeighbors && i > result)) {
                minNeighbors = reachableCities;
                result = i;
            }
        }

        return result;
    }
}
