class Solution {
    private int[][] rects;
    private int[] prefixSums;
    private Random random; 

    public Solution(int[][] rects) {
        this.rects = rects;
        this.prefixSums = new int[rects.length];
        this.random = new Random();

        int totalArea = 0;
        for (int i = 0; i < rects.length; i++) {
            int[] rect = rects[i];
            int area = (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
            totalArea += area;
            prefixSums[i] = totalArea;
        }
    }
    
    public int[] pick() {
        int target = random.nextInt(prefixSums[prefixSums.length - 1]) + 1;
        int rectIndex = findRectangle(target);
        int[] rect = rects[rectIndex];
        int x = rect[0] + random.nextInt(rect[2] - rect[0] + 1);
        int y = rect[1] + random.nextInt(rect[3] - rect[1] + 1);

        return new int[]{x, y};
    }

    private int findRectangle(int target) {
        int low = 0, high = prefixSums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (prefixSums[mid] >= target) {
                high = mid; 
            } else {
                low = mid + 1; 
            }
        }
        return low;
    }
}
