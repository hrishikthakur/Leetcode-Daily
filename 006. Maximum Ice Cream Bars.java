class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int iceCount = 0;
        for(Integer cost : costs) {
            if(cost <= coins) {
                coins -= cost;
                iceCount++;
            } else {
                break;
            }
        }
        return iceCount;
    }
}
