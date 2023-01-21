class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        List<int[]> merged = new ArrayList<>();
        for(int[] interval : points) {
            if(merged.isEmpty() || interval[0] > merged.get(merged.size() - 1)[1]) {
                merged.add(interval);
            } else {
                merged.get(merged.size() - 1)[0] = interval[0];
                merged.get(merged.size() - 1)[1] = merged.get(merged.size() - 1)[1];
            }
        }
        return merged.size();
    }
}
