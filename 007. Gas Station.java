class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;
        for(int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if(totalCost > totalGas) return -1;
        int idx = 0;
        int myGas = 0;
        for(int i = 0; i < gas.length; i++) {
            myGas = myGas + gas[i] - cost[i];
            if(myGas < 0) {
                idx = i + 1;
                myGas = 0;
            }
        }
        return idx;
    }
}
