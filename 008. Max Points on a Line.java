class Solution {
    public int maxPoints(int[][] points) {
        if(points.length == 1) return 1;
        HashMap<Double, Integer> freq = new HashMap<>();
        int maxPoints = 0;
        for(int i = 0; i < points.length; i++) {
            int x1 = points[i][0], y1 = points[i][1];
            int currSlopeMax = 0;
            for(int j = 0; j < points.length; j++) {
                if(i == j) continue;
                int x2 = points[j][0], y2 = points[j][1];
                double slope = 0;
                if(x1 == x2) slope = Integer.MAX_VALUE;
                else slope = (double)(y2 - y1) / (double)(x2 - x1);
                freq.put(slope, freq.getOrDefault(slope, 0) + 1);
                currSlopeMax = Math.max(currSlopeMax, freq.get(slope));
            }
            freq.clear();
            maxPoints = Math.max(maxPoints, currSlopeMax);
        }
        return maxPoints + 1;
    }
}
