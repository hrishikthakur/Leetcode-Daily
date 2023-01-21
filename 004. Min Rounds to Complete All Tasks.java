class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(Integer i : tasks) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int minRounds = 0;
        for(Integer digit : map.keySet()) {
            int freq = map.get(digit);
            if(freq == 1) return -1;
            if(freq % 3 == 0) {
                minRounds += freq / 3;
            } else {
                minRounds += freq / 3 + 1;
            }
        }
        return minRounds;
    }
}
